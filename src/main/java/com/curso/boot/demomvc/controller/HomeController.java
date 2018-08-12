package com.curso.boot.demomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.boot.demomvc.dao.UsuarioDAO;
import com.curso.boot.demomvc.model.Usuario;

@Controller
public class HomeController {
	
	@Autowired
	UsuarioDAO dao;

	@RequestMapping("/")
	public String home(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); //obtém o usuario logado (login)
		
		Usuario usuario = dao.findById(login);  //busca o usuario
		
		model.addAttribute("username", usuario.getNome());  //mostra o nome do usuario
		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
