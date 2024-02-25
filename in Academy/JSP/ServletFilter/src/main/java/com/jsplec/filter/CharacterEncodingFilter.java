package com.jsplec.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/*")
public class CharacterEncodingFilter extends HttpFilter implements Filter {
       

    public CharacterEncodingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// servlet 실행 전에 시행 되는 코드이다. 
		// 모드 servlet의 characterencoding을 utf-8로 만들어준다. 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("before filter");
		
		// servlet 실행을 검사하는 녀석이다. 
		// 흐름을 그대로 가기 위해서는 이 밑에 코드를 입력하면 되고, 아니라면 다른 조건을 넣어주면 된다. 
		chain.doFilter(request, response);
		
		// servlet 실행이 되고 시행이 되는 코드이다.
		System.out.println("after filter");
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
