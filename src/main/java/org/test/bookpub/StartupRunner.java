package org.test.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.test.bookpub.repository.BookRepository;

import javax.sql.DataSource;

public class StartupRunner {
	private final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
	@Autowired
	private DataSource ds;

	@Autowired
	private BookRepository bookRepository;

	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run() throws Exception {
		logger.info("Number of books: " + bookRepository.count());
	}

}
