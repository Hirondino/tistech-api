package api.tistech.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NumberService {

	public static String montagem(String a, String b) {
		log.info("Montando o terceiro(C)");
		String resultado = montar(a, b, 0);
		return Integer.parseInt(resultado) > 1_000_000 ? "-1" : resultado;
	}

	private static String montar(String a, String b, int cursor) {
		log.info("Montando os caracters ...");

		if (cursor == a.length() && b.length() == a.length()) {
			return "";
		}

		if (cursor == a.length() - 1 && b.length() > a.length()) {
			return a.charAt(cursor) + b.substring(cursor);
		}

		if (cursor == b.length() - 1 && b.length() < a.length()) {
			return b.charAt(cursor) + a.substring(cursor);
		}

		String temp = "" + a.charAt(cursor) + b.charAt(cursor);
		return temp + montar(a, b, cursor + 1);
	}

}
