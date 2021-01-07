package com.javatpoint.repository;

import com.javatpoint.model.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SMSRepository extends JpaRepository<SMS, Integer> {
}
