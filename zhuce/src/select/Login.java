package select;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SqlUtils;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		if (name==null||name.equalsIgnoreCase("")||pswd==null||pswd.equals("")) {
			request.setAttribute("msg", "账号密码不得为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			cook(response, name);
			return;
		}
		try {
			Connection con = SqlUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from zhuce where name=? and pswd=?");
			ps.setString(1, name);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				cook(response, name);
				session.setAttribute("name", name);
				response.sendRedirect("dlh.jsp");
				return;
			} else {
				request.setAttribute("msg", "账号密码错误");
				HttpSession session = request.getSession();
				cook(response, name);
				request.getRequestDispatcher("dlh.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	private void cook(HttpServletResponse response,String name) {
		Cookie cook = new Cookie("name", name);
		cook.setMaxAge(60*60*24);
		response.addCookie(cook);
	}
}
