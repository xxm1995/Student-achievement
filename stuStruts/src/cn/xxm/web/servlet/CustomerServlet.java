package cn.xxm.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.itcast.commons.CommonUtils;
import cn.xxm.domain.Customer;
import cn.xxm.service.CustomerService;

/**
 * Web层
 * @author 小小明
 *
 */
public class CustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 981662245226895296L;
	private CustomerService customerService = new CustomerService();
	public void service()
			throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		request.setCharacterEncoding("UTF-8");
		/**
		 * 1. 获取method参数，它是用户想调用的方法 2. 把方法名称变成Method类的实例对象 3. 通过invoke()来调用这个方法
		 */
		String methodName = request.getParameter("method");
		Method method = null;
		/**
		 * 2. 通过方法名称获取Method对象
		 */
		try {
			method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法：" + methodName + "它不存在！", e);
		}
		
		/**
		 * 3. 通过method对象来调用它
		 */
		try {
			String result = (String)method.invoke(this, request, response);
			if(result != null && !result.trim().isEmpty()) {//如果请求处理方法返回不为空
				int index = result.indexOf(":");//获取第一个冒号的位置
				if(index == -1) {//如果没有冒号，使用转发
					request.getRequestDispatcher(result).forward(request, response);
				} else {//如果存在冒号
					String start = result.substring(0, index);//分割出前缀
					String path = result.substring(index + 1);//分割出路径
					if(start.equals("f")) {//前缀为f表示转发
						request.getRequestDispatcher(path).forward(request, response);
					} else if(start.equals("r")) {//前缀为r表示重定向
						response.sendRedirect(request.getContextPath() + path);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 添加客户
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象
		 * 2. 补全：cid，使用uuid
		 * 3. 使用service方法完成添加工作
		 * 4. 向request域中保存成功信息
		 * 5. 转发到msg.jsp
		 */
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.add(c);
		request.setAttribute("msg", "恭喜，添加客户成功！");
		return "f:/msg.jsp";
	}
	

	/**
	 * 编辑之前的加载工作
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取cid
		 * 2. 使用cid来调用service方法，得到Customer对象
		 * 3. 把Customer保存到request域中
		 * 4. 转发到edit.jsp显示在表单中
		 */
		String cid = request.getParameter("cid");
		customerService.del(cid);
		request.setAttribute("msg", "恭喜，删除客户成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 查询所有
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 调用service得到所有客户
		 * 2. 保存到request域
		 * 3. 转发到list.jsp
		 */
		request.setAttribute("cstmList", customerService.findAll());
		return "f:/list.jsp";
	}
	
	/**
	 * 编辑之前的加载工作
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取cid
		 * 2. 使用cid来调用service方法，得到Customer对象
		 * 3. 把Customer保存到request域中
		 * 4. 转发到edit.jsp显示在表单中
		 */
		String cid = request.getParameter("cid");
		Customer cstm = customerService.load(cid);
		request.setAttribute("cstm", cstm);
		return "f:/edit.jsp";
	}
	
	/**
	 * 编辑方法
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象中
		 * 2. 调用service方法完成修改
		 * 3. 保存成功信息到request域
		 * 4. 转发到msg.jsp显示成功信息
		 */
		// 已经封装了cid到Customer对象中
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(c);
		request.setAttribute("msg", "恭喜，编辑客户成功！");
		return "f:/msg.jsp";
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象中，它只有四个属性（cname、gender、cellphone、email）
		 *   它就是一个条件
		 * 2. 使用Customer调用service方法，得到List<Customer>
		 * 3. 保存到request域中
		 * 4. 转发到list.jsp
		 */
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		List<Customer> cstmList = customerService.query(criteria);
		request.setAttribute("cstmList", cstmList);
		return "/list.jsp";
	}
}















