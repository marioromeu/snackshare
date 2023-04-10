package br.com.itads.snackshare.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.itads.snackshare.frontend"})
public class Main extends SpringBootServletInitializer {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	/**
	 * 
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Main.class);
	} 

}
