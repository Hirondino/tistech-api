package api.tistech.controllers;

import api.tistech.service.JogoLocalizaPalavrasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class JogoLocalizaPalavrasController {

    @Autowired
    private JogoLocalizaPalavrasServiceImpl service;

    @GetMapping
    public boolean localizaPalavras(@RequestParam String palavra){
        log.info("Iniciando serviço para localizar as palavras");
        return service.resolverJogo(palavra.toUpperCase());
    }

}
