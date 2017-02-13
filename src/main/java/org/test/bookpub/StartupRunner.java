package org.test.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Publisher;
import org.test.bookpub.repository.AuthorRepository;
import org.test.bookpub.repository.BookRepository;
import org.test.bookpub.repository.PublisherRepository;

import javax.sql.DataSource;

public class StartupRunner implements CommandLineRunner {
	private final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
	@Autowired
	private DataSource ds;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void numberOfBooks() throws Exception {
		logger.info("Number of books: " + bookRepository.count());
	}

	@Override
	public void run(String... args) throws Exception {
		Author author = new Author("Alex", "Antonov");
		author = authorRepository.save(author);
		Publisher publisher = new Publisher("Packt");
		publisher = publisherRepository.save(publisher);
		Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author, publisher);
		bookRepository.save(book);

	}
}
