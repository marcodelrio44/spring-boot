package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner (StudentRepository repository) {
		return args -> {
			Student marco= new Student(
					"marcodelrio44@gmail.com",
					"Marco",
					"Delrio",
					LocalDate.of(1991, Month.JULY, 3));
			Student edward= new Student(
					"edward.norton@gmail.com",
					"Edward",
					"Norton",
					LocalDate.of(1969, Month.AUGUST, 18));
			
			repository.saveAll(List.of(marco,edward));
		};
	}
}
