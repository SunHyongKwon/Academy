package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class Controller_02 {
	
	@RequestMapping("/view")
	public String index2() {
		
		return "board/view";
	}
	
	@RequestMapping("/content")
	public String index3(Model model) {
		// request.setAttribute 와 같은 방식이지만 spring에서 사용하는 방법 1
		// 지금 사용하는 방법
		model.addAttribute("id","kim");
		model.addAttribute("age",30);

		return "board/content";
	}
	
	@RequestMapping("/reply")
	public ModelAndView index4(Model model) {
		ModelAndView mv = new ModelAndView();
		
		// request.setAttribute 와 같은 방식이지만 spring에서 사용하는 방법 2 
		// spring3에서 사용하는 방법이었지만 , 사용방법은 알아야 예전 코드들을 읽을 수 있기 때문에 알고 있어야 한다. 
		// 보안에 굉장히 좋다. viewname과 attribute들을 사용하면 된다. 
		mv.addObject("id","kim");
		mv.addObject("age",20);
		mv.setViewName("board/reply");
		
		return mv;
	}
}
