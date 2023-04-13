package br.com.itads.snackshare.frontend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import br.com.itads.snackshare.frontend.aop.SessionInterceptor;

/**
 * 
 * @author mario.romeu@gmail.com
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Registro para o Spring Boot
	 */	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LocaleChangeInterceptor());

        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");

        registry.addInterceptor(new SessionInterceptor())        	
        	.addPathPatterns("/frontend/*")
        	.excludePathPatterns("/resources/**");

    }

}
