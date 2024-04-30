package swaggercontroller.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class NameController {
	
	@GetMapping("/getName")
	public String getName(@RequestParam String name) {
		return name;
	}
	
	@PostMapping("/oppositeName")
	public String postOppositeName(@RequestBody String name) {
		return new StringBuilder(name).reverse().toString();
	}
	
	
}
