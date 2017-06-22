package com.songjaewoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {
	@Id
	private Long id;
	
	private String title;
	
	private String urlName;
	
	private Integer orderSeq;
}
