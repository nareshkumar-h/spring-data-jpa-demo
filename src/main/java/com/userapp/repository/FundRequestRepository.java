package com.userapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userapp.model.Category;
import com.userapp.model.FundRequest;

//Spring Data JPA
public interface FundRequestRepository extends JpaRepository<FundRequest, Integer>{

	//insert/update/delete/findall/count
	
	@Query("from FundRequest f where f.category.name=?1")
	List<FundRequest> findByCategoryName(String categoryName);
	
	//@Query("from FundRequest f where f.title=?1")
	List<FundRequest> findByTitleAndDescription(String title);
}
