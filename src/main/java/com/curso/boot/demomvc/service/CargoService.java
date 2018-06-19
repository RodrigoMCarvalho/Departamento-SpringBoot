package com.curso.boot.demomvc.service;

import java.util.List;

import com.curso.boot.demomvc.model.Cargo;

public interface CargoService {
	
	public void salvar(Cargo cargo);
	public void editar(Cargo cargo);
	public void excluir(Long id);
	public Cargo buscarPorId(Long id);
	public List<Cargo> burcarTodos();
	public boolean cargoTemFuncionario(Long id);
	
}
