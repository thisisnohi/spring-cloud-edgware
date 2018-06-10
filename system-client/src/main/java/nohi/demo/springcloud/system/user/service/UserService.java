package nohi.demo.springcloud.system.user.service;

import java.util.Arrays;
import java.util.List;

import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nohi on 2018/6/10.
 */
@Service
public class UserService {
	@Autowired
	private RestTemplate restTemplate;
	public List<UserEntity> getAll() {
		// http://服务提供者的serviceId/url
		UserEntity[] tmp = this.restTemplate.getForObject("http://system-service/user/getAll",UserEntity[].class);
		return Arrays.asList(tmp);
	}

	public List<UserEntity> findUser(UserEntity info) {
		// http://服务提供者的serviceId/url
		ResponseEntity<UserEntity[]> response = this.restTemplate.postForEntity("http://system-service/user/findUser",info,UserEntity[].class);
		return Arrays.asList( response.getBody() );
	}

	public UserEntity get(Long id) {
		// http://服务提供者的serviceId/url
		return this.restTemplate.getForObject("http://system-service/user/get/" + id,UserEntity.class);
	}
}
