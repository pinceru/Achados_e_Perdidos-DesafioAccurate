interface ITabelaItemProps {
    itens: IItem[]
}

interface IItem {
    nome: string,
    descricao: string,
    data: string,
    telefone:string
}



export const TabelaItem: React.FC<ITabelaItemProps> = (props) => {
    return(
        <table>
            <tr className="linha">
                <td className="coluna">Nome</td>
                <td className="coluna">Telefone</td>
                <td className="coluna">Descrição</td>
                <td className="coluna">Data</td>
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
                        <td className="coluna">Ações</td>
                    </tr>)
                })
            }
        </table>
    )
}