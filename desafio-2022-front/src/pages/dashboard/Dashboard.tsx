import { Link } from "react-router-dom"

export const Dashboard = () => {
    return (
        <div>
            <h1>Achados e perdidos</h1>
            <div>
                <Link to="/login">Entrar</Link>
            </div>
            <div>
                <Link to="">Cadastrar item</Link>
            </div>
            <div>
                <Link to="/cadastro-usuario">Cadastrar-se</Link>
            </div>
        </div>
    )
}