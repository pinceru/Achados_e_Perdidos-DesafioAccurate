import { Routes, Route, Navigate } from "react-router-dom";
import { Login, CadastroUsuario, CadastroItem, Dashboard, HomeItens } from "../pages";

export const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/pagina-inicial" element={<Dashboard></Dashboard>}/>
            <Route path="/login" element={<Login></Login>}/>
            <Route path="/cadastro-usuario" element={<CadastroUsuario></CadastroUsuario>}/>
            <Route path="/cadastro-item" element={<CadastroItem></CadastroItem>}/>
            <Route path="/lista-item" element={<HomeItens></HomeItens>}/>
            <Route path="*" element={<Navigate to="/pagina-inicial"/>}/>
        </Routes>
    );
}