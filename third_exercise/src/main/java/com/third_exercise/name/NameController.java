package com.third_exercise.name;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class NameController {
	
	NameService nameService = new NameService();

	public NameController(NameService nameService) {
		this.nameService = nameService;
	}
	
	@GetMapping("/name")
	public String getName() {
		return nameService.getName();
	}
	
	@PostMapping("/name")
	public Name reverseName(@RequestBody Name name) {
		return nameService.reverseName(name);
	}
	
}
