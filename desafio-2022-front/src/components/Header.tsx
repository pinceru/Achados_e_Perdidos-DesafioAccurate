interface IHeaderProps{
    titulo:string
}

export const Header: React.FC<IHeaderProps> = ({titulo}) => {
    
    return(
        <div className="header"> 
            <h1>{titulo}</h1>
        </div>
    )
}
