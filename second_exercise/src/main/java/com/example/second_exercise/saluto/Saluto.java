package com.example.second_exercise.saluto;


public class Saluto {
	
	private String nome;   
	private String provincia;   
	private String saluto = "Ciao %s, com'è il tempo in %s?";
	
	public Saluto(String nome, String provincia) {
		this.nome = nome;
		this.provincia = provincia;
		this.saluto = String.format(saluto, nome, provincia);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSaluto() {
		return saluto;
	}
	
}
