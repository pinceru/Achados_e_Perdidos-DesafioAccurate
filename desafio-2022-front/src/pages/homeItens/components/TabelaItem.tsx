interface ITabelaItemProps {
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
                <tr className="linha">
                    <td className="coluna">{props.nome}</td>
                    <td className="coluna">{props.telefone}</td>
                    <td className="coluna">{props.descricao}</td>
                    <td className="coluna">{props.data}</td>
                    <td className="coluna">Ações</td>
                </tr>
            </table>
        
    )
}