package com.curso.boot.demomvc.dao;

import java.util.List;

import com.curso.boot.demomvc.model.Departamento;

public interface DepartamentoDAO {
	
	public void save(Departamento departamento);
	public void update(Departamento departamento);
	public void delete(Long id);
	public Departamento findById(Long id) ;
	public List<Departamento> findAll();
}
