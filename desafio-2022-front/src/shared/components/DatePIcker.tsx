import BaseDatePicker, {registerLocale} from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import ptBr from "date-fns/locale/pt-BR"
import { useState } from 'react'

registerLocale("pt-BR", ptBr)

interface IData {
    onChange: (value:Date) => void,
    placeholder: string,
    className: string
}

export const DataPicker = ({className, placeholder, onChange}:IData) => {
    const [data, setData] = useState<Date>()

    return(
        <BaseDatePicker dateFormat = "dd/MM/yyyy HH:mm" className={className}
        locale="pt-BR" showTimeSelect selected={data} placeholderText={placeholder} 
        onChange={(value:Date) => {setData(value); onChange(value)}}>

        </BaseDatePicker>
    )    
}

