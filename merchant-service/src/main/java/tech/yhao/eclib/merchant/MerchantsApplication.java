/**
 * 
 */
package tech.yhao.eclib.merchant;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tech.yhao.eclib.merchant.security.AuthCheckInterceptor;

/**
 * @author TaoJn
 *
 */
@SpringBootApplication
public class MerchantsApplication implements WebMvcConfigurer {

	@Resource
	private AuthCheckInterceptor authCheckIntercepter;

	public static void main(String[] args) {
		SpringApplication.run(MerchantsApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckIntercepter).addPathPatterns("/merchants/**");
	}
}
