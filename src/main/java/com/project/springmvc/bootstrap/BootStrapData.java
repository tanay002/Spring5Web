package com.project.springmvc.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.springmvc.entity.Author;
import com.project.springmvc.entity.Books;
import com.project.springmvc.entity.Publisher;
import com.project.springmvc.repository.AuthorRepository;
import com.project.springmvc.repository.BookRepository;
import com.project.springmvc.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner
{
	@Autowired
	private final AuthorRepository authorRepository;

	@Autowired
	private final BookRepository bookRepository;

	@Autowired
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository=publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author author=new Author("Seema", "Kedar");
		Books book = new Books("DBMS",2L);

		Set<Author> auth=new HashSet<Author>();
		auth.add(author);
		Set<Books> bookk=new HashSet<Books>();
		bookk.add(book);
		author.setBooks(bookk);
		book.setAuthors(auth);

		authorRepository.save(author);
		bookRepository.save(book);

		Author author2=new Author("Pravin", "Sharma");
		Books book2 = new Books("Data Structure",3L);

		Set<Author> auth3=new HashSet<Author>();
		auth3.add(author2);
		Set<Books> bookk3=new HashSet<Books>();
		bookk3.add(book2);
		author2.setBooks(bookk3);
		book2.setAuthors(auth3);

		authorRepository.save(author2);
		bookRepository.save(book2);
		
		Publisher publisher1 =new Publisher("Sky Residency","Madhya Pradesh","Indore", "452020");
		Publisher publisher2 =new Publisher("Sathak Residency","Madhya Pradesh","Indore", "452010");
		Publisher publisher3 =new Publisher("Sapna Sangeeta","Madhya Pradesh","Bhopal", "786720");
		Publisher publisher4 =new Publisher("Kent","Madhya Pradesh","Guna", "898020");
		publisherRepository.save(publisher1);
		publisherRepository.save(publisher2);
		publisherRepository.save(publisher3);
		publisherRepository.save(publisher4);
		
		System.out.println("Number of book present: "+bookRepository.count());
		System.out.println("Number of Publisher present: "+publisherRepository.count());
	}

}
