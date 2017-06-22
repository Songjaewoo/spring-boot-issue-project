package com.songjaewoo.model.dto;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;

public class CommentDto {

	@Getter
	@Setter
	public static class Create {
		private Date nowDate = new Date();
		
		private Integer postId;
		
		private String writer = RandomStringUtils.randomAlphanumeric(7);
		
		private String description;
		
		private String password;
		
		private Date createdDate = nowDate;
		
		private Date updatedDate = nowDate;
	}
	
	@Getter
	@Setter
	public static class Update {
		private Date nowDate = new Date();
		
		private String description;
		
		private Date updatedDate = nowDate;
	}
}
