package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaMundoSpringMVC")
	public String executa() {
		
		System.out.println("Olá mundo com Spring");
		
		return "ok";
	}

}
