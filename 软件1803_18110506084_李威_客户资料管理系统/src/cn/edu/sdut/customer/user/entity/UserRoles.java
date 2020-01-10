package cn.edu.sdut.customer.user.entity;

import lombok.Data;

@Data
public class UserRoles {
	private String userrolesid;
	private String userrolesName;

	@Override
	public String toString() {
		return userrolesName;
	}
}
