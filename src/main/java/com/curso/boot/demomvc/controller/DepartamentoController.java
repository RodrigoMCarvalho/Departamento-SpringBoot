package com.curso.boot.demomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.boot.demomvc.model.Departamento;
import com.curso.boot.demomvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		List<Departamento> departamentos = service.burcarTodos();
		ModelAndView modelAndView = new ModelAndView("/departamento/lista");
		modelAndView.addObject("departamentos", departamentos);
		return modelAndView;
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		service.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable ("id") Long id, Model model) {
		Departamento departamento = service.buscarPorId(id);
		model.addAttribute("departamento",departamento);
		return "/departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		service.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		if(!service.departamentoTemCargos(id)) {  //se o departamento não conter cargos
			service.excluir(id);
		}
		return "redirect:/departamentos/listar";
	}
	
	
	
	
	
	
	
	
}
