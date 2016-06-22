package cn.xxm.service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
/**
 * 退出账号
 * @author 小小明
 *
 */
public class tui extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -530332908737486697L;

	public void doGet() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		request.getSession().removeAttribute("message");
		response.sendRedirect("login.jsp");
	}
}
