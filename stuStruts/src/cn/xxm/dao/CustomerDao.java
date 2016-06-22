package cn.xxm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.xxm.domain.Customer;

/**
 * 持久层
 * 
 *  
  	CREATE TABLE customer(
	cid VARCHAR(55) PRIMARY KEY,
	cname VARCHAR(55),
	sdept VARCHAR(55),
	java VARCHAR(55),
	python VARCHAR(55),
	android VARCHAR(55)
);
 * 
 * @author cxf
 * 
 */
public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加学生
	 * 
	 * @param c
	 */
	public void add(Customer c) {
		try {
			String sql = "insert into customer values(?,?,?,?,?,?)";
			Object[] params = { c.getCid(),c.getCname(),c.getSdept(),c.getJava(),
					c.getPython(),c.getAndroid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 编辑学生
	 * @param c
	 */
	public void del(String cid) {
		try {
			String sql = "delete from customer where cid=?";
			
			qr.update(sql, cid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll() {
		try {
			String sql = "select * from customer";
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载学生
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		try {
			String sql = "select * from customer where cid=?";
			return qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑学生
	 * @param c
	 */
	public void edit(Customer c) {
		try {
			String sql = "update customer set cname=?,sdept=?,java=?,"
					+ "python=?,android=? where cid=?";
			Object[] params = {c.getCname(),c.getSdept(),c.getJava(),
					c.getPython(),c.getAndroid(),c.getCid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 多条件组合查询
	 * @param criteria
	 * @return
	 */
	public List<Customer> query(Customer criteria) {
		try {
			StringBuilder sql = new StringBuilder("select * from customer where 1=1");
			List<Object> params = new ArrayList<Object>();
			String cname = criteria.getCname();
			if(cname != null && !cname.trim().isEmpty()) {
				sql.append(" and cname like ?");
				params.add("%" + cname + "%");
			}
			
			String cid = criteria.getCid();
			if(cid != null && !cid.trim().isEmpty()) {
				sql.append(" and cid like ?");
				params.add("%" + cid + "%");
			}
			
			String sdept = criteria.getSdept();
			if(sdept != null && !sdept.trim().isEmpty()) {
				sql.append(" and cellphone like ?");
				params.add("%" + sdept + "%");
			}
			
//			String email = criteria.getEmail();
//			if(email != null && !email.trim().isEmpty()) {
//				sql.append(" and email like ?");
//				params.add("%" + email + "%");
//			}
			
			/*
			 * 三、执行query
			 */
			return qr.query(sql.toString(), 
					new BeanListHandler<Customer>(Customer.class), 
					params.toArray());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
