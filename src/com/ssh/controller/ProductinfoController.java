package com.ssh.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.ssh.entity.*;
import com.ssh.service.*;





@Controller
@RequestMapping(value="/productinfo")
public class ProductinfoController {
	
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
	UserService userservice;
	
	@Autowired
	ComService comservice;
	
	@RequestMapping("/loginuid")
	public String loginuid(String uid,String password,HttpServletRequest request)
	{
		//todo
		User user=userservice.getUserById(uid);
		if(user==null)
		{
			return "error";
		}
		if(password.equals(user.getPassword()))
		{
			request.setAttribute("uid", uid);
			return "index";
		}
		return "error";
	}
	
	
	@RequestMapping("/logincid")
	public String logincid(String cid,String password,HttpServletRequest request)
	{
		//todo
		Com com=comservice.getComById(cid);
		if(com==null)
		{
			return "error";
		}
		if(password.equals(com.getPassword()))
		{
			request.setAttribute("cid", cid);
			return  this.productinfoshowbycid(cid,request);
		}
		return "error";
	}
	@RequestMapping("/registercid")
	public String registercid(String cid,String password,String address,String phone,HttpServletRequest request)
	{
	    //todo
		Com com=new Com(cid,password,address,phone);
		comservice.addCom(com);
		
		request.setAttribute("cid", cid);
		return this.productinfoshowbycid(cid,request);
	}
	@RequestMapping("/registeruid")
	public String registeruid(String uid,String password,String type,String phone,HttpServletRequest request)
	{
		//todo
		User user=new User(uid,password,type,phone);
		userservice.addUser(user);
		
		request.setAttribute("uid", uid);
		return "index";
	}
	
	
	
	
	
	
	
	
	//展示所有商品
	@RequestMapping("/productinfoshow")
	public String showProductinfo(String uid, HttpServletRequest request)
	{
		List<Productinfo> lists=this.productinfoService.getProductinfos();
		request.setAttribute("productionlist", lists);
		request.setAttribute("uid", uid);
		return "productinfoshow";
	}
	
	//通过名字搜索跳转
	@RequestMapping("/productinfoshowdetailbyname")
	public String productinfoshowdetailbyname(String name,String uid,HttpServletRequest request) {
		
		String hql="from Productinfo as productinfo where productinfo.pname like '%"+name+"%'";
		List<Productinfo> list=this.productinfoService.getProductinfoByHql(hql);
		request.setAttribute("productionlist", list);
		request.setAttribute("uid", uid);
		return "productinfoshow";
	}
	
	//通过类型搜索调转
	@RequestMapping("/productinfoshowdetailbytype")
	public String productinfoshowdetailbytype(String type,String uid,HttpServletRequest request) {
		System.out.println("ksjafh"+type);
		List<Productinfo> list=this.productinfoService.getProductinfoByType(type);
		request.setAttribute("productionlist", list);
		request.setAttribute("uid", uid);
		return "productinfoshow";
	}
	
	//展示商品详情
	@RequestMapping("/productinfoshowdetail")
	public String productinfoshowdetail(int pid,String uid,HttpServletRequest request) {
		Productinfo productinfo=this.productinfoService.getProductinfoById(pid);
		productinfo.setPview(productinfo.getPview()+1);
		this.productinfoService.updateProductinfo(productinfo, null, request);
		List<Pcomment> list=this.pcommentService.getPcommentByPUid(pid, uid);
		request.setAttribute("production", productinfo);
		request.setAttribute("uid", uid);
		request.setAttribute("pcomment", list);
		return "productinfoshowdetail";
	}
	
	@RequestMapping("/productinfoaddcommentuid")
	public String productinfoaddcommentuid(int pid,String uid,String pcomment,int p,HttpServletRequest request) {
		Pcommentconfig pcommentconfig=this.pcommentconfigService.getPcommentconfigByPUidUnique(pid, uid);
		if(pcommentconfig==null) {
			Pcommentconfig pcommentconfig2=new Pcommentconfig();
			pcommentconfig2.setPid(pid);
			pcommentconfig2.setUid(uid);
			this.pcommentconfigService.addPcommentconfig(pcommentconfig2);
		}
		Pcomment pcomment2=new Pcomment();
		pcomment2.setPcomment(pcomment);
		pcomment2.setPid(pid);
		pcomment2.setUid(uid);
		pcomment2.setPspeaker("u");
		this.pcommentService.addPcomment(pcomment2);
		return this.productinfoshowdetail(pid, uid, request);
	}
	

