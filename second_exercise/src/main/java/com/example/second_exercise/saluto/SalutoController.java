package com.example.second_exercise.saluto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2")
@RestController
public class SalutoController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/ciao/Lombardia")
	public Saluto salutoByLombardiaMapping(@RequestParam(value = "nome") String nome) {
		return new Saluto(nome, "Lombardia");
	}
	
}
