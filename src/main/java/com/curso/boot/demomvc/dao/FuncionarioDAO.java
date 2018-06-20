package com.curso.boot.demomvc.dao;

import java.time.LocalDate;
import java.util.List;

import com.curso.boot.demomvc.model.Funcionario;

public interface FuncionarioDAO {
	
	public void save(Funcionario funcionario);
	public void update(Funcionario funcionario);
	public void delete(Long id);
	public Funcionario findById(Long id) ;
	public List<Funcionario> findAll();
	public List<Funcionario> findByName(String nome);
	public List<Funcionario> findByCargoId(Long id);
	public List<Funcionario> findByData(LocalDate entrada, LocalDate saida);
	public List<Funcionario> findByDataSaida(LocalDate saida);
	public List<Funcionario> findByDataEntrada(LocalDate entrada);
}
