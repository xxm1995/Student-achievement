package cn.xxm.dao;

import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

/**
 * 拦截器
 * @author 小小明
 *
 */
  
public class LoginFilter extends HttpServlet implements Filter {  
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8567359843013876948L;

	public void destroy() {  
    }  
  
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
        FilterChain filterChain) throws IOException, ServletException{  
        HttpServletRequest request = (HttpServletRequest) sRequest;        
        HttpServletResponse response = (HttpServletResponse) sResponse;        
        HttpSession session = request.getSession();        
        String url=request.getServletPath();    
        String contextPath=request.getContextPath();    
        if(url.equals("")) url+="/";    
        if((url.startsWith("/")&&!url.startsWith("/login"))){//若访问后台资源 过滤到login    
        	String user=(String)session.getAttribute("username");    
             if(user==null){//转入管理员登陆页面    
            	 request.getSession().setAttribute("message", "请先进行登陆后再操作");
                 response.sendRedirect(contextPath+"/login.jsp");  
                  return;    
             }    
        }    
          filterChain.doFilter(sRequest, sResponse);
    }    
  
    public void init(FilterConfig arg0) throws ServletException {  
  
    }

    
}  