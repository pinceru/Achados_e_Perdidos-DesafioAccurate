import './HomeItens.css'
import { TabelaItem } from './components/TabelaItem'
import { useEffect, useMemo, useState } from 'react'
import { api, registrarToken } from '../../shared/services/api'
import { getItem } from '../../shared/services/cookie'

interface IItem {
    nome: string,
    data: string,
    descricao: string,
    telefone: string
}

export const HomeItens = () => {
    const[item, setItem] = useState<IItem[]>([])

    const token = getItem('token')
    registrarToken(token)
    useEffect(() => {
        api.get('/item/listar')
        .then((response) => setItem(response.data.content))
        .catch((err) => {
            console.error('Ocorreu o erro' + err)
        })
    }, [])

    return(
        <TabelaItem itens={item}></TabelaItem>
    )
}