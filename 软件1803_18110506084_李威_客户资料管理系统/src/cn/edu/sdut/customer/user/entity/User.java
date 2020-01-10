package cn.edu.sdut.customer.user.entity;

import lombok.Data;

@Data
public class User {
	private Integer userid, userlevel;
	private String username, userpassword;
}
