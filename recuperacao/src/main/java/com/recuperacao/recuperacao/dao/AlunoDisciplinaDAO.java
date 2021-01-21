package com.recuperacao.recuperacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.recuperacao.recuperacao.dominio.AlunoDisciplina;

public class AlunoDisciplinaDAO implements DAO<AlunoDisciplina> {
	
	private String selecionaTodos = "select * from aluno_disciplina";
	private String selecionaPorCod = "select * from aluno_disciplina where id=?";
	private String atualizaPorCod = "update aluno_disciplina set nome = ? where id=?";
	private String exclui = "delete from aluno_disciplina where id=?";
	private String criar = "inser into aluno_disciplina(codaluno, coddisciplina) values (?, ?)";

	Connection conexao;
	PreparedStatement consulta;
	
	public AlunoDisciplinaDAO() {
		super ();
		conexao = FabricaDeConexao.getConnection();
	}
	
	@Override
	public AlunoDisciplina buscaPorCod(int cod) {
		PreparedStatement consulta;
		AlunoDisciplina alunodisciplina = null;
		try {
			consulta = conexao.prepareStatement(selecionaPorCod);
			consulta.setInt(1, cod);
			ResultSet retorno = consulta.executeQuery();
			retorno.next();
			alunodisciplina = new AlunoDisciplina(cod,retorno.getInt("codaluno"),retorno.getInt("coddisciplina"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return alunodisciplina;
	}

	@Override
	public void criar(AlunoDisciplina entity) {
		try {
			consulta = conexao.prepareStatement(criar);
//			consulta.setString(1, entity.getNome());
			consulta.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void atualizar(AlunoDisciplina entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int cod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AlunoDisciplina> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
