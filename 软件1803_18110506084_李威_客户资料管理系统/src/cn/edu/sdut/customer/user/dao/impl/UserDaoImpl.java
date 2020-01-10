package cn.edu.sdut.customer.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.customer.user.dao.UserDao;
import cn.edu.sdut.customer.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(User user) {
		String sql = "SELECT * FROM user WHERE username=? AND userpassword=?";
		
		return selectOne(sql, User.class, user.getUsername(), user.getUserpassword());
	}

	@Override
	public int updatePassowrd(User user) {
		String sql = "UPDATE `user` SET `userpassword` = ? WHERE `user`.`userid` =?";
		return saveOrUpdate(sql, user.getUserpassword(), user.getUserid());
	}

	@Override
	public List<User> userQueryAll(User user) {
		StringBuffer sb = new StringBuffer();
		List<Object> list = new ArrayList<>();
		sb.append("SELECT * FROM `user`");
		if (user!=null) {
			sb.append(" WHERE username like ?");
			list.add("%"+user.getUsername()+"%");
			if (user.getUserlevel() != 0) {
				sb.append(" AND userlevel=?");
				list.add(user.getUserlevel());
			}
		}
		sb.append(" ORDER BY `user`.`userid` DESC");
		String sql = sb.toString();
		return super.selectAll(sql, User.class,list.toArray());
	}

	@Override
	public User userQueryByUsername(User user) {
		String sql = "SELECT * FROM `user` WHERE username=?";
		return super.selectOne(sql, User.class, user.getUsername());
	}

	@Override
	public int updateUsername(User user) {
		String sql = "UPDATE `user` SET `username` = ? WHERE `user`.`userid` =?";
		return saveOrUpdate(sql, user.getUsername(), user.getUserid());
	}

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO `user` (`userid`, `username`, `userpassword`, `userlevel`) VALUES (NULL, ?, ?, ?)";
		return super.saveOrUpdate(sql, user.getUsername(), user.getUserpassword(), user.getUserlevel());
	}

	@Override
	public User detailUser(int userid) {
		String sql = "SELECT * FROM `user` WHERE userid=?";
		return super.selectOne(sql, User.class, userid);
	}

	@Override
	public int deleteUserById(int userid) {
		String sql = "DELETE FROM `user` WHERE `user`.`userid` = ?";
		return super.saveOrUpdate(sql, userid);
	}

}
