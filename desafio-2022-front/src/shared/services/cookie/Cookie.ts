import {parseCookies, setCookie} from 'nookies'

export const setItem = (chave:string, valor:any) => {
    setCookie(null, chave, JSON.stringify(valor), {
        maxAge: 30 * 24 * 60 * 60,
        path: '/',
    })
}

export const getItem = (chave:string) => {
    const cookiesParsed = parseCookies(null)

        if (typeof cookiesParsed[chave] !== 'undefined') {
            return JSON.parse(cookiesParsed[chave])
        }
    return false
}