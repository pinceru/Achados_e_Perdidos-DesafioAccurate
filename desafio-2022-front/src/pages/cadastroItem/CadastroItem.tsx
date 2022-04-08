import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link } from "react-router-dom"

export const CadastroItem = () => {
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [descricao, setDescricao] = useState('')
    const [data, setData] = useState('')
    const [latitude, setLatitude] = useState('')
    const [longitude, setLongitude] = useState('')

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
        .then((response) => console.log(response.data))
        .catch(err => {
            console.error(err)
        })
    }

    return(
        <div>
            <form>
                <div>
                    <label>Nome</label>
                    <input type="text" value={nome} onChange={e => setNome(e.target.value)}/>
                </div>
                <div>
                    <label>Telefone</label>
                    <input type="text" value={telefone} onChange={e => setTelefone(e.target.value)}/>
                </div>
                <div>
                    <label>Descrição</label>
                    <input type="text" value={descricao} onChange={e => setDescricao(e.target.value)}/>
                </div>
                <div>
                    <label>Data</label>
                    <input type="text" value={data} onChange={e => setData(e.target.value)}/>
                </div>
                <div>
                    <label>Latitude</label>
                    <input type="text" value={latitude} onChange={e => setLatitude(e.target.value)}/>
                </div>
                <div>
                    <label>Longitude</label>
                    <input type="text" value={longitude} onChange={e => setLongitude(e.target.value)}/>
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