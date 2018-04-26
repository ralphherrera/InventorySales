package com.rph.inventorysales.InventorySales.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rph.inventorysales.InventorySales.model.Role;
import com.rph.inventorysales.InventorySales.model.User;
import com.rph.inventorysales.InventorySales.repository.RoleRepository;
import com.rph.inventorysales.InventorySales.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserDetails(int id) {
		return userRepository.findById(id);
	}

	public void saveUser(User user) {
		
		Role roleUser = new Role();
		roleUser.setName("USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		roleRepository.save(roleAdmin);
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByName("USER"));
		roles.add(roleRepository.findByName("ADMIN"));
		user.setRoles(roles);
		
		List<Role> rolex = user.getRoles();
		for (Role role : rolex) {
			log.info("tell {}", role.getName());
		}
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		user.setDateRegistered(new SimpleDateFormat("MM/d/yyyy HH:mm:ss Z").format(new Date()));
		userRepository.save(user);
	}

	public void updateUser(int id, User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
}
