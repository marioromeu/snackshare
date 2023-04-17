package br.com.itads.snackshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "br.com.itads.snackshare"})
public class Main {
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		new SpringApplication(Main.class).run(args);

	}	
	
}
