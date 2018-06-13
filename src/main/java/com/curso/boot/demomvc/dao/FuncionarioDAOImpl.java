package com.curso.boot.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.curso.boot.demomvc.model.Funcionario;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDAO{

}
