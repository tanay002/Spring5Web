package com.project.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springmvc.entity.Books;

public interface BookRepository extends CrudRepository<Books, Long>
{

}
