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
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Publisher publisher = new Publisher();
		publisher.setName("SNG Publisher");
		publisher.setCity("DNC Publisher");
		publisher.setState("Sharma Publisher");

		publisherRepository.save(publisher);

		System.out.println("Publisher Count: " + publisherRepository.count());

		Author auth = new Author("Tanay", "Saxena");
		Books book = new Books("Data Structure", "990");
		auth.getBooks().add(book);
		book.getAuthors().add(auth);
		book.setPublisher(publisher);
		publisher.getBooks().add(book);

		authorRepository.save(auth);
		bookRepository.save(book);
		publisherRepository.save(publisher);

		Author auth1 = new Author("Vineet", "Pathak");
		Books book1 = new Books("Core Java", "39394");
		auth1.getBooks().add(book1);
		book1.getAuthors().add(auth1);

		book1.setPublisher(publisher);
		publisher.getBooks().add(book1);

		authorRepository.save(auth1);
		bookRepository.save(book1);
		publisherRepository.save(publisher);

		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
	}
}
