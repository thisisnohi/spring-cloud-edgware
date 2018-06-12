package nohi.demo.springcloud.system.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nohi on 2018/6/10.
 */
@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger( UserService.class );

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackOfgetAll")
	public List<UserEntity> getAll() {
		// http://服务提供者的serviceId/url
		UserEntity[] tmp = this.restTemplate.getForObject("http://system-service/user/getAll",UserEntity[].class);
		return Arrays.asList(tmp);
	}

	@HystrixCommand(fallbackMethod = "fallbackOffindUser")
	public List<UserEntity> findUser(UserEntity info) {
		// http://服务提供者的serviceId/url
		ResponseEntity<UserEntity[]> response = this.restTemplate.postForEntity("http://system-service/user/findUser",info,UserEntity[].class);
		return Arrays.asList( response.getBody() );
	}


	/**
	 * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
	 * @param id id
	 * @return 通过id查询到的用户
	 */
	@HystrixCommand(fallbackMethod = "fallbackOfGet")
	public UserEntity get(Long id) {
		// http://服务提供者的serviceId/url
		return this.restTemplate.getForObject("http://system-service/user/get/" + id,UserEntity.class);
	}

	/**
	 * hystrix fallback方法
	 */
	public List<UserEntity> fallbackOfgetAll() {
		log.info( "异常发生，fallbackOfgetAll，接 收的参数 " );
		return new ArrayList<>(  );
	}

	/**
	 * hystrix fallback方法
	 * @param id id
	 * @return 默认的用户
	 */
	public UserEntity fallbackOfGet(Long id) {
		log.info( "异常发生，进入fallback方法，接 收的参数：id = {}", id );
		UserEntity user = new UserEntity();
		user.setId( -1L );
		user.setUsername( "default username" );
		user.setAge( 0 );
		return user;
	}
}
