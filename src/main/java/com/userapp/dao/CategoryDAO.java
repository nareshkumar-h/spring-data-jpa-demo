package com.userapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userapp.model.Category;

@Repository
@Transactional
public class CategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Category category) {
		em.persist(category);
	}
	
	public Category findOne(Integer id) {
		Category find = em.find(Category.class, id);
		return find;
	}
	
	public List<Category> findAll() {
		//return em.createQuery("select c.name from Category c").getResultList(); //Hibernate Query Language (Entity Class name,property name )
		return em.createNativeQuery("select c.name from categories c").getResultList();// SQL - table name, column names
	}
	
	
}
