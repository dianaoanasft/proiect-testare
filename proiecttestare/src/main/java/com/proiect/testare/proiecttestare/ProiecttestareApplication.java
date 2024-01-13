package com.proiect.testare.proiecttestare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Locale;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class ProiecttestareApplication implements WebMvcConfigurer {

	private final LocaleChangeInterceptor localeChangeInterceptor;

	public ProiecttestareApplication(LocaleChangeInterceptor localeChangeInterceptor) {
		this.localeChangeInterceptor = localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor);
	}

	public static void main(String[] args) {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("lang/messages");
		messageSource.setDefaultEncoding("UTF-8");

		SpringApplication.run(ProiecttestareApplication.class, args);
	}

}
