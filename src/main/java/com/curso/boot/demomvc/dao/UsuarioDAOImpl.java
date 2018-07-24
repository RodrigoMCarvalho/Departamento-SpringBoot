package com.curso.boot.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.curso.boot.demomvc.model.Usuario;

@Repository
public class UsuarioDAOImpl extends AbstractDAO<Usuario, String> implements UsuarioDAO {

}
