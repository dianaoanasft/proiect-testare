package com.proiect.testare.proiecttestare;

import com.proiect.testare.proiecttestare.dao.UserDao;
import com.proiect.testare.proiecttestare.dao.impl.DefaultUserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class MyBeansConfig {

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setDefaultTimeZone(TimeZone.getTimeZone("UTC"));

        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");

        return localeChangeInterceptor;
    }

    @Bean(name = "userDao")
    public UserDao userDao() {
        return new DefaultUserDao();
    }

}
