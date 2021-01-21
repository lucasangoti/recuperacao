package com.recuperacao.recuperacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recuperacao.recuperacao.dominio.Aluno;

public class AlunoDAO implements DAO<Aluno> {

	private String selecionaTodos = "select * from alunos";
	private String selecionaPorCod = "select * from alunos where codaluno=?";
	private String atualizaPorCod = "update alunos set nome = ? where codaluno=?";
	private String exclui = "delete from alunos where codaluno=?";
	private String criar = "inser into alunos(nome) values (?)";
	
	
	Connection conexao;
	PreparedStatement consulta;
	
	public AlunoDAO() {
		super ();
		conexao = FabricaDeConexao.getConnection();
	}
	
	@Override
	public Aluno buscaPorCod(int cod) {
		PreparedStatement consulta;
		Aluno aluno = null;
		try {
			consulta = conexao.prepareStatement(selecionaPorCod);
			consulta.setInt(1, cod);
			ResultSet retorno = consulta.executeQuery();
			retorno.next();
			aluno = new Aluno(cod,retorno.getString("nome"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return aluno;
	}

	@Override
	public void criar(Aluno entity) {
		try {
			consulta = conexao.prepareStatement(criar);
			consulta.setString(1, entity.getNome());
			consulta.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void atualizar(Aluno entity) {
		try {
			consulta = conexao.prepareStatement(atualizaPorCod);
			consulta.setString(1, entity.getNome());
			consulta.setInt(2, entity.getCodaluno());
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
	public List<Aluno> buscarTodos() {
		List<Aluno> lista = new ArrayList<Aluno> ();
		try {
			consulta = conexao.prepareStatement(selecionaTodos);
			ResultSet retorno = consulta.executeQuery();
			while (retorno.next()) {
				Aluno aluno = new Aluno(retorno.getInt("codaluno"),retorno.getString("nome"));
				lista.add(aluno);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
}
