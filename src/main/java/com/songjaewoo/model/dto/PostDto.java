package com.songjaewoo.model.dto;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;

public class PostDto {
	
	
	@Getter
	@Setter
	public static class Create {
		private Date nowDate = new Date();
		
		private String writer = RandomStringUtils.randomAlphanumeric(7);
		
		private String title;
		
		private String description;
		
		private Date createdDate = nowDate;
		
		private Date updatedDate = nowDate;

		private Long categoryId;
	}
	
	@Getter
	@Setter
	public static class Update {
		private Date nowDate = new Date();
		
		private String title;
		
		private String description;
		
		private Date updatedDate = nowDate;
	}
}
