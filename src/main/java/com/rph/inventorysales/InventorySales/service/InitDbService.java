package com.rph.inventorysales.InventorySales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.inventorysales.InventorySales.repository.UserRepository;

@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void init() {
		if (userRepository.findAll().isEmpty()) {
			
			
			
		}
	}
}
