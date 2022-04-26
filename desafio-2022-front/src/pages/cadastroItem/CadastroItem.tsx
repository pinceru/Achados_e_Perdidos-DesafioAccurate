import { useState } from "react"
import { api } from "../../services/api"
import { Link, useNavigate } from "react-router-dom"
import { DataPicker, Maps } from "../../components"
import { Header } from "../../components/Header"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'

export const CadastroItem = () => {
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [descricao, setDescricao] = useState('')
    const [data, setData] = useState(new Date().toLocaleString().slice(0, 16))
    const [latitude, setLatitude] = useState(0)
    const [longitude, setLongitude] = useState(0)
    const history = useNavigate()

    const handleEntrar = () => {
        console.log(data)
        api.post("/item/", {
            nome:nome,
            telefone:telefone,
            descricao:descricao,
            data:data.toString(),
            status:'ACHADO',
            latitude:latitude,
            longitude:longitude
        })
        .then((response) => {
            console.log(response.data)
            history('/login')
            alert("Item cadastrado com sucesso.")
        })
        .catch(err => {
            console.error(err)
            alert("Dados de casdastro inválidos.")
        })
    }

    return(
        <div className="background">
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            <Header titulo="Cadastro de itens"></Header>
            <form>
                <div className="divInputs">
                    <div className="divInput">
                        <label className="label">Nome</label>
                        <input className="input" type="text" value={nome} onChange={e => setNome(e.target.value)}
                        minLength={1} maxLength={50} placeholder='João Silva'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Telefone</label>
                        <input className="input" type="text" value={telefone} onChange={e => setTelefone(e.target.value)} 
                        minLength={14} maxLength={15} placeholder='(11) 91111-1111'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Descrição</label>
                        <input className="input" type="text" value={descricao} onChange={e => setDescricao(e.target.value)}
                        placeholder='Guarda-chuva amarelo'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Data</label>
                        <DataPicker placeholder="dd/mm/aaaa hh:mm" className="input" onChange={e => setData(e.toLocaleString().slice(0, 16))}></DataPicker>
                    </div>
                    <div className="divInput">
                        <button className="button" type="button" onClick={handleEntrar}>
                            Cadastrar
                        </button>
                    </div>
                    <div className="containerLink">
                        <Link className="a2" to="/">    
                            Voltar
                        </Link>
                    </div> 
                </div>
                
                <Maps width='300px' height='300px' 
                onSetLocation={(coordenadas) => {setLatitude(coordenadas.lat()); setLongitude(coordenadas.lng())
                console.log(latitude, longitude)}}>
                </Maps>
            </form>
            <div className="divOnda">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
    )
}