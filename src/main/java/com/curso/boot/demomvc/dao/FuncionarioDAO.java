package com.curso.boot.demomvc.dao;

import java.util.List;

import com.curso.boot.demomvc.model.Funcionario;

public interface FuncionarioDAO {
	
	public void save( Funcionario funcionario);
	public void update(Funcionario funcionario);
	public void delete(Long id);
	public Funcionario findById(Long id) ;
	public List<Funcionario> findAll();

}
