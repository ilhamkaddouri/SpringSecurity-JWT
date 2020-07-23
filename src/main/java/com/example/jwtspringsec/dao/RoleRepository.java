package com.example.jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtspringsec.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long>{
	public AppRole findRoleByUsername(String roleName);
}
