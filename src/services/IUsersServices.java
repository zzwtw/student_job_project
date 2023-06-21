package services;

import bean.Users;

public interface IUsersServices {

	/**
	 * 用户注册功能
	 * @param user 用户对象
	 * @return true:success
	 */
	public boolean register(Users user);
	
	/**
	 * 用户登录功能
	 * @param user
	 * @return true:success
	 */
	public boolean login(Users user);
}
