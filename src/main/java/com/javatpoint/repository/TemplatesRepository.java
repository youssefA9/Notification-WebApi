package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Template;

public interface TemplatesRepository extends CrudRepository<Template, Integer> {
}
