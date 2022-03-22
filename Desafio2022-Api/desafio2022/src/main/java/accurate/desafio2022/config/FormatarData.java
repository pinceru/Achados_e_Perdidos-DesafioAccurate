package accurate.desafio2022.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarData {
	public static LocalDateTime formatarData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
		return dateTime;
	}
}
