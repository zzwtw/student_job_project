package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
import services.IUsersServices;
import services.impl.IUsersServicesImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	/**
	 * 能接收和响应前端的方法：
	      request请求类型：get/post
		 * doGet: 前端发送的get请求，则自动调用doGet方法进行业务逻辑处理
		 * doPost: 前端发送的post请求，则自动调用doPost方法进行业务逻辑处理
		 * service: 能够接受所有请求类型
	   servlet2.x：以配置的方式来对应请求映射
	   servlet3.x：以注解的方式来对应请求映射
	 */
	
	// 创建services对象
	IUsersServices iuserServices = (IUsersServices) new IUsersServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----doget()----");
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 业务逻辑：完成用户的注册功能
		 * 	步骤：
		 * 		① 接收前端传入的注册参数（注册信息）,可以从request对象中获取
		 * 	    ② 把注册信息交给services完成注册
		 *      ③ services调用Dao完成注册
		 */
		request.setCharacterEncoding("UTF-8");
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");
		
		// 把注册信息构建成一个对象进行传输
		Users user = new Users(0,nickName,Integer.parseInt(sex),password);
		boolean result = iuserServices.register(user);
		if(result) {
			/* 把结果响应前端-ok: 跳转到首页
			 * 请求跳转方式：
			 *    ① 请求转发
			 *         地址栏url不会发生改变,能够附带数据
			 *    ② 重定向
			 *         地址栏url会发生改变，不会附带数据
			 */
			// 重定向
			response.sendRedirect("index.jsp");
		}else {
			// 把结果响应前端-no ok ：跳转到注册页重新注册，并提示错误信息
			// 请求转发,附带数据
			request.setAttribute("info", "网络原因，注册失败，请重新注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
	
}
