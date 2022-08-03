package com.xadmin.studentcourselookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class StudentCourseLookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseLookupApplication.class, args);
	}

}
