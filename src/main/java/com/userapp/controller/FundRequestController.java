package com.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapp.dao.FundRequestDAO;
import com.userapp.model.FundRequest;

@RestController
@RequestMapping("api/fundrequests")
public class FundRequestController {

	@Autowired
	private FundRequestDAO fundRequestDAO;
	
	@GetMapping
	public List<FundRequest> list() {
		List<FundRequest> list = fundRequestDAO.findAll(); //select * from requests or select * from requests , categories 
		for (FundRequest fundRequest : list) {
			System.out.println(fundRequest.getTitle() + "-" + fundRequest.getCategory().getName());
		}
		return list;
	}
	
	@PostMapping
	public void addRequest(@RequestBody FundRequest fundRequest) {
		fundRequestDAO.save(fundRequest);
	}
	
	@PutMapping("{id}")
	public void updateRequest(@RequestBody FundRequest fundRequest) {
		fundRequestDAO.update(fundRequest);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		fundRequestDAO.delete(id);
	}
	
	
}
