import axios from "axios";

export const api = axios.create({

})

export const registrarToken = (token) => {
    api.defaults.headers.common["Authorization"] = `Bearer ${token}`
}
