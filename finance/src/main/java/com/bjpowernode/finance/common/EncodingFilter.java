package com.bjpowernode.finance.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 对所有乱码进行拦截及纠正，包括get提交方式，解决get提交方式乱码，方式是重写了request的getParameter方法，
 * 让其在返回值的时候检查提交方式，如果为“get”就进行解码。 使用过滤器的@WebFilter注解进行配置和值的初始化
 */
@WebFilter(filterName = "encodingFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "code", value = "utf-8") })
public class EncodingFilter implements Filter {

	private String code = null;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置码表
		request.setCharacterEncoding(code);
		response.setCharacterEncoding(code);
		response.setContentType("text/html;charset=" + code);
		// 将现在的reuqest对象换成我自己的request对象
		MyHttpServletRequest myRequest = new MyHttpServletRequest((HttpServletRequest) request);
		//System.out.println("Filter");
		// 跳转到请求的资源，并传入自己定义的myRequest对象
		chain.doFilter(myRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 获取配置的编码格式
		code = fConfig.getInitParameter("code");
		// 获取xml文件<init-param>标签中code的value//如果没有配置，就使用UTF-8默认编码
		this.code = code == null || "".equals(code.trim()) ? "utf-8" : code;
	}

	// 重新定义一个自己的request对象，继承HttpServletRequestWrapper 这个HttpServletRequest的适配器
	class MyHttpServletRequest extends HttpServletRequestWrapper {
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
		}

		// 重写getParameter方法
		@Override
		public String getParameter(String name) {
			String value = super.getParameter(name);
			if (value == null)
				return null;
			// 判断只要不是“get”方式提交就直接返回，equalsIgnoreCase方法是不考虑大小写的匹配
			if (!"get".equalsIgnoreCase(super.getMethod()))
				return value;
			// 如果请求方式为"get",那么就进行加码，解码码表为父类的码表
			try {
				value = new String(value.getBytes("ISO-8859-1"), super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			return value;
		}

	}
}
