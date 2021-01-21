package com.recuperacao.recuperacao.dominio;

public class Aluno {
	private int codaluno;
	private String nome;
	private Integer idade;
	private String email;
	
	public Aluno() {
		
	}
	
	public Aluno(int cod, String string, int ida, String email) {
		this.codaluno = cod;
		this.nome = string;
		this.idade = ida;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodaluno() {
		return codaluno;
	}
	public void setCodaluno(int codaluno) {
		this.codaluno = codaluno;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
