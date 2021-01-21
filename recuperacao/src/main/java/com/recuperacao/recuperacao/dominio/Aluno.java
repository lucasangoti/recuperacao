package com.recuperacao.recuperacao.dominio;

import java.util.List;

public class Aluno {
	private int codaluno;
	private String nome;
	private List<Disciplina> disciplinas;
	
	
	public Aluno(int cod, String string) {
		// TODO Auto-generated constructor stub
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
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	

}
