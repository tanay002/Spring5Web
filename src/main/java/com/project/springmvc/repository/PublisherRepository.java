package com.project.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springmvc.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long>
{

}
