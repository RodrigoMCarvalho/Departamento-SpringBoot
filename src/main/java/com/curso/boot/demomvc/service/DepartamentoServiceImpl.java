package com.curso.boot.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.demomvc.dao.DepartamentoDAO;
import com.curso.boot.demomvc.model.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoDAO dao;
	
	@Override 
	@Transactional(readOnly=false)
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override 
	@Transactional(readOnly=false)
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override 
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override 
	@Transactional(readOnly=true)
	public Departamento buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override 
	@Transactional(readOnly=true)
	public List<Departamento> burcarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if(buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
