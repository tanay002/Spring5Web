package com.project.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springmvc.entity.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>
{

}
