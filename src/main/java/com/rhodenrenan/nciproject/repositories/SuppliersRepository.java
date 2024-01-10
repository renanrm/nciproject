package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.Suppliers;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Integer> {

}
