package com.curso.boot.demomvc.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyErrorView implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		//map.forEach((k,v) -> System.out.println(k + " : " + v)); -- para descobrir o nome das variáveis
		
		ModelAndView modelAndView = new ModelAndView("/error");
		modelAndView.addObject("status", status.value());
		if (status.value() == 404) {
			modelAndView.addObject("error", "Página não encontrada!");
			modelAndView.addObject("message", "A url para a página '" + map.get("path") + "' não existe.");
		}
		if (status.value() == 500) {
			modelAndView.addObject("error", "Ocorreu um erro interno no servidor");
			modelAndView.addObject("message", "Tente novamente mais tarde.");
		}
		
		return modelAndView;
	}

}
