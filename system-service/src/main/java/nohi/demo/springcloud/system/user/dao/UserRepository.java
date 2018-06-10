package nohi.demo.springcloud.system.user.dao;

import nohi.demo.springcloud.system.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nohi on 2018/6/9.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
