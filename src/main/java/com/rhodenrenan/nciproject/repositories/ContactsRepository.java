package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.Contacts;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

}
