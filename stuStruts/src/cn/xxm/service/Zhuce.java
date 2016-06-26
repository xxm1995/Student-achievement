package cn.xxm.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jdbc.JdbcUtils;
import cn.xxm.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 注册
 * @author 小小明
 *
 */
@SuppressWarnings(value = { "all" })
public class Zhuce extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -9038135419570885837L;
	private User user = new User();

	public User getModel() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String name = user.getUsername();
		String pswd = user.getPassword();
		String io = user.getIo();
		System.out.println(name+" "+io);
		if (name==null||name.equalsIgnoreCase("")||pswd==null||pswd.equals("")) {
			request.getSession().setAttribute("message", "账号密码不得为空");
			return "failer";
		}
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());  
	        String sql = "select * from zhuce where username=?"; 
	        User query = (User) runner.query(sql, new BeanHandler(User.class),name);
	        System.out.println(2);
			if (query==null) {
				System.out.println(3);
				sql = "insert into zhuce value(?,?,?)";
				System.out.println(io);
				runner.update(sql, new Object[]{name,pswd,io});
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().removeAttribute("message");
				return SUCCESS;
			} else {
				request.getSession().setAttribute("message", "账号已经存在");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		}
		return "failer";
	}
}
