import { Routes, Route, Navigate } from "react-router-dom";
import { Login, CadastroUsuario, Dashboard } from "../pages";

export const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/pagina-inicial" element={<Dashboard></Dashboard>}/>
            <Route path="/login" element={<Login></Login>}/>
            <Route path="/cadastro-usuario" element={<CadastroUsuario></CadastroUsuario>}/>
            <Route path="*" element={<Navigate to="/pagina-inicial"/>}/>
        </Routes>
    );
}