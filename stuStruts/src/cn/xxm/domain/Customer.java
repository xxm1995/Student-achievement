package cn.xxm.domain;

/**
 * 学生javaBean
 * 
 * @author 小小明
 * 
 */
public class Customer {
	/*
	 * 对应学生数据库表
	 */
	private String cid;
	private String cname;
	private String sdept;
	private String java;
	private String python;
	private String android;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getPython() {
		return python;
	}
	public void setPython(String python) {
		this.python = python;
	}
	public String getAndroid() {
		return android;
	}
	public void setAndroid(String android) {
		this.android = android;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", gender="
				+ sdept + ", java=" + java + ", python=" + python
				+ ", android=" + android + "]";
	}
	
}
