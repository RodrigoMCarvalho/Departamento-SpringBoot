package com.curso.boot.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.demomvc.dao.FuncionarioDAO;
import com.curso.boot.demomvc.model.Funcionario;

@Service @Transactional(readOnly=true)
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioDAO dao;
	
	@Override @Transactional(readOnly=false)
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override  @Transactional(readOnly=false)
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override  @Transactional(readOnly=false)
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Funcionario> burcarTodos() {
		return dao.findAll();
	}

}
