package com.springlec.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class FormBoard {
	
	// parameter 받는 방법 1
		@RequestMapping("/checkid")
		public String checkId(Model model, HttpServletRequest request) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			model.addAttribute("id", id);
			model.addAttribute("pw", pw);
			
			return "board/confirmid";
		}
	
	
	// parameter 받는 방법 2
	@RequestMapping("/confirmid")
	public String confirmId(Model model,@RequestParam("id")String id ,@RequestParam("pw")String pw) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmid";
	}
	
	// parameter 받은 거 dto 쓰기
	// dto field name 과 jsp el 태그 이름이 같으면 mapping 한다. 
	@RequestMapping("/join")
	public String join(Member member) {	
		return "board/join";
	}
	
	
}
