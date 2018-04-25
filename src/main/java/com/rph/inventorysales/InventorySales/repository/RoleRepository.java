package com.rph.inventorysales.InventorySales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rph.inventorysales.InventorySales.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByName(String name);
}