	//加入购物车
	@RequestMapping("/productinfoaddshoppingcart")
	public String productinfoaddshoppingcart(String pid,String uid,int buyNumber,HttpServletRequest request) {
		if(uid==null) {
			request.setAttribute("pid", pid);
			return "productinfologinfirst";
		}
		Pshoppingcart pshoppingcart=new Pshoppingcart();
		pshoppingcart.setNum(buyNumber);
		pshoppingcart.setPid(Integer.valueOf(pid));
		pshoppingcart.setUid(uid);
		this.pshoppingcartService.addPshoppingcart(pshoppingcart);
		request.setAttribute("uid", uid);
		return this.productinfoshowshoppingcart( uid, request);
	}
	//加入收藏
	@RequestMapping("/productinfoaddcollection")
	public String productinfoaddcollection(int pid,String uid,int num,HttpServletRequest request) {
		if(uid==null) {
			request.setAttribute("pid", pid);
			return "productinfologinfirst";
		}
		Pcollection pcollection=new Pcollection();
		pcollection.setPid(pid);
		pcollection.setUid(uid);
		this.pcollectService.addPcollection(pcollection);
		request.setAttribute("uid", uid);
		return this.productinfoshowdetail(pid, uid, request);
	}
	
	
	
	

	
	//下单
	@RequestMapping("/productinfoaddorder")
	public String productinfoaddorder(int pid,String uid,int buyNumber,HttpServletRequest request,int psid) {
		if(uid==null) {
			request.setAttribute("pid", pid);
			return "productinfologinfirst";
		}
		Productinfo productinfo=this.productinfoService.getProductinfoById(pid);
		float price=productinfo.getPrice()*buyNumber;
		request.setAttribute("pname", productinfo.getPname());
		request.setAttribute("price", price);
		request.setAttribute("num", buyNumber);
		request.setAttribute("pid", pid);
		request.setAttribute("psid", psid);
		request.setAttribute("uid", uid);
		
		return "productinfoaddress";
	}
	
	
	//确认下单
	@RequestMapping("/p")
	public String p(String pid,String uid,String num,String price,String address,String psid,HttpServletRequest request) {
		/*
		 * if(price>User.package){
		 * return "productinfoaddunsuccesswithprice";
		 * }
		 */
		/*
		 * if(num>Productinfo.pnum){
		 * return "productinfoaddorderunsuccesswithnum";
		 * }
		 */


		
		Orderinfo orderinfo=new Orderinfo();
		orderinfo.setPid(Integer.valueOf(pid));
		orderinfo.setUid(uid);
		orderinfo.setNum(Integer.valueOf(num));
		System.out.println(Integer.valueOf(num)*this.productinfoService.getProductinfoById(Integer.valueOf(pid)).getPrice());
		orderinfo.setPrice(Integer.valueOf(num)*this.productinfoService.getProductinfoById(Integer.valueOf(pid)).getPrice());
		orderinfo.setAddress(address);
		orderinfo.setTime(new Date());
		this.orderinfoservice.addOrderinfo(orderinfo);
		this.pshoppingcartService.delPshoppingcartById(Integer.valueOf(psid));
		return this.productinfoordershow( uid,request);
	}
	
	
	
	
	
	//确认下单
	@RequestMapping("/productinfocheck")
	public String productinfocheck(int pid,String uid,int num,float price,String address,int psid,HttpServletRequest request) {
		/*
		 * if(price>User.package){
		 * return "productinfoaddunsuccesswithprice";
		 * }
		 */
		/*
		 * if(num>Productinfo.pnum){
		 * return "productinfoaddorderunsuccesswithnum";
		 * }
		 */
		System.out.println(pid);
		System.out.println(uid);
		System.out.println(num);
		System.out.println(price);
		System.out.println(address);
		
		for(int i=0;i<50;i++)
			System.out.println("------");
		
		Orderinfo orderinfo=new Orderinfo();
		orderinfo.setPid(pid);
		orderinfo.setUid(uid);
		orderinfo.setNum(num);
		orderinfo.setPrice(price);
		orderinfo.setAddress(address);
		orderinfo.setTime(new Date());
		this.orderinfoservice.addOrderinfo(orderinfo);
		this.pshoppingcartService.delPshoppingcartById(psid);
		return this.productinfoordershow( uid,request);
	}
	

	
	
