package in.app.lostFoundItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LostFoundItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostFoundItemApplication.class, args);
	}

}
