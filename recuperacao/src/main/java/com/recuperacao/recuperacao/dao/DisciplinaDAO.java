package com.recuperacao.recuperacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recuperacao.recuperacao.dominio.Disciplina;

public class DisciplinaDAO implements DAO<Disciplina> {
	
	private String selecionaTodos = "select * from disciplinas";
	private String selecionaPorCod = "select * from disciplinas where coddisciplina=?";
	private String atualizaPorCod = "update disciplinas set nome = ? where coddisciplina=?";
	private String exclui = "delete from disciplinas where coddisciplina=?";
	private String criar = "inser into disciplinas(nome) values (?)";

	Connection conexao;
	PreparedStatement consulta;
	
	public DisciplinaDAO() {
		super ();
		conexao = FabricaDeConexao.getConnection();
		}
	
	@Override
	public Disciplina buscaPorCod(int cod) {
		PreparedStatement consulta;
		Disciplina disciplina = null;
		try {
			consulta = conexao.prepareStatement(selecionaPorCod);
			consulta.setInt(1, cod);
			ResultSet retorno = consulta.executeQuery();
			retorno.next();
			disciplina = new Disciplina(cod,retorno.getString("nome"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return disciplina;
	}

	@Override
	public void criar(Disciplina entity) {
		try {
			consulta = conexao.prepareStatement(criar);
			consulta.setString(1, entity.getNome());
			consulta.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void atualizar(Disciplina entity) {
		try {
			consulta = conexao.prepareStatement(atualizaPorCod);
			consulta.setString(1, entity.getNome());
			consulta.setInt(2, entity.getCoddisciplina());
			consulta.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void excluir(int cod) {
		try {
			consulta = conexao.prepareStatement(exclui);
			consulta.setInt(1, cod);
			consulta.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Disciplina> buscarTodos() {
		List<Disciplina> lista = new ArrayList<Disciplina> ();
		try {
			consulta = conexao.prepareStatement(selecionaTodos);
			ResultSet retorno = consulta.executeQuery();
			while (retorno.next()) {
				Disciplina disciplina = new Disciplina(retorno.getInt("coddisciplina"),retorno.getString("nome"));
				lista.add(disciplina);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	}


