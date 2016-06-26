package cn.xxm.domain;

/**
 * 用户JavaBean
 * @author 小小明
 *
 */
public class User {

	private String username;
	private String password;
	private String io;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIo() {
		return io;
	}
	public void setIo(String io) {
		this.io = io;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", io=" + io + "]";
	}

	
}
