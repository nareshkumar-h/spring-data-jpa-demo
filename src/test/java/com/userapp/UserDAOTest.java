package com.userapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.userapp.dao.UserDAO;
import com.userapp.model.Gender;
import com.userapp.model.User;

@SpringBootTest
class UserDAOTest {

	@Autowired
	private UserDAO userDAO;	
	
	@Test
	public void testFindOne() {
		Integer id = 1;
		User user = userDAO.findOne(id);
		System.out.println(user);
	}

	@Test
	public  void testAddUser() {

		User user = new User();
		user.setName("Naresh");
		user.setEmail("nareshkumarh1@live.com");
		user.setPassword("pass123");
		user.setActive(true);
		user.setGender(Gender.MALE);
		//user.setCreatedDate(LocalDateTime.now());
		//user.setModifiedDate(LocalDateTime.now());

		userDAO.save(user);
	}

	@Test
	public  void testUpdateUser() {

		Integer id = 3;
		User user = userDAO.findOne(id);
		user.setName("Naresh Kumar"); // update name
		userDAO.update(user);
	}

	@Test
	public  void testDeleteUser() {

		Integer id = 1;
		userDAO.delete(id);

	}

	@Test
	public  void testListUsers() {
		List<User> list = userDAO.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

	public  void testFindByEmailAndPassword() {
		User user = userDAO.findByEmailAndPassword("nareshkumarh@live.com", "pass123");
		System.out.println(user);
	}
	
	public  void testFindInvalidEmailAndPassword() {
		User user = userDAO.findByEmailAndPassword("nareshkumarh@live.com", "p");
		System.out.println(user);
	}

}
