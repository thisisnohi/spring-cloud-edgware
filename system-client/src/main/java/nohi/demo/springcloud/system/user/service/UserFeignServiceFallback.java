package nohi.demo.springcloud.system.user.service;

import java.util.ArrayList;
import java.util.List;

import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nohi on 2018/6/10.
 */
public class UserFeignServiceFallback implements UserFeignService {
	private static final Logger log = LoggerFactory.getLogger( UserFeignServiceFallback.class );

	@Override
	public List<UserEntity> getAll() {
		log.info( "UserFeignServiceFallback.getAll" );
		return new ArrayList<>(  );
	}

	@Override
	public List<UserEntity> findUser(UserEntity userInfo) {
		log.info( "UserFeignServiceFallback.findUser:{}" ,userInfo );
		return new ArrayList<>(  );
	}

	@Override
	public UserEntity get(Long userId) {
		log.info( "UserFeignServiceFallback.get:{}" ,userId );
		UserEntity user = new UserEntity();
		user.setId( -1L );
		user.setUsername( "default username" );
		user.setAge( 0 );
		return user;
	}
}
