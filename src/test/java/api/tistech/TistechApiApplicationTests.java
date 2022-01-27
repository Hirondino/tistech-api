package api.tistech;


import api.tistech.service.JogoLocalizaPalavrasServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import api.tistech.service.NumberService;

@SpringBootTest
class TistechApiApplicationTests {

	@Autowired
	NumberService numberService;

	@Autowired
	JogoLocalizaPalavrasServiceImpl service;

	@Test
	void contextLoads() {
	}

	@Test
	void thirdNumber() throws Exception {


		String a = "102", b = "512";

		String c = numberService.montagem(a, b);


		Assertions.assertEquals("150122", c);
	}

	@Test
	void thirdNumberMinusOne() throws Exception {


		String a = "10256", b = "512";

		String c = numberService.montagem(a, b);


		Assertions.assertEquals("-1", c);
	}

	@Test
	void searchWord() throws Exception {


		String palavra = "BAIXA";


		Assertions.assertEquals(true, service.resolverJogo(palavra));
	}

}
