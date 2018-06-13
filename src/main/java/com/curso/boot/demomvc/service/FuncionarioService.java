package com.curso.boot.demomvc.service;

import java.util.List;

import com.curso.boot.demomvc.model.Funcionario;

public interface FuncionarioService {
	
	public void salvar(Funcionario funcionario);
	public void editar(Funcionario funcionario);
	public void excluir(Long id);
	public Funcionario buscarPorId(Long id);
	public List<Funcionario> burcarTodos();
}
