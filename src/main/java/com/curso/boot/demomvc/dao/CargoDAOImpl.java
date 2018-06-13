package com.curso.boot.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.curso.boot.demomvc.model.Cargo;

@Repository
public class CargoDAOImpl extends AbstractDAO<Cargo, Long> implements CargoDAO {

}
