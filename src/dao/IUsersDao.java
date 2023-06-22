package dao;

import bean.Users;

public interface IUsersDao {
	
	/**
	 * 用户注册信息入库
	 * @param user 用户对象
	 * @return int >0:success
	 */
	public int register(Users user);

	/**
	 * 用户登录功能
	 * @param user
	 * @return int >0:success
	 */
	public int login(Users user);
	
}
