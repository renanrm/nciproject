package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.ServiceAuth;

@Repository
public interface ServiceAuthRepository extends JpaRepository<ServiceAuth, Integer> {

}
