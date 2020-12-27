package com.javatpoint.repository;

import com.javatpoint.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Notification, Integer> {


}

