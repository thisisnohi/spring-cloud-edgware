package nohi.demo.springcloud.system.user.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by nohi on 2018/6/10.
 */
@Getter
@Setter
@ToString
public class TestType {
	private int intValue = 1;
	private Integer integerValue = 2;
	private String stringValue = "3";
	private Long longValue = 4L;
//	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateValue = new Date();
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp timestampValue = new Timestamp( System.currentTimeMillis() );
	private Set setValue;
	private List listValue;
	private Map mapValue;
}
