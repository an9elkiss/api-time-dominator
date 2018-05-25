package com.an9elkiss.api.timedo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.an9elkiss.commons.auth.spring.AuthInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {
		"com.an9elkiss.api.timedo.api, com.an9elkiss.api.timedo.service, "
				+ "com.an9elkiss.commons.util.spring, com.an9elkiss.commons.auth.spring" })
@MapperScan("com.an9elkiss.api.timedo.dao")
public class TimeDominatorApiBoot extends WebMvcConfigurerAdapter implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(TimeDominatorApiBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
    

	/**
	 * 实现封装PUT请求的From体至Command
	 * @return
	 */
    @Bean
    public FilterRegistrationBean httpPutFormContentFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
        registration.setFilter(httpPutFormContentFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
    
    /**
     * 允许跨域请求。swagger可能发起跨域请求
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
            }
        };
    }

	// 这样，bean才能被托管
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**");
	}

}
