package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.cg.config.UserDataRepository;
import com.cg.dto.UserData;

@Component
public class UserDetailsInit implements CommandLineRunner {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserDataRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.save(new UserData("user", encoder.encode("user"), "USER"));
		repo.save(new UserData("admin", encoder.encode("admin"), "ADMIN,USER"));

	}

}
