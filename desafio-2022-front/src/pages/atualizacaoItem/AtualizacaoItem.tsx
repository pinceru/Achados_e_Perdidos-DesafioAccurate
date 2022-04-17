import { useEffect, useState } from "react"
import { Link, useNavigate, useParams } from "react-router-dom"
import { Header } from "../../shared/components"
import { api, registrarToken } from "../../shared/services/api"
import { getItem } from "../../shared/services/cookie"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'

interface IItemAtualizar {
    nome: string,
    telefone: string,
    descricao: string,
    data: string,
    status: string,
    latitude: string,
    longitude: string
}

export const AtualizacaoItem = () => {
    const history = useNavigate()
    const {id} = useParams()
    const [item, setItem] = useState<IItemAtualizar>({} as IItemAtualizar)
    const [data, setData] = useState('')
    const [status, setStatus] = useState('')

    useEffect(() => {
        console.log(id)
        const token = getItem('token')
        registrarToken(token)
        api.get(`/item/buscar/${id}`)
        .then((response) => {
            setItem(response.data)
        })
        .catch((err) => {
            console.error('Ocorreu o erro' + err)
            alert("Não foi possível carregar os dados do item.")
            history("/lista-item")
        })
    }, [])

    
    const handleAtualizar = () => {
        const token = getItem('token')
        registrarToken(token)
        api.put(`/item/atualizar/${id}`, {
            nome: item.nome,
            telefone: item.telefone,
            descricao: item.descricao,
            data:data,
            status: status,
            latitude: item.latitude,
            longitude: item.longitude
        })
        .then((response) => {
            console.log(response.data)
            history("/lista-item")
        })
        .catch(err => {
            console.error(err)
            alert("Não foi possível atualizar o item. Talvez você não o tenha cadastrado.")
        })
    }

    console.log(item)
    return(
        <div className="background">
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            <Header titulo="Atualizaçao de item"></Header>
            <div className="divInputs">
                <div className="divInput">
                    <label className="label">Nome</label>
                    <input className="input" type="text" value={item.nome}
                    minLength={1} maxLength={50}/>
                </div>
                <div className="divInput">
                    <label className="label">Telefone</label>
                    <input type="text" value={item.telefone} 
                    minLength={14} maxLength={15} className="input"/>
                </div>
                <div className="divInput">
                    <label className="label">Descrição</label>
                    <input className="input" type="text" value={item.descricao}/>
                </div>
                <div className="divInput">
                    <label className="label">Data</label>
                    <input className="input" type="text" value={data} onChange={e => setData(e.target.value)}
                    placeholder='dd/mm/aaaa hh:mm' onFocus={(value) => console.log(value)}/>
                </div>
                <div className="divInput">
                    <label className="label">Status</label>
                    <select defaultValue={item.status} onChange={e => setStatus(e.target.value)}>
                        <option value='ACHADO'>Achado</option>
                        <option value='SOLICITADO'>Solicitado</option>
                        <option value='DEVOLVIDO'>Devolvido</option>
                    </select>
                </div>
                <div className="divInput">
                    <button className="button" type="button" onClick={handleAtualizar}>
                        Atualizar
                    </button>
                </div>
            </div>
            <div className="containerLink">
                <Link className="a2" to="/lista-item">    
                    Voltar
                </Link>
            </div> 
            <div className="divOnda">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
    )
}