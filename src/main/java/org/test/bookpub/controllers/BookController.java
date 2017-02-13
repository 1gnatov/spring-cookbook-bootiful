package org.test.bookpub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Reviewer;
import org.test.bookpub.repository.BookRepository;

import java.beans.PropertyEditorSupport;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

	public class Isbn {
		private String isbn;

		public Isbn(String pIsbn) {
			isbn = pIsbn;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String pIsbn) {
			isbn = pIsbn;
		}
	}

	public class IsbnEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (StringUtils.hasText(text)) {
				setValue(new Isbn(text.trim()));
			} else {
				setValue(null);
			}
		}

		@Override
		public String getAsText() {
			Isbn isbn = (Isbn) getValue();
			if (isbn != null) {
				return isbn.getIsbn();
			} else {
				return "";
			}
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//NOT THREAD SAFE! -> new IsbnEditor()
		binder.registerCustomEditor(Isbn.class, new IsbnEditor());
	}

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Isbn isbn) {
		return bookRepository.findBookByIsbn(isbn.getIsbn());
	}

	@RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
	public List<Reviewer> getReviewers(@PathVariable("isbn") Book book) {
		return book.getReviewers();
	}
}
