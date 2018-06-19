package com.curso.boot.demomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.boot.demomvc.model.Cargo;
import com.curso.boot.demomvc.model.Funcionario;
import com.curso.boot.demomvc.model.UF;
import com.curso.boot.demomvc.service.CargoService;
import com.curso.boot.demomvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private FuncionarioService funcionarioService;	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("funcionarios", funcionarioService.burcarTodos());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		service.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> cargos(){
		return cargoService.burcarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] ufs () {
		return UF.values();
	}
	
	
	
	
	
	
	
	
	
	
}
