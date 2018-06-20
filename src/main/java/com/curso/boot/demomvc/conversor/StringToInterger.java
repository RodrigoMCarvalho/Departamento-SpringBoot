package com.curso.boot.demomvc.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInterger implements Converter<String, Integer>{

	@Override
	public Integer convert(String text) {
		text = text.trim();  //trim() - remover espaço em branco no final de uma String
		
		if(text.matches("[0-9]+")) {
			return Integer.valueOf(text);
		}
		return null; //irá seguir a validação do @NotNull da entidade
	}

	
}
