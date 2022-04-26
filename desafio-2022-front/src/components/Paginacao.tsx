import { useState } from "react"
import { api, registrarToken } from "../services/api"
import { getItem } from "../services/cookie"
import { IItemReponse } from "../pages/homeItens/HomeItens"

interface IPaginacao {
    totalItens: number
    itensPagina?: number
    setItem: (itens: IItemReponse) => void
}
  
const paginasArray = (from: number, to: number) => {
    return [...new Array(to - from)].map((_, i) => from + i + 1).filter((page) => page >= 0)
}
  
export const Paginacao = ({totalItens, itensPagina = 10, setItem}: IPaginacao) => {
    const [paginaAtual, setPaginaAtual] = useState(1)
    const siblingsCount = 1;
    const ultimaPagina = Math.ceil(totalItens / itensPagina);
    const paginaAnterior = paginaAtual > 1 ? paginasArray(paginaAtual - 1 - siblingsCount, paginaAtual - 1) : []
    const proxmasPaginas = paginaAtual < ultimaPagina ? paginasArray(paginaAtual, Math.min(paginaAtual + siblingsCount, ultimaPagina)) : []
    
    const mudarPagina = (page = 1, size = 10) => {
        setPaginaAtual(page)
        const token = getItem('token')
        registrarToken(token)
        api.get('/item/', {params:{page, size}})
        .then((response) => {
            setItem(response.data)
        })
        .catch((err) => {
            console.error('Ocorreu o erro' + err)
            alert("Erro ao carregar páginas.")
        })
    }
    return (
      <div className="paginacao">
        <div>
            <strong>{itensPagina * paginaAtual - itensPagina}</strong> -{" "}
            <strong>{itensPagina * paginaAtual}</strong> de{" "}
            <strong>{totalItens}</strong>
        </div>
        <div>
            {paginaAtual > 1 + siblingsCount && (
                <>
                    <button className="buttonPaginacao" onClick={() => mudarPagina()}> 1 </button>{" "}
                    {paginaAtual > 2 + siblingsCount && (
                        <span>...</span>
                    )}
                </>
            )}
  
            {paginaAnterior.length > 0 && paginaAnterior.map((page) => (<button className="buttonPaginacao" onClick={() => mudarPagina(page)} key={page}>{page}</button>))}
            <button className="buttonPaginacao" onClick={() => mudarPagina(paginaAtual)}>{paginaAtual}</button>
            {proxmasPaginas.length > 0 && proxmasPaginas.map((page) => (
                <button className="buttonPaginacao" onClick={() => mudarPagina(page)} key={page}>{page}</button>
            ))}
  
            {paginaAtual + siblingsCount < ultimaPagina && (
                <>
                {paginaAtual + 1 + siblingsCount < ultimaPagina && (
                    <span>...</span>
                )}
                <button className="buttonPaginacao" onClick={() => mudarPagina(ultimaPagina)}>{ultimaPagina}</button>
                </>
            )}
            </div>
        </div>
    );
};