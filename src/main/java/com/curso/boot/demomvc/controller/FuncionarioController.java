package com.curso.boot.demomvc.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;
	
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
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/funcionario/cadastro";
		}
		
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário(a) cadastrado(a) com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String populaEditar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/funcionario/cadastro";
		}
		
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionário(a) editado(a) com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcionarioService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário(a) excluído(a) com sucesso");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String buscaPorNomes(@RequestParam("nome") String nome, Model model) {
		model.addAttribute("funcionarios", funcionarioService.buscaPorNome(nome) );
		return "/funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String buscaPorCagos(@RequestParam("id") Long id, Model model) {
		model.addAttribute("funcionarios", funcionarioService.buscaPorCargo(id));
		return "/funcionario/lista";
	}
	
	@GetMapping("/buscar/data")                        //DateTimeFormat para formatar String para Date
	public String buscaPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = ISO.DATE) LocalDate entrada,
								@RequestParam("saida") @DateTimeFormat(iso = ISO.DATE) LocalDate saida, 
								Model model) {
		model.addAttribute("funcionarios", funcionarioService.buscaPorData(entrada, saida));
		return "/funcionario/lista";
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
