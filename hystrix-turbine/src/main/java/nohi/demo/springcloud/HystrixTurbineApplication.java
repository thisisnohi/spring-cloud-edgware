package nohi.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by nohi on 2018/6/11.
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class HystrixTurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
	}

}
