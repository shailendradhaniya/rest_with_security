package com.sha.rest_security;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sha.rest_security.filters.JwtAuthenticationFilter;

@SpringBootApplication
public class RestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSecurityApplication.class, args);
	}
	
/*	@Bean
	CommandLineRunner init(AccountRepository accountRepository,BookmarkRepository bookMarkRepository) {
		return (evt) -> {
			Arrays.asList(
					"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
					.forEach(
							a -> {
								Account account = accountRepository.save(new Account(a,
										"password"));
								bookMarkRepository.save(new Bookmark(account,
										"http://bookmark.com/1/" + a, "A description"));
								bookMarkRepository.save(new Bookmark(account,
										"http://bookmark.com/2/" + a, "A description"));
							});
		};
	}*/
	
	// CORS
		/*@Bean
		FilterRegistrationBean corsFilter(
				@Value("${tagit.origin:http://localhost:9000}") String origin) {
			return new FilterRegistrationBean(new Filter() {
				public void doFilter(ServletRequest req, ServletResponse res,
						FilterChain chain) throws IOException, ServletException {
					HttpServletRequest request = (HttpServletRequest) req;
					HttpServletResponse response = (HttpServletResponse) res;
					String method = request.getMethod();
					// this origin value could just as easily have come from a database
					response.setHeader("Access-Control-Allow-Origin", origin);
					response.setHeader("Access-Control-Allow-Methods",
							"POST,GET,OPTIONS,DELETE");
					response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
					response.setHeader("Access-Control-Allow-Credentials", "true");
					response.setHeader(
							"Access-Control-Allow-Headers",
							"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
					if ("OPTIONS".equals(method)) {
						response.setStatus(HttpStatus.OK.value());
					}
					else {
						chain.doFilter(req, res);
					}
				}

				public void init(FilterConfig filterConfig) {
				}

				public void destroy() {
				}
			});
}*/
	@Bean
	public FilterRegistrationBean<Filter> someFilterRegistration() {

	    FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
	    registration.setFilter(jwtApiFilter());
	    registration.addUrlPatterns("/api/*");
	    registration.addInitParameter("paramName", "paramValue");
	    registration.setName("jwtApiFilter");
	    registration.setOrder(1);
	    return registration;
	} 

	@Bean(name = "jwtApiFilter")
	public Filter jwtApiFilter() {
	    return new JwtAuthenticationFilter();
	}
}
