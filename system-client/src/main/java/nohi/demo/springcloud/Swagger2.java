package nohi.demo.springcloud;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by nohi on 2018/5/6.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket( DocumentationType.SWAGGER_2 )
				.apiInfo( apiInfo() )
				.select()
				.apis( RequestHandlerSelectors.withClassAnnotation( Api.class ) )
				.paths( PathSelectors.any() )
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title( "Spring Boot中使用Swagger2构建RESTful APIs" )
				.description( "Spring Cloud 学习资料" )
//				.termsOfServiceUrl( "https://github.com/thisisthis/spring-cloud-edgware" )
//				.contact( "NOHI" )
				.contact( new Contact( "NOHI" , "https://github.com/thisisthis/spring-cloud-edgware" , "thisisnohi@163.com" ) )
				.version( "1.0" )
				.build();
	}

}
