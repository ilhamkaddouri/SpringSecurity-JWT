package com.example.jwtspringsec.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtspringsec.entities.AppUser;
import com.example.jwtspringsec.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
	private AppUser register(@RequestBody RegisterForm userForm) {
		if(userForm.getPassword().equals(userForm.getRepaswword())) {
			throw new RuntimeException("You must confirm your password");
		}
		AppUser user = accountService.findByUsername(userForm.getUsername());
		if(user!=null) {
			throw new RuntimeException("this user already exists");
		}
		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		accountService.save(appUser);
		accountService.addRoleToUse(userForm.getUsername(), "USER");
		return appUser;
	}
}
