package com.recuperacao.recuperacao.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	
	@GetMapping("/") 
	public String home () {
		return "home";
	}
	
}
