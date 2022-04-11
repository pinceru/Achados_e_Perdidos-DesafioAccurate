import { useState } from "react"
import { api } from "../../shared/services/api"
import { Link } from "react-router-dom"
import { Maps } from "../../shared/components"

export const CadastroItem = () => {
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [descricao, setDescricao] = useState('')
    const [data, setData] = useState('')
    const [latitude, setLatitude] = useState(0)
    const [longitude, setLongitude] = useState(0)

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
                <Maps width='300px' height='300px' 
                onSetLocation={(coordenadas) => {setLatitude(coordenadas.lat()); setLongitude(coordenadas.lng())}}>

                </Maps>
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