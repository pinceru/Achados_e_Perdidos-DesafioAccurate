import { useNavigate } from "react-router-dom"

export interface ITabelaItemProps {
    itens: IItem[]
}

export interface IItem {
    nome: string,
    descricao: string,
    data: string,
    telefone:string,
    status:string,
    id: number
}



export const TabelaItem: React.FC<ITabelaItemProps> = (props) => {
    const history = useNavigate()
    const pushIdAtualizar = (id: number) => {
        history(`/atualizar-item/${id}`)
    }
    const pushIdHistorico = (id: number) => {
        history(`/historico-item/${id}`)
    }

    return(
        <table>
            <tr className="linha">
                <td className="coluna">Nome</td>
                <td className="coluna">Telefone</td>
                <td className="coluna">Descrição</td>
                <td className="coluna">Data</td>
                <td className="coluna">Status</td>
                <td className="coluna">Ações</td>
            </tr>
            {
                props.itens.map((item) => {

                    return(
                    <tr className="linha">
                        <td className="coluna">{item.nome}</td>
                        <td className="coluna">{item.telefone}</td>
                        <td className="coluna">{item.descricao}</td>
                        <td className="coluna">{item.data}</td>
                        <td className="coluna">{item.status}</td>
                        <td className="coluna">
                            <button className="button2" onClick={() => {pushIdAtualizar(item.id)}}>
                                Atualizar
                            </button>
                            <button className="button2" onClick={() => {pushIdHistorico(item.id)}}>
                                Histórico
                            </button>
                        </td>
                    </tr>)
                })
            }
        </table>
    )
}