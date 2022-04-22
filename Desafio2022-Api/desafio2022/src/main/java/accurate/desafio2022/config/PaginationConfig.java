package accurate.desafio2022.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class PaginationConfig extends WebMvcConfigurerAdapter {

	    @Override
	    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
	        resolver.setOneIndexedParameters(true);
	        argumentResolvers.add(resolver);
	        super.addArgumentResolvers(argumentResolvers);
	    }
}

