package com.userapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userapp.model.User;

@Repository
@Transactional
public class UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(User user) {

		//em.getTransaction().begin();
		em.persist(user);
		//em.getTransaction().commit();

	}

	public User findOne(Integer id) {
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	@Transactional
	public void update(User user) {

		em.merge(user);
	}

	public void delete(Integer id) {
		User findOne = em.find(User.class, id);
		em.remove(findOne);
	}

	public List<User> list() {
		TypedQuery<User> query = em.createQuery("from User u", User.class);
		List<User> list = query.getResultList();
		return list;
	}

	public User findByEmailAndPassword(String email, String password) {
		User user = null;
		try {
			TypedQuery<User> query = em.createQuery("from User u where email=?1 and password = ?2", User.class);
			query.setParameter(1, email);
			query.setParameter(2, password);
			user = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return user;
	}
}
