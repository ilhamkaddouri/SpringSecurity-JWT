package com.example.jwtspringsec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtspringsec.dao.TaskRepository;
import com.example.jwtspringsec.entities.Task;

@RestController
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> tasks(){
		return taskRepository.findAll();
	}
	@PostMapping("/save")
	public Task save(@RequestBody Task t) {
		return taskRepository.save(t);
		
	}
}
