package nohi.demo.springcloud.system.user.service;

import nohi.demo.springcloud.system.user.InterfaceUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by nohi on 2018/6/10.
 */
@FeignClient("system-service")
public interface UserFeignService extends InterfaceUserService{
}
