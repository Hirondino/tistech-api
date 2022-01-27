package api.tistech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.tistech.service.NumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api
@RequestMapping("")
@Slf4j
public class NumberController {

	
	@Autowired
	NumberService numberService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma terceira string C"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@RequestMapping(value = "/retornarC", method = RequestMethod.GET, produces="application/json")
	public String terceiroC(@RequestParam("a") String a, @RequestParam("b") String b) {
		log.info("Iniciando serviço de Terceiro C!");
		String c = numberService.montagem(a, b);
		log.info("Valor retornado de C = " + c);
		return c;
	}
}
