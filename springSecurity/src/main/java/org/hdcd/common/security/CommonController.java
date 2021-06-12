package org.hdcd.common.security;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {

	@RequestMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("엑세스 야호 ");
		log.info("accessError :"+auth);
		
		model.addAttribute("msg","AccessDenied");
		
	}
}
