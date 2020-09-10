package com.userapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="requests")
@NamedQueries({
	@NamedQuery(name = "FIND_BY_TITLE", query = "from FundRequest f where f.title = ?1"),
	@NamedQuery(name = "FIND_BY_CATEGORY_NAME", query = "from FundRequest f where f.category.name = ?1")
})
public class FundRequest {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	
	//@OneToOne
	//@OneToMany
	@ManyToOne(fetch = FetchType.EAGER) //Fetching Strategies
	@JoinColumn(name="category_id")
	//@Column(name="category_id")
	//private Integer categoryId;
	private Category category;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
}