package in.app.lostFoundItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import in.app.lostFoundItem.controller.MessageProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties(MessageProperties.class)
public class LostFoundItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostFoundItemApplication.class, args);
	}

}
