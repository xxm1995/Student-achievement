package cn.xxm.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jdbc.JdbcUtils;
import cn.xxm.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//获取请求参数  模型驱动  
@SuppressWarnings(value = { "all" })
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -9069544727463018774L;
	private User user = new User();

	public User getModel() {
		return user;
	}

	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		// 2.判断用户名与密码是否正确
		try {
			String name = user.getUsername();
			String pswd = user.getPassword();
			if (name==null||name.equalsIgnoreCase("")||pswd==null||pswd.equals("")) {
				request.getSession().setAttribute("message", "账号密码不得为空");
				return "failer";
			}
//			Connection con = SqlUtils.getConnection();
//			PreparedStatement ps = con.prepareStatement("select * from zhuce where name=? and pswd=?");
//			ps.setString(1, name);
//			ps.setString(2, pswd);
//			ResultSet rs = ps.executeQuery();
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());  
	        String sql = "select * from zhuce where username=? and password=?";  
	        User query = (User) runner.query(sql, new BeanHandler(User.class),name,pswd);  
	        
			if (query!=null) {
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().removeAttribute("message");
				request.getSession().setAttribute("io" , query.getIo());
				return SUCCESS;
			} else {
				request.getSession().setAttribute("message", "用户名或密码错误");
				return "failer";
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "failer";
	}

}
