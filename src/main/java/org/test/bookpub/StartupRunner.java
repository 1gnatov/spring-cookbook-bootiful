package org.test.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;

public class StartupRunner implements CommandLineRunner {
	private final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
	@Autowired
	private DataSource ds;

	@Override
	public void run(String... args) throws Exception {
		logger.info("DataSource: " + ds.toString());
	}

}