	//展示购物车
	@RequestMapping("/productinfoshowshoppingcart")
	public String productinfoshowshoppingcart(String uid,HttpServletRequest request) {
		List<Pshoppingcart> list=this.pshoppingcartService.getPshoppingcartByuid(uid);                                            
		List<Productinfo> list2=new ArrayList<Productinfo>();
		for(int i=0;i<list.size();i++) {
			list2.add(this.productinfoService.getProductinfoById(list.get(i).getPid()));
		}
		request.setAttribute("productlist", list2);
		request.setAttribute("numlist", list);
		request.setAttribute("uid", uid);
		return "productinfoshowshoppingcart";
	}
	
	//展示收藏
	@RequestMapping("/productinfoshowcollect")
	public String productinfoshowcollect(String uid,HttpServletRequest request) {
		List<Pcollection> list=this.pcollectService.getPcollectionByuid(uid);                                            
		List<Productinfo> list2=new ArrayList<Productinfo>();
		for(int i=0;i<list.size();i++) {
			list2.add(this.productinfoService.getProductinfoById(list.get(i).getPid()));
		}
		request.setAttribute("productlist", list2);                                
		request.setAttribute("uid", uid);
		return "productinfoshowcollect";
	}
	
	//删除购物车某项商品
	@RequestMapping("/productinfodeleteshoppingcart")
	public String productinfodeleteshoppingcart(String uid,int psid,HttpServletRequest request) {
		this.pshoppingcartService.delPshoppingcartById(psid);
		return this.productinfoshowshoppingcart(uid, request);
	}
	
	//删除收藏某项商品
	@RequestMapping("/productinfodeletecollect")
	public String productinfodeletecollect(String uid,int pcid,HttpServletRequest request) {
		this.pcollectService.delPcollectionById(pcid);
		return this.productinfoshowcollect(uid, request);
	}
	/*
	@RequestMapping("/productinfocollectshowdetail")
	public String productinfocollectshow(String uid,int pid,HttpServletRequest request) {
		return this.productinfoshowdetail(pid, uid, request);
	}
	
	@RequestMapping("/productinfoshoppingshowdetail")
	public String productinfoshoppingshow(String uid,int pid,HttpServletRequest request) {
		return this.productinfoshowdetail(pid, uid, request);
	}
	*/
	
	//显示所有订单详情
	@RequestMapping("/productinfoordershow")
	public String productinfoordershow(String uid,HttpServletRequest request) {
		
		
		List<Orderinfo> lists=this.orderinfoservice.getOrderinfoByUid(uid);
		List<Orderproduct> list=new ArrayList<Orderproduct>();
		for(int i=0;i<lists.size();i++) {
			Productinfo productinfo=this.productinfoService.getProductinfoById(lists.get(i).getPid());
			Orderproduct o=new Orderproduct(lists.get(i),productinfo);
			list.add(o);
		}
		request.setAttribute("orderproduct", list);
		request.setAttribute("uid", uid);
		return "productinfoordershow";
	}

