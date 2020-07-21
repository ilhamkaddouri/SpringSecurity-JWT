package com.example.jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtspringsec.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
