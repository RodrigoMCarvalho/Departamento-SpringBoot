package com.curso.boot.demomvc.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.curso.boot.demomvc.model.Departamento;
import com.curso.boot.demomvc.service.DepartamentoService;

@Component
public class DepartamentoConversor implements Converter<String, Departamento> {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;  //para evitar um Exception
		}
		Long id = Long.valueOf(text);  //captura o id que veio em formato string
		return departamentoService.buscarPorId(id);
	}

}
