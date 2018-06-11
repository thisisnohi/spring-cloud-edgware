package nohi.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nohi on 2018/6/10.
 */
@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients   //Feign启用，建议单独使用configure，否则出现 controller映射重复问题： There is already 'userController' bean method
@EnableCircuitBreaker   //熔断器 或者使用@SpringCloudApplication
public class SystemClientApplication {
	/**
	 * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
	 * @return restTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
//	/**
//	 * 格式化json输出
//	 * @return
//	 */
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		//1.需要定义一个convert转换消息的对象;
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//		//2:添加fastJson的配置信息;
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures( SerializerFeature.PrettyFormat);
//		//3处理中文乱码问题
//		List<MediaType> fastMediaTypes = new ArrayList<>();
//		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		//4.在convert中添加配置信息.
//		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
//		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
//		return new HttpMessageConverters(converter);
//	}
	public static void main(String[] args) {
		SpringApplication.run( SystemClientApplication.class, args);
	}
}
