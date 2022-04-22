import './HomeItens.css'
import { TabelaItem } from './components/TabelaItem'
import { Paginacao } from './components/Paginacao'
import { useEffect, useState } from 'react'
import { api, registrarToken } from '../../shared/services/api'
import { getItem } from '../../shared/services/cookie'
import { Header } from '../../shared/components'
import { Link } from 'react-router-dom'
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'

interface IItem {
    nome: string,
    data: string,
    descricao: string,
    telefone: string,
    status:string,
    id: number
}

export interface IItemReponse {
    content: IItem[],    
    totalElements: number,     
    size: number,
}

export const HomeItens = () => {
    const[item, setItem] = useState<IItemReponse>({content: [] as IItem[]} as IItemReponse)

    const token = getItem('token')
    registrarToken(token)
    useEffect(() => {
        api.get('/item/listar')
        .then((response) => {
            setItem(response.data)
        })
        .catch((err) => {
            console.error('Ocorreu o erro' + err)
            alert("Houve algum erro ao carregar os itens.")
        })
    }, [])

    return(
        <div className='background'>
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            <div>
                <Header titulo='Home de itens'></Header>
                <TabelaItem itens={item.content}></TabelaItem>
                <Paginacao totalItens={item.totalElements} setItem={setItem}></Paginacao>
            </div>
            <div className="containerLink2">
                <Link className="a3" to="/pagina-inicial">    
                    Sair
                </Link>
            </div>
            <div className="divOnda2">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
    )
}