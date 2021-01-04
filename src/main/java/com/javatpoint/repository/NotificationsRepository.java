package com.javatpoint.repository;

import com.javatpoint.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NotificationsRepository extends JpaRepository<Notification, Integer> {
}
