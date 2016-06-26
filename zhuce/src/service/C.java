package service;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SqlUtils;

public class C extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			Connection con = SqlUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from xs ");
			ResultSet rs = ps.executeQuery();
			int j = rs.getMetaData().getColumnCount();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (rs.next()) {
				String[] s = new String[3];
				for (int i = 1; i <= j; i++) {
					s[i-1]=(String) rs.getObject(i);
				}
				list.add(s);
				System.out.println();
			}
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			response.sendRedirect("zsgc/list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
