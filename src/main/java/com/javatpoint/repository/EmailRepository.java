package com.javatpoint.repository;

import com.javatpoint.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmailRepository extends JpaRepository<Email, Integer> {
}
