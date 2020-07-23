package com.example.jwtspringsec.service;

import com.example.jwtspringsec.entities.AppRole;
import com.example.jwtspringsec.entities.AppUser;

public interface AccountService {
	public AppUser save(AppUser user);
	public AppRole save(AppRole role);
	public void addRoleToUse(String username,String roleName);
	public AppUser findByUsername(String username);
}
