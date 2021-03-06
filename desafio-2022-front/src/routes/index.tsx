import { Routes, Route, Navigate } from "react-router-dom";
import { Login, CadastroUsuario, CadastroItem, Dashboard, HomeItens } from "../pages";
import { AtualizacaoItem } from "../pages/atualizacaoItem/AtualizacaoItem";
import { HistoricoItem } from "../pages/historicoItem/HistoricoItem";

export const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/" element={<Dashboard></Dashboard>}/>
            <Route path="/login" element={<Login></Login>}/>
            <Route path="/cadastro-usuario" element={<CadastroUsuario></CadastroUsuario>}/>
            <Route path="/cadastro-item" element={<CadastroItem></CadastroItem>}/>
            <Route path="/lista-item" element={<HomeItens></HomeItens>}/>
            <Route path="/atualizar/:id" element={<AtualizacaoItem></AtualizacaoItem>}/>
            <Route path="/historico/:id" element={<HistoricoItem></HistoricoItem>}/>
            <Route path="*" element={<Navigate to="/"/>}/>
        </Routes>
    );
}