package cn.edu.sdut.customer.user.dao;

import java.util.List;

import cn.edu.sdut.customer.user.entity.User;

public interface UserDao {
	User login(User user);
	int updatePassowrd(User user);
	int updateUsername(User user);
	int addUser(User user);
	List<User> userQueryAll(User user);
	User userQueryByUsername(User user);
	User detailUser(int userid);
	int deleteUserById(int userid);
}
