package com.curso.boot.demomvc.dao;

import com.curso.boot.demomvc.model.Usuario;

public interface UsuarioDAO {
	
	public Usuario findById(String login);

}
