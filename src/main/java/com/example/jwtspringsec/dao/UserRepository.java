package com.example.jwtspringsec.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtspringsec.entities.*;
public interface UserRepository extends JpaRepository<AppUser,Long>{
	public AppUser findByUsername(String username);
}
