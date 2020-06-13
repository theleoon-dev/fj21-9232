package br.com.caelum.tarefas.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {
	
	@Autowired
	private JdbcTarefaDao dao;

	@RequestMapping("novaTarefa")
	public String formulario() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String salvar(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista (Model model) {
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remover(Tarefa tarefa) {
		dao.remove(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaAgora")
	public void finalizaTarefa(Long id, HttpServletResponse resp) throws IOException {
		dao.finaliza(id);
		
		Tarefa tarefaFinalizada = dao.buscaPorId(id);
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(tarefaFinalizada.getDataFinalizacao().getTime());
		
		resp.getWriter().write(dataFormatada);

	}
	
	
	
	
	
	
	
	
	
	

}
