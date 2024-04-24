package iise_capston.imgcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImgcloudApplication {
	private static final Logger logger = LoggerFactory.getLogger(ImgcloudApplication.class);
	public static void main(String[] args) {
		logger.info("This is an info message");

		SpringApplication.run(ImgcloudApplication.class, args);
	}
}
