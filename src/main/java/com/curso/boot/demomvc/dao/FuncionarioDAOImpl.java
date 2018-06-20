package com.curso.boot.demomvc.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.curso.boot.demomvc.model.Funcionario;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDAO {

	@Override
		public List<Funcionario> findByName(String nome	) {
//		TypedQuery<Funcionario> query = getEntityManager()
//				.createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE :nome", Funcionario.class);
//		query.setParameter("nome", nome);
//		
//		return query.getResultList();
		
		return createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE CONCAT('%', ?1,'%')", nome);
	}

	@Override
	public List<Funcionario> findByCargoId(Long id) {
		
		return createQuery("SELECT f FROM Funcionario f WHERE f.cargo.id = ?1", id);
	}

	@Override
	public List<Funcionario> findByData(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada >= ?1 AND f.dataSaida <= ?2 ")
				.append("ORDER BY f.dataEntrada ASC")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataSaida <= ?1 ")
				.append("ORDER BY f.dataSaida ASC")
				.toString();
		return createQuery(jpql, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada >= ?1 ")
				.append("ORDER BY f.dataEntrada ASC")
				.toString();
		return createQuery(jpql, entrada);
	}

}
