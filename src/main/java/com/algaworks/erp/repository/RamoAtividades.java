package com.algaworks.erp.repository;

import com.algaworks.erp.model.RamoAtividade;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;

public class RamoAtividades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public RamoAtividades() {

	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<RamoAtividade> pesquisar(String descricao) {
		// É como se fosse uma classe util que será utilizada na construção da consulta
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		// Equivale à String jpql da classe Empresas 
		// (é maior mas tem como vantagem a facilidade em encontrar erros de digitação durante a compilação)
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);		
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));		
		
		// Semelhante ao JPQL
		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
