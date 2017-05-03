package com.songjaewoo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.songjaewoo.util.DateSerializer;

import lombok.Data;

@Data
@Entity
@Table(name = "POST")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	private Date updatedDate;
}
