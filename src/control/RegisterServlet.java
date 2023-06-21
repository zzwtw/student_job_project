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
		request.setCharacterEncoding("UTF-8");
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");
		
		// 把注册信息构建成一个对象进行传输
		Users user = new Users(0,nickName,Integer.parseInt(sex),password);
		boolean result = iuserServices.register(user);
		if(result) {
//			response.sendRedirect("index.html");
			request.setAttribute("info", "网络原因，注册失败，请重新注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
//			response.sendRedirect("index.html");
			request.setAttribute("info", "网络原因，注册失败，请重新注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
	
}
