package com.javatpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Template;

public interface TemplatesRepository extends JpaRepository<Template, Integer> {
}
