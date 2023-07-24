

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ServletContext application = request.getServletContext();
		String v_ = request.getParameter("value");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		// 여태까지 application에 들어온 값을 계산해준다. 
		if(op.equals("=")) {
			int result = 0;
			
			// application value에 담겨져 있는 내용
			int x = (Integer) application.getAttribute("value"); // Object 객체로 반환
			// 지금 v로 들어온 내용	
			int y = v;
			
			// application에 들어있는 연산자가 들어올 변수 선언
			String pre_op = (String) application.getAttribute("op");
			
			if(pre_op.equals("+")) {
				result = x + y;
			}else {
				result = x - y;
			}
			
			response.getWriter().println("결과는 " + result + "입니다.");
			
			//attribute 값 다시 초기화 시킨다.
			application.removeAttribute("value");
			application.removeAttribute("op");
			
		}
		// + or - 일 경우에는 값을 application 객체에 저장을 해준다. 
		else {
			Enumeration<String> a = application.getAttributeNames();
			String str = "";
			while(a.hasMoreElements()) {
				str += a.nextElement() + ",";
			}
			// application 객체 생성
			// application에 attribute 로 연산자와 숫자를 넣어준다. -> application.setAttribute(key, value) 로 넣어준다. 
			if(!str.contains("op")) {
				application.setAttribute("value", v);
				application.setAttribute("op", op);
			}else {
				int result = 0;
				String pre_op = (String) application.getAttribute("op");
				if(pre_op.equals("+")) {
					result = (Integer)application.getAttribute("value") + v;
				}else {
					result = (Integer)application.getAttribute("value") + v;
				}
				application.setAttribute("value", result);
				application.setAttribute("op", op);
			}

			response.sendRedirect("http://localhost:8080/MakeStatic/calc.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
