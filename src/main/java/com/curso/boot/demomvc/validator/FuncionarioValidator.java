package com.curso.boot.demomvc.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.curso.boot.demomvc.model.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Funcionario f = (Funcionario) object;
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSaida() != null ) { //visto que o campo de saída não é obrigatório
			if(f.getDataSaida().isBefore(entrada))
			errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
		}
	}

}
