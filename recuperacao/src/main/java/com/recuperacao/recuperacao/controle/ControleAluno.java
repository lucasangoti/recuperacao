package com.recuperacao.recuperacao.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recuperacao.recuperacao.dao.AlunoDAO;
import com.recuperacao.recuperacao.dominio.Aluno;

@Controller
public class ControleAluno {
		
	AlunoDAO dao = new AlunoDAO();
	
	@GetMapping("/alunos") 
	public String alunos (Model modelo) {
		List<Aluno> lista = dao.buscarTodos();
		modelo.addAttribute("alunos",lista);
		return "alunos";
	}
	
	@GetMapping("/cadastrar-aluno") 
	public String cadastro (Model modelo) {
		modelo.addAttribute("aluno", new Aluno());
		return "cadastrar-aluno";
	}
	
	@PostMapping("cadastrar")
	public String cadastrar(Aluno aluno) {
		dao.criar(aluno);
		return "redirect:/alunos";
	}
	
	@GetMapping("excluir")
	public String excluir(@RequestParam("id") int id) {
		dao.excluir(id);
		return "redirect:/alunos";
	}
	
	@GetMapping("editar")
	public String editar(@RequestParam("id") int id, Model modelo) {
		Aluno aluno = dao.buscaPorCod(id);
		modelo.addAttribute("aluno", aluno);
		return "editar-aluno";
	}
	
	@PostMapping("salvar")
	public String salvar (Aluno aluno) {
		dao.atualizar(aluno);
		return "redirect:/alunos";
	}
	

}
