import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link } from "react-router-dom"

export const CadastroUsuario = () => {
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [login, setLogin] = useState('')
    const [senha, setSenha] = useState('')

    const handleEntrar = () => {
        api.post("/usuario/cadastrar", {
            nome:nome,
            login:login,
            senha:senha,
            telefone:telefone
        })
        .then((response) => console.log(response.data))
        .catch(err => {
            console.error(err)
        })
    }

    return (
        <div>
            <form>
                <div>
                    <label>Nome</label>
                    <input type="text" value={nome} onChange={e => setNome(e.target.value)}/>
                </div>
                <div>
                    <label>Login</label>
                    <input type="text" value={login} onChange={e => setLogin(e.target.value)}/>
                </div>
                <div>
                    <label>Senha</label>
                    <input type="password" value={senha} onChange={e => setSenha(e.target.value)}/>
                </div>
                <div>
                    <label>Telefone</label>
                    <input type="text" value={telefone} onChange={e => setTelefone(e.target.value)}/>
                </div>
                <div>
                    <button type="button" onClick={handleEntrar}>
                        Cadastrar
                    </button>
                </div>
            </form>
            <div>
                <Link to="/pagina-inicial">Voltar para página inicial</Link>
            </div>
        </div>
        
    )
}