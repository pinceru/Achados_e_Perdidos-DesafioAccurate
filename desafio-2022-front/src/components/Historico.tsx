
import {IItem, ITabelaItemProps} from "./TabelaItem"

export const Historico: React.FC<ITabelaItemProps> = (props) => {
    return(
        <table>
        <tr className="linha">
            <td className="coluna">Item</td>
            <td className="coluna">Data</td>
            <td className="coluna">Status</td>
        </tr>
        {
            props.itens.map((item) => {
                return(
                <tr className="linha">
                    <td className="coluna">{item.descricao}</td>
                    <td className="coluna">{item.data}</td>
                    <td className="coluna">{item.status}</td>
                </tr>)
            })
        }
    </table>
    )
}