	//显示订单详情
	@RequestMapping("/productinfoorderdetailshow")
	public String productinfoordershow(int oid,String uid,HttpServletRequest request) {
		Orderinfo orderinfo=this.orderinfoservice.getOrderinfoById(oid);
		Productinfo productinfo=this.productinfoService.getProductinfoById(orderinfo.getPid());
		request.setAttribute("orderinfo", orderinfo);
		request.setAttribute("productinfo", productinfo);
		request.setAttribute("uid", uid);
		return "productinfoorderdetailshow";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//显示该公司下的商品
	@RequestMapping("/productinfoshowbycid")
	public String productinfoshowbycid(String cid,HttpServletRequest request) {
		List<Productinfo> lists=this.productinfoService.getProductinfoByCid(cid);                                
		request.setAttribute("productionlist", lists);
		request.setAttribute("cid", cid);
		return "productinfoshowbycid";
	}
	
	
	//评论相关的
	@RequestMapping("/productinfoshowbyciddetail")
	public String productinfoshowbycid(int pid,HttpServletRequest request) {
		Productinfo productinfo=this.productinfoService.getProductinfoById(pid);
		List<Pcommentconfig> lists=this.pcommentconfigService.getPcommentconfigByPid(pid);
		request.setAttribute("productinfo", productinfo);
		request.setAttribute("pcommentconfig", lists);
		return "productinfoshowbyciddetail";
	}
	
	@RequestMapping("/productinfoshowbycidshowcomment")
	public String productinfoshowbycidshowcomment(int pid,String uid,HttpServletRequest request) {
		List<Pcomment> pcomments=this.pcommentService.getPcommentByPUid(pid, uid);
		request.setAttribute("pcomment", pcomments);
		return "productinfoshowbycidshowcomment";
	}
	
	@RequestMapping("/productinfoshowbycidaddcomment")
	public String productinfoshowbycidaddcomment(int pid,String uid,String comment,HttpServletRequest request) {
		Pcomment pcomment=new Pcomment();
		pcomment.setPid(pid);
		pcomment.setUid(uid);
		pcomment.setPspeaker("p");
		pcomment.setPcomment(comment);
		this.pcommentService.addPcomment(pcomment);
		return this.productinfoshowbycidshowcomment(pid,uid,request);
	}
	
	//更新商品列表
	@RequestMapping("/productinfoupdatedetail")
	public String productinfoupdatedetail(int pid,String cid,HttpServletRequest request) {
		Productinfo productinfo=this.productinfoService.getProductinfoById(pid);
		request.setAttribute("productinfo", productinfo);
		request.setAttribute("cid", cid);
		return "productinfoupdate";
	}
	
	//更新商品
	@RequestMapping("/productinfoupdate")
	public String productinfoupdate(@RequestParam("imgFile") MultipartFile file,
			String pid,String pname,String type,String price,String introduce,String pnum,String cid,HttpServletRequest request) throws IOException{
		Productinfo productinfo=this.productinfoService.getProductinfoById(Integer.valueOf(pid));
		productinfo.setPname(pname);
		productinfo.setIntroduce(introduce);
		productinfo.setType(type);
		productinfo.setPrice(Float.parseFloat(price));
		this.productinfoService.updateProductinfo(productinfo, file, request);
		request.setAttribute("cid", productinfo.getCid());
		return this.productinfoshowbycid(productinfo.getCid(), request);
	}
	
	//添加商品列表
	@RequestMapping("/productinfoaddproductiondetail")
	public String productinfoaddproductiondetail(String cid,HttpServletRequest request) {
		request.setAttribute("cid", cid);
		return "productinfoaddproduction";
	}
	
	//添加商品
	@RequestMapping("/productinfoaddproduction")
	public String productinfoaddproduction(@RequestParam("imgFile") MultipartFile file,
			String pview,String pbuynum,String pname,String type,String price,String introduce,String pnum,String cid,HttpServletRequest request) throws IOException{
		
		
		System.out.println(cid);
		Productinfo productinfo=new Productinfo();
		productinfo.setPname(pname);
		productinfo.setCid(cid);
		productinfo.setIntroduce(introduce);
		productinfo.setPbuynum(0);
		productinfo.setPview(0);
		productinfo.setType(type);
		productinfo.setPrice(Float.parseFloat(price));
		productinfo.setPnum(Integer.valueOf(pnum));
		this.productinfoService.addProductinfo(productinfo, file, request);
		Products products=this.productsService.getProductsById(1);
		products.setPnum(products.getPnum()+1);
		this.productsService.updateProducts(products);
		
		
		return this.productinfoshowbycid(cid, request);
	}
	
	
	
	//删除
	@RequestMapping("/productinfodeleteproduction")
	public String delProductinfo(int pid,String cid,HttpServletRequest request){
		for(int i=0;i<50;i++)
		System.out.println(cid);
		String fileDir=request.getSession().getServletContext().getRealPath("view/img/")+this.productinfoService.getProductinfoById(pid).getPicturelocation();
		File file=new File(fileDir);
		if(file.exists())
			file.delete();
		this.productinfoService.delProductinfoById(pid);
		Products products=this.productsService.getProductsById(1);
		products.setPnum(products.getPnum()-1);
		this.productsService.updateProducts(products);
		return this.productinfoshowbycid(cid, request);
	}
	
}




