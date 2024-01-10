package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
