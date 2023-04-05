package com.project.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springmvc.repository.AuthorRepository;

@Controller
public class AuthorController 
{

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/author")
	public String getAllAuthor(Model model)
	{
	 model.addAttribute("author",authorRepository.findAll());
	 return "author/list";
	}
}
