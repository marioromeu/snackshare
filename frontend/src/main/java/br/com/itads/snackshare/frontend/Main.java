package br.com.itads.snackshare.frontend;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author marioromeu
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.itads.snackshare.frontend"})
//@ImportResource("classpath:snackshare-application-context.xml")
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

	/**
	 * 
	 * @param ctx
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

		return args -> {

			System.out.println(" .............. BEANS DO SPRING BOOT ......... ");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for (String beanName : beanNames) {

				if (beanName.toLowerCase().startsWith("Aeolus".toLowerCase())) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + beanName);

				} else if (beanName.toLowerCase().startsWith("smart".toLowerCase())) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + beanName);

				} else if (beanName.toLowerCase().startsWith("dataSource".toLowerCase())) {
					//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + ctx.getBean(beanName).toString() );


				} else {
					//System.out.print(beanName);

				}

				//System.out.println("\n");				

			}

			System.out.println(" .............. BEANS DO SPRING BOOT ......... ");

		};

	}

}
