import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link, useNavigate } from "react-router-dom"
import { Maps } from "../../shared/components"
import { Header } from "../../shared/components/Header"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'

export const CadastroItem = () => {
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [descricao, setDescricao] = useState('')
    const [data, setData] = useState('')
    const [latitude, setLatitude] = useState(0)
    const [longitude, setLongitude] = useState(0)
    const history = useNavigate()

    const handleEntrar = () => {
        api.post("/item/cadastrar", {
            nome:nome,
            telefone:telefone,
            descricao:descricao,
            data:data,
            status:'ACHADO',
            latitude:latitude,
            longitude:longitude
        })
        .then((response) => {
            console.log(response.data)
            history('/lista-item')
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
                        <input className="input" type="text" value={data} onChange={e => setData(e.target.value)}
                        placeholder='dd/mm/aaaa hh:mm' onFocus={(value) => console.log(value)}/>
                    </div>
                    <div className="divInput">
                        <button className="button" type="button" onClick={handleEntrar}>
                            Cadastrar
                        </button>
                    </div>
                    <div className="containerLink">
                        <Link className="a2" to="/pagina-inicial">    
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