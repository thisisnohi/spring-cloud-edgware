package nohi.demo.springcloud.system.user;

import java.util.List;

import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nohi on 2018/6/9.
 */
@RequestMapping(value = "user",name = "user")
public interface InterfaceUserService {
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	List<UserEntity> getAll();

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	List<UserEntity> findUser(@RequestBody UserEntity userInfo);

	@RequestMapping(value = "get/{userId}", method = RequestMethod.GET)
	UserEntity get(@PathVariable("userId") Long userId);

}
