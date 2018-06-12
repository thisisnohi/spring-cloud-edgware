package nohi.demo.springcloud;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Feign启用，建议单独使用configure，否则出现 controller映射重复问题
 * @see https://github.com/spring-cloud/spring-cloud-netflix/issues/466
 * Created by nohi on 2018/6/11.
 */
@Configuration
@ConditionalOnClass({Feign.class})
public class FeignMappingDefaultConfiguration {
	@Bean
	public WebMvcRegistrations feignWebRegistrations() {
		return new WebMvcRegistrationsAdapter() {
			@Override
			public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
				return new FeignFilterRequestMappingHandlerMapping();
			}
		};
	}

	private static class FeignFilterRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
		@Override
		protected boolean isHandler(Class<?> beanType) {
			return super.isHandler(beanType) && (AnnotationUtils.findAnnotation(beanType, FeignClient.class) == null);
		}
	}
}
