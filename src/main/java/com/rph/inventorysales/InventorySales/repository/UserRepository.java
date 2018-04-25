package com.rph.inventorysales.InventorySales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rph.inventorysales.InventorySales.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
}
