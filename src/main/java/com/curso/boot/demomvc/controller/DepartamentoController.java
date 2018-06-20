package com.curso.boot.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/departamento/cadastro";
		}
		
		service.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento cadastrado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String popularEditar(@PathVariable ("id") Long id, Model model) {
		Departamento departamento = service.buscarPorId(id);
		model.addAttribute("departamento",departamento);
		return "/departamento/cadastro";
	}
	
	@PostMapping("/editar") //é usado RedirectAttributes e não Model, devido ao returno "redirect"
	public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) { 
		
		if(result.hasErrors()) {
			return "/departamento/cadastro";
		}
		
		service.editar(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(service.departamentoTemCargos(id)) {  
			attr.addFlashAttribute("fail", "Departamento não removido, pois exitem cargo(s) vinculado(s).");
		} else {    				
			service.excluir(id);  //se o departamento não conter cargos será excluído
			attr.addFlashAttribute("success", "Departamento excluído com sucesso.");
		}
		return "redirect:/departamentos/listar";
	}
	
	
	
	
	
	
	
	
}
