package com.third_exercise.name;

import org.springframework.stereotype.Service;

@Service
public class NameService {
	
	Name name = new Name("John");
	
	public String getName() {
		return name.getName();
	}
	
	public Name reverseName(Name name) {
		StringBuilder reversedName = new StringBuilder(name.getName()).reverse();
		this.name.setName(reversedName.toString());
		return this.name;
	}
	
}
