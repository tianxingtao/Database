package com.ssh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Orderinfo;
import com.ssh.entity.Productinfo;
import com.ssh.entity.User;
import com.ssh.service.OrderinfoService;
import com.ssh.service.PcollectService;
import com.ssh.service.PcommentService;
import com.ssh.service.PcommentconfigService;
import com.ssh.service.ProductinfoService;
import com.ssh.service.ProductsService;
import com.ssh.service.PshoppingcartService;
import com.ssh.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	ProductinfoService productinfoService;

	@Autowired
	PshoppingcartService pshoppingcartService;
	
	@Autowired
	OrderinfoService orderinfoservice;
	
	@Autowired
	ProductsService productsService;
	
	@Autowired
	PcollectService pcollectService;
	
	@Autowired
	PcommentService pcommentService;
	
	@Autowired
	PcommentconfigService pcommentconfigService;

	@Autowired
	private UserService userservice;
	
	
}
