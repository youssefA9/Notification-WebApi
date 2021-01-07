package com.javatpoint.repository;

import com.javatpoint.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notification, Integer> {
}
