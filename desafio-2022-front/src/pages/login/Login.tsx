import { useState } from "react"
import { api } from "../../services/api"
import { Link, useNavigate } from "react-router-dom"
import { setItem } from "../../services/cookie"
import { Header } from "../../components/Header"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'

export const Login = () => {
    const [login, setLogin] = useState("")
    const [senha, setSenha] = useState("")
    const history = useNavigate()
    const handleEntrar = () => {
        
        api.post("/auth", {
            login:login,
            senha:senha
        })
        .then((response) => {
            setItem('token', response.data.token)
            history('/lista-item')
        })
        .catch(err => {
            console.error(err)
            alert("Dados de login inválidos.")
        })
    }

    return(
        <div className="background">
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            <div className="temporario"></div>
            <Header titulo="Login"></Header>
            <form>
                <div className="divInputs">
                    <div className="divInput">
                        <label className="label">Login</label>
                        <input placeholder="Login" className="input" type="text" value={login} onChange={e => setLogin(e.target.value)}/>
                    </div>
                    <div className="divInput">
                        <label className="label">Senha</label>
                        <input placeholder="Senha" className="input" type="password" value={senha} onChange={e => setSenha(e.target.value)}/>
                    </div>
                    <div>
                        <button className="button1" type="button" onClick={handleEntrar}>
                            Entrar
                        </button>
                    </div>
                </div>
            </form>
            <div className="containerLink">
                <Link className="a2" to="/pagina-inicial">    
                    Voltar
                </Link>
            </div> 
            <div className="divOnda">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
    )
}