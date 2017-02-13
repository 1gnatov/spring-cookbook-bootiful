package org.test.bookpub.formatters;

import org.springframework.format.Formatter;
import org.test.bookpub.entity.Book;
import org.test.bookpub.repository.BookRepository;

import java.text.ParseException;
import java.util.Locale;

public class BookFormatter implements Formatter<Book> {

	private BookRepository mBookRepository;

	public BookFormatter(BookRepository pBookRepository) {
		mBookRepository = pBookRepository;
	}

	@Override
	public Book parse(String bookIdentifier, Locale locale) throws ParseException {
		Book book = mBookRepository.findBookByIsbn(bookIdentifier);
		return book != null ? book : mBookRepository.findOne(Long.valueOf(bookIdentifier));
	}

	@Override
	public String print(Book book, Locale locale) {
		return book.getIsbn();
	}
}
