package nohi.demo.springcloud.system.user.web;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import nohi.demo.springcloud.system.user.InterfaceUserService;
import nohi.demo.springcloud.system.user.dao.UserRepository;
import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nohi on 2018/6/9.
 */
@RestController
public class UserController implements InterfaceUserService{
	private Logger log = LoggerFactory.getLogger( this.getClass() );

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<UserEntity> getAll() {
		log.debug( "getAll" );
		List<UserEntity> tmp = userRepository.findAll();
		log.debug( tmp.toString() );
		log.debug( JSONObject.toJSONString( tmp ) );
		return tmp;
	}

	@Override
	public List<UserEntity> findUser(@RequestBody UserEntity userInfo) {
		log.debug( "findUser:{}" , userInfo.toString() );
		return userRepository.findAll( Example.of( userInfo ) );
	}

	@Override
	public UserEntity get(@PathVariable("userId") Long userId) {
		log.debug( "get:{}" , userId);
		return userRepository.getOne( userId );
	}
}
