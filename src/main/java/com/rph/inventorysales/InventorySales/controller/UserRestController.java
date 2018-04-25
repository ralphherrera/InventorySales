package com.rph.inventorysales.InventorySales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rph.inventorysales.InventorySales.model.User;
import com.rph.inventorysales.InventorySales.service.UserService;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping()
	public List<User> displayAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/{id}")
	public User displayUserDetails(@PathVariable int id) {
		return userService.getUserDetails(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateUserDetails(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(id, user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
