package com.stackroute.activitystream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServerPageController {
	@RequestMapping("/")
	public ModelAndView homepage()
	{
		ModelAndView mv = new ModelAndView("Home");
		return mv;
	}
}
