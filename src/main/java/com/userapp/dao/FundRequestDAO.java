package com.userapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userapp.model.FundRequest;

//Spring + Hibernate
// Core Java + Hibernate
@Repository
@Transactional
public class FundRequestDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void save(FundRequest fundRequest) {
		em.persist(fundRequest);
	}
	
	//select r.id, c.name as category_name, r.title,r.description from requests r, categories c where r.category_id = c.id;
	public List<FundRequest> findAll(){
		List<FundRequest> list = em.createQuery("from FundRequest f").getResultList();
		return list;
	}
	
	public List<FundRequest> findByCategory(String categoryName){
		//select * from  requests r, categories c where r.category_id = c.id and c.name = ?
		Query createQuery = em.createQuery("from FundRequest f where f.category.name = ?1");
		createQuery.setParameter(1, categoryName);
		
		List<FundRequest> list = createQuery.getResultList();
		return list;
	}
	
	public List<FundRequest> findByCategoryId(Integer categoryId){
		//select * from  requests r, categories c where r.category_id = c.id and c.id = ?
		Query createQuery = em.createQuery("from FundRequest f where f.category.id = ?1");
		createQuery.setParameter(1, categoryId);
		
		List<FundRequest> list = createQuery.getResultList();
		return list;
	}
	
	public List<FundRequest> findByTitle(String title){
		//select * from  requests r, categories c where r.category_id = c.id and r.title = ?
		//Query createQuery = em.createQuery("from FundRequest f where f.title = ?1");
		Query createQuery = em.createNamedQuery("FIND_BY_TITLE");
		createQuery.setParameter(1, title);
		
		List<FundRequest> list = createQuery.getResultList();
		return list;
	}

	public void update(FundRequest fundRequest) {

		em.merge(fundRequest);
		
	}
	
	public FundRequest findOne(Integer id) {
		FundRequest fr = em.find(FundRequest.class, id);
		return fr;
	}

	public void delete(Integer id) {

		FundRequest fr = em.find(FundRequest.class, id);
		em.remove(fr);
	}
}
