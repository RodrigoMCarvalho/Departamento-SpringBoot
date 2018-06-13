package com.curso.boot.demomvc.service;

import java.util.List;

import com.curso.boot.demomvc.model.Departamento;

public interface DepartamentoService {
	
	public void salvar(Departamento departamento);
	public void editar(Departamento departamento);
	public void excluir(Long id);
	public Departamento buscarPorId(Long id);
	public List<Departamento> burcarTodos();
}
