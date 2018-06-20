package com.curso.boot.demomvc.service;

import java.time.LocalDate;
import java.util.List;

import com.curso.boot.demomvc.model.Funcionario;

public interface FuncionarioService {
	
	public void salvar(Funcionario funcionario);
	public void editar(Funcionario funcionario);
	public void excluir(Long id);
	public Funcionario buscarPorId(Long id);
	public List<Funcionario> burcarTodos();
	public List<Funcionario> buscaPorNome(String nome);
	public List<Funcionario> buscaPorCargo(Long id);
	public List<Funcionario> buscaPorData(LocalDate entrada, LocalDate saida);
}
