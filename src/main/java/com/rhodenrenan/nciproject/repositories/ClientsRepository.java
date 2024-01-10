package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {

}
