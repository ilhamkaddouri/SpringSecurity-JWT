package com.example.jwtspringsec;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwtspringsec.dao.TaskRepository;
import com.example.jwtspringsec.entities.Task;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner{
	@Autowired
	private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
	public  BCryptPasswordEncoder getBCPE() {
		return new  BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}

}
