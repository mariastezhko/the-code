package com.codingdojo.thecode;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String code(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {	
		System.out.println(code);
		if (code.equals("bushido")){
			return "redirect:/code";
		} else {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
		}
	}
	
	@RequestMapping(value="/code", method=RequestMethod.GET)
	public String code() {	
		return "code.jsp";
	}
	
}
