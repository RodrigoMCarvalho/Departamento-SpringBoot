package com.curso.boot.demomvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.demomvc.dao.UsuarioDAO;
import com.curso.boot.demomvc.model.Usuario;

@Repository
@Transactional // devido as ROLES
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario usuario = dao.findById(login);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), 
				true, true, true, true, usuario.getAuthorities());

	}

}
