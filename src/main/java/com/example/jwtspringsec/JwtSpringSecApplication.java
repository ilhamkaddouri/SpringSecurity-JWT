package com.example.jwtspringsec;
import com.example.jwtspringsec.entities.*;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwtspringsec.dao.TaskRepository;
import com.example.jwtspringsec.entities.Task;
import com.example.jwtspringsec.service.AccountService;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner{
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
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
		accountService.save(new AppUser(null,"admin","1234",null));
		accountService.save(new AppUser(null,"user","123",null));
		accountService.save(new AppRole(null,"ADMIN"));
		accountService.save(new AppRole(null,"USER"));
		accountService.addRoleToUse("admin", "ADMIN");
		accountService.addRoleToUse("admin", "USER");
		accountService.addRoleToUse("user", "USER");
		
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}

}
