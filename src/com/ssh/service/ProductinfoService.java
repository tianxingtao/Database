package com.ssh.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssh.dao.ProductinfoDAO;
import com.ssh.entity.Productinfo;

@Transactional
@Service
public class ProductinfoService {
	
	@Autowired
	private ProductinfoDAO productinfoDAO;

	public List<Productinfo> getProductinfos(){
		return this.productinfoDAO.getProductinfos();
	}
	
	public void addProductinfo(Productinfo productinfo,MultipartFile file,HttpServletRequest request) {
		if(file != null) {
			String originalFileName = file.getOriginalFilename(); 
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")); 
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            // 图片存储路径
            String path="view/img/";
            String filePath =  request.getSession().getServletContext().getRealPath(path)+ fileName;
            File saveFile = new File(filePath);
            try {
                // 将上传的文件保存到服务器文件系统
                file.transferTo(saveFile);
                // 记录服务器文件系统图片名称
                productinfo.setPicturelocation(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		this.productinfoDAO.addProductinfo(productinfo);
	}
	
    public void updateProductinfo(Productinfo productinfo,MultipartFile file,HttpServletRequest request) {
		if(file != null) {
			String originalFileName = file.getOriginalFilename(); 
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")); 
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            // 图片存储路径
            String path="view/img/";
            String filePath =  request.getSession().getServletContext().getRealPath(path)+ fileName;
            File saveFile = new File(filePath);
            try {
                // 将上传的文件保存到服务器文件系统
                file.transferTo(saveFile);
                // 记录服务器文件系统图片名称
                productinfo.setPicturelocation(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		this.productinfoDAO.updateProductinfo(productinfo);
	}

    public void deleteProductinfo(Productinfo productinfo) {
    	this.productinfoDAO.deleteProductinfo(productinfo);
    }
    
	public void delProductinfoById(int id)
	{
		this.productinfoDAO.delProductinfoById(id);
	}
	
	public Productinfo getProductinfoById(int id)
	{
		return this.productinfoDAO.getProductinfoById(id);
	}
    
	public List<Productinfo> getProductinfoByType(String type) {
		return this.productinfoDAO.getProductinfoByType(type);
	}
	
	public List<Productinfo> getProductinfoByCid(String cid){
		return this.productinfoDAO.getProductinfoByCid(cid);
	}
	
	public List<Productinfo> getProductinfoByHql(String hql){
		return this.productinfoDAO.getProductinfoByHql(hql);
	}
}
