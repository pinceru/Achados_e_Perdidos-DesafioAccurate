import { ThemeProvider } from "@mui/material";
import { BrowserRouter } from "react-router-dom";
import { AppRoutes } from "./routes";
import { LightThemes } from "./shared/themes";

export const App = () => {
  return (
    <ThemeProvider theme={LightThemes}>
      <BrowserRouter>
        <AppRoutes/>
      </BrowserRouter>
    </ThemeProvider> 
  );
}

