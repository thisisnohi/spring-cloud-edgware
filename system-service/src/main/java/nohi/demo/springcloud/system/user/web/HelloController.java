package nohi.demo.springcloud.system.user.web;

import nohi.demo.springcloud.system.user.model.TestType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nohi on 2018/6/10.
 */
@RestController
@RequestMapping("/")
public class HelloController {

	@GetMapping("/")
	public TestType index(){
		TestType tmp = new TestType();
		return tmp;
	}
}
