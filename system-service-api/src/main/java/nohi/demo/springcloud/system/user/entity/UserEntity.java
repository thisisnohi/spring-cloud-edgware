package nohi.demo.springcloud.system.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * Created by nohi on 2018/6/9.
 */
@Entity
@Table(name = "USER")
@Getter
@Setter
@ApiModel(value="user对象",description="用户对象user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="用户ID",name="userId",example="1")
	private Long id;
	@Column
	@ApiModelProperty(value="用户名",name="username")
	private String username;
	@Column
	@ApiModelProperty(value="密码",name="username")
	private String password;
	@Column
	@ApiModelProperty(value="年龄",name="username")
	private Integer age;
//	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="生日",name="birthday")
	private Date birthday;
}
