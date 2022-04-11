import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link, useNavigate } from "react-router-dom"
import { setItem } from "../../shared/services/cookie"

export const Login = () => {
    const [login, setLogin] = useState("")
    const [senha, setSenha] = useState("")
    const history = useNavigate()
    const handleEntrar = () => {
        
        api.post("/auth", {
            login:login,
            senha:senha
        })
        .then((response) => {setItem('token', response.data.token)})
        .catch(err => {
            console.error(err)
        })
        history('/lista-item')
    }

    return(
        <div>
            <h1>Login</h1>
            <form>
                <div>
                    <label>Login</label>
                    <input type="text" value={login} onChange={e => setLogin(e.target.value)}/>
                </div>
                <div>
                    <label>Senha</label>
                    <input type="password" value={senha} onChange={e => setSenha(e.target.value)}/>
                </div>
                <div>
                    <button type="button" onClick={handleEntrar}>
                        Entrar
                    </button>
                </div>
            </form>
            <div>
                <Link to="/pagina-inicial">Voltar para página inicial</Link>
            </div>
        </div>
    )
}