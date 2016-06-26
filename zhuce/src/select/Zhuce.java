package select;

import java.io.IOException;
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

public class Zhuce extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = (String) request.getParameter("name");
		String pswd = (String) request.getParameter("pswd");
		if (name==null||name.equalsIgnoreCase("")||pswd==null||pswd.equals("")) {
			request.setAttribute("msg", "账号密码不得为空");
			request.getRequestDispatcher("zhuce.jsp").forward(request, response);
			cook(response, name);
			return;
		}
		try {
			Connection con = SqlUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from zhuce where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				ps.setString(1, name);
				ps = con.prepareStatement("insert into zhuce value(?,?)");
				ps.setString(1, name);
				ps.setString(2, pswd);
				ps.executeUpdate();
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				cook(response, name);
				response.sendRedirect("ok.jsp");
				return;

			} else {
				System.out.println(2);
				request.setAttribute("msg", "账号已经存在");
				cook(response, name);
				request.getRequestDispatcher("zhuce.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void cook(HttpServletResponse response,String name) {
		Cookie cook = new Cookie("name", name);
		cook.setMaxAge(60*60*24);
		response.addCookie(cook);
	}
}
