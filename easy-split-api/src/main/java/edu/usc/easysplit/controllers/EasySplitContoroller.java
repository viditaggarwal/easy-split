package edu.usc.easysplit.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.usc.easysplit.GroupRequest;
import edu.usc.easysplit.GroupResponse;
import edu.usc.easysplit.LoginRequest;
import edu.usc.easysplit.LoginResponse;
import edu.usc.easysplit.services.IGroupService;
import edu.usc.easysplit.services.ILoginService;

@Controller
public class EasySplitContoroller {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IGroupService groupService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LoginResponse login (@RequestBody LoginRequest request, HttpServletResponse httpResponse) {
		return this.loginService.loginUser(request);
	}
	
	@RequestMapping(value = "/createGroup", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroupResponse createGroup (@RequestBody GroupRequest request, HttpServletResponse httpResponse) {
		return this.groupService.createGroup(request);
	}
}
