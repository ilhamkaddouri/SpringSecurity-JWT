package com.example.jwtspringsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jwtspringsec.entities.AppRole;
import com.example.jwtspringsec.entities.AppUser;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public AppUser save(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppRole save(AppRole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleToUse(String username, String roleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AppUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
