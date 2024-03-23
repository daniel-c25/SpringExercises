package com.example.first_section.saluto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController {
	
	private static final String saluto = "Ciao %s, com'è il tempo in %s?";
	
	@GetMapping("v1/ciao")
	public String saluto(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "provincia") String provincia) {
		return String.format(saluto, nome, provincia);
	}
	
}
