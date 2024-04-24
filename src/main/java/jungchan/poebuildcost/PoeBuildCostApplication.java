package jungchan.poebuildcost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class PoeBuildCostApplication {

	public static final String PROFILE_LOCATION= "spring.config.location="
			+ "classpath:application.yaml,"
			+ "classpath:profile.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(PoeBuildCostApplication.class)
				.properties(PROFILE_LOCATION)
				.run(args);
//		SpringApplication.run(PoeBuildCostApplication.class, args);
	}
}
