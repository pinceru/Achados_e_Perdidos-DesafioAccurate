import { Link } from "react-router-dom"
import '../../shared/style/style.css'
import wave from '../../../src/imgs/Vector.png'
import otherwave from '../../../src/imgs/Vector1.png'
import globo from '../../../src/imgs/Destination-rafiki.png'
import { Header } from "../../components"

export const Dashboard = () => {
    return (
        <div className="background">
            <div className="divOnda">
                <img className="imgOnda" src={otherwave}/>
            </div>
            
            <div className="linhaDashboard">
            
                <div className="containerBotoes">
                <Header titulo="Achados e perdidos"></Header>
                    <div className="controle">
                        <div className="containerLink">
                            <Link className="a" to="/login">
                                <div className="botao">
                                    Entrar
                                </div>
                            </Link>
                        </div>
                        <div className="containerLink">
                            <Link className="a" to="/cadastro-item">
                                <div className="botao">
                                    Cadastrar item
                                </div>
                            </Link> 
                        </div>
                        <div className="containerLink">
                            <Link className="a" to="/cadastro-usuario">
                                <div className="botao">
                                    Cadastrar-se
                                </div>
                            </Link>
                        </div>
                    </div>
                     
                </div> 
                <div className="img">
                    <img className="imagemDashboard" src={globo}/>
                </div>
            </div>
            <div className="divOnda">
                <img className="imgOnda" src={wave}/>
            </div>
        </div>
    )
}