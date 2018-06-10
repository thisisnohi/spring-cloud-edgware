package nohi.demo.springcloud.system.user.web;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import nohi.demo.springcloud.system.user.entity.UserEntity;
import nohi.demo.springcloud.system.user.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nohi on 2018/6/10.
 */
@RestController
@RequestMapping("/userFeignView")
@Api(value = "/userFeignView",tags = "用户视图Feign",description = "显示用户视图Feign API")
public class UserFeignController {

	@Autowired
	private UserFeignService userService;

	@GetMapping(value = "getAll")
	@ApiOperation( value = "获取所有用户",notes = "无需参数")
	public List<UserEntity> getAll() {
		return userService.getAll(  );
	}

	@PostMapping(value = "findUser")
	public List<UserEntity> findUser(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=false) UserEntity info) {
		return userService.findUser( info );
	}

	@GetMapping(value = "get/{userId}")
	public UserEntity get(@PathVariable("userId") @ApiParam(name="userId",value="用户id",required=true) Long userId) {
		// http://服务提供者的serviceId/url
		return userService.get( userId );
	}


	
}
