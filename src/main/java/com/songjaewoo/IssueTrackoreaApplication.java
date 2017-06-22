package com.songjaewoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"awsS3.properties"})
public class IssueTrackoreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackoreaApplication.class, args);
	}
}
