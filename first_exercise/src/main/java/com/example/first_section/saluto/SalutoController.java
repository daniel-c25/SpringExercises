package com.example.first_section.saluto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class SalutoController {
	
	private static final String saluto = "Ciao %s, com'è il tempo in %s?";
	
	@RequestMapping(method = RequestMethod.GET, path = "ciao")
	public String saluto(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "provincia") String provincia) {
		return String.format(saluto, nome, provincia);
	}
	
}
