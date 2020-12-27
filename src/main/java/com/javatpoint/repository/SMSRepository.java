package com.javatpoint.repository;
import com.javatpoint.model.Notification;
import org.springframework.data.repository.CrudRepository;
public interface SMSRepository extends CrudRepository<Notification, Integer>  {


}
