import { useState } from "react"
import { api } from "../../services/api"
import { Link, useNavigate } from "react-router-dom"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'
import { Header } from "../../components"

export const CadastroUsuario = () => {
    const [nome, setNome] = useState('')
    let [telefone, setTelefone] = useState('')
    const [login, setLogin] = useState('')
    const [senha, setSenha] = useState('')
    const history = useNavigate()

    const handleEntrar = () => {
        api.post("/usuario/", {
            nome:nome,
            login:login,
            senha:senha,
            telefone:telefone
        })
        .then((response) => {
            console.log(response.data)
            history('/login')
        })
        .catch(err => {
            console.error(err)
            alert("Dados de cadastro inválidos.")
        })
    }

    return (
        <div className="background">
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            <Header titulo="Cadastro de usuario"></Header>
            <form>
                <div className="divInputs">
                    <div className="divInput">
                        <label className="label">Nome</label>
                        <input className="input" type="text" value={nome} onChange={e => setNome(e.target.value)}
                        minLength={1} maxLength={50} placeholder='João Silva'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Login</label>
                        <input className="input" type="text" value={login} onChange={e => setLogin(e.target.value)}
                        minLength={1} maxLength={50} placeholder='Login'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Senha</label>
                        <input className="input" type="password" value={senha} onChange={e => setSenha(e.target.value)}
                        minLength={3} maxLength={10} placeholder='Senha'/>
                    </div>
                    <div className="divInput">
                        <label className="label">Telefone</label>
                        <input className="input" type="text" value={telefone} onChange={e => setTelefone(e.target.value)}
                        minLength={14} maxLength={15} placeholder='(11) 91111-1111'/>
                    </div>
                    <div className="divInput">
                        <button className="button" type="button" onClick={handleEntrar}>
                            Cadastrar
                        </button>
                    </div>
                </div>
            </form>
            <div className="containerLink">
                <Link className="a2" to="/">    
                    Voltar
                </Link>
            </div> 
            <div className="divOnda">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
        
    )
}