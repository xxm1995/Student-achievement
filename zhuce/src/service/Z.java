package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SqlUtils;

public class Z extends HttpServlet {
	private static final long serialVersionUID = 4816073072664894573L;

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String add = request.getParameter("add");
		if ((name+sex+add)==null||(name+sex+add).equals("")) {
			request.setAttribute("msg", "空错误");
			request.getRequestDispatcher("zsgc/z.jsp").forward(request, response);;
			return;
		}
		try {
			Connection con = SqlUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from xs where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				ps = con.prepareStatement("insert into xs value(?,?,?)");
				ps.setString(1, name);
				ps.setString(2, sex);
				ps.setString(3, add);
				ps.executeUpdate();
				request.setAttribute("msg", "ok了");
				request.getRequestDispatcher("zsgc/z.jsp").forward(request, response);;
				return;
			} else {
				request.setAttribute("msg", "存在错误");
				request.getRequestDispatcher("zsgc/z.jsp").forward(request, response);;
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
