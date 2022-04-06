import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link } from "react-router-dom"

export const Login = () => {
    const [login, setLogin] = useState("")
    const [senha, setSenha] = useState("")

    const handleEntrar = () => {
        api.post("/auth", {
            login:login,
            senha:senha
        })
        .then((response) => console.log(response.data))
        .catch(err => {
            console.error(err)
        })
    }

    return(
        <div>
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