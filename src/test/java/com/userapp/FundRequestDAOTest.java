package com.userapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.userapp.dao.FundRequestDAO;
import com.userapp.model.FundRequest;

@SpringBootTest
public class FundRequestDAOTest {

	@Autowired
	private FundRequestDAO dao;
	
	public void listRequestsTest() {
		List<FundRequest> findAll = dao.findAll();
		for (FundRequest fundRequest : findAll) {
			System.out.println(fundRequest);
		}
	}
}
