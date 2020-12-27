package com.javatpoint.repository;

import com.javatpoint.model.SMS;
import org.springframework.data.repository.CrudRepository;

public interface SMSRepository extends CrudRepository<SMS, Integer> {
}
