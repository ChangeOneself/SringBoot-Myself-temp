package gf.oneself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@RestController
public class Apllication {
	@RequestMapping("/te")
	public String test() {
		System.out.println("this is a test");
		return "this is a test.";
	}

	public static void main(String[] args) {
		SpringApplication.run(Apllication.class, args);
	}
}
