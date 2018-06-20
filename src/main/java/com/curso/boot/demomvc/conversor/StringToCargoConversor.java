package com.curso.boot.demomvc.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.curso.boot.demomvc.model.Cargo;
import com.curso.boot.demomvc.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo>{
	
	@Autowired
	private CargoService service;

	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) { //para evitar um Exception
			return null;
		}
		Long id = Long.valueOf(text);   //captura o id que veio em formato string
		return service.buscarPorId(id);
	}


	
	
}
