package services.impl;

import bean.Users;
import dao.IUsersDao;
import dao.impl.IUsersDaoImpl;
import services.IUsersServices;

public class IUsersServicesImpl implements IUsersServices{

	// 创建IUsersDao层对象
	private IUsersDao iuserDao = new IUsersDaoImpl();
	
	public boolean register(Users user) {
		// 调用Dao层入库
		int i = iuserDao.register(user); // 数据处理结果
		return i>0?true:false; // 业务逻辑的结果：根据数据处理结果得到业务逻辑结果
	}

	@Override
	public boolean login(Users user) {
		int uid = iuserDao.login(user);
		return uid>0?true:false; // 小的业务逻辑
	}
	
}
