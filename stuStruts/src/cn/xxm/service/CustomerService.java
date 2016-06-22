package cn.xxm.service;

import java.util.List;

import cn.xxm.dao.CustomerDao;
import cn.xxm.domain.Customer;

/**
 * 业务层
 * @author 小小明
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	/**
	 * 添加学生
	 * @param c
	 */
	public void add(Customer c) {
		customerDao.add(c);
	}
	/**
	 * 删除学生
	 * @return
	 */
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	
	/**
	 * 查询所有
	 */
	public void del(String cid) {
		customerDao.del(cid);
	}

	/**
	 * 加载学生
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		return customerDao.load(cid);
	}

	/**
	 * 编辑学生
	 * @param c
	 */
	public void edit(Customer c) {
		customerDao.edit(c);
	}

	/**
	 * 多条件组合查询
	 * @param criteria
	 * @return
	 */
	public List<Customer> query(Customer criteria) {
		return customerDao.query(criteria);
	}
}
