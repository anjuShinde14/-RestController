package com.nimap.Task.service;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimap.Task.dao.MainDao;
import com.nimap.Task.entity.Categories;
import com.nimap.Task.entity.Products;

@Service
public class MainService {
    @Autowired
	MainDao dao;
	
	public String addcategories(Categories c) {
		String msg= dao.addcategories(c);
		
		if(Objects.isNull(msg)) {
			msg="Data is not added succesfully...";
		}
		return msg;
	}

	
	
	
	public List<Categories> getAllcategories(int page) {
		List<Categories> list=dao.getAllcategories(page);
		return list;
	}
	
	
	
    public Categories CategoriesByID(int id) {
		
		Categories c=dao.categoriesByID(id);
		if(Objects.isNull(c)) {
			c=null;
		}
		return c;
	}


	public String updateCategories(Categories c) {
		
		String msg= dao.updateCategories(c);
		
		if(Objects.isNull(msg)) {
			msg="Record Is not be updatated";
		}
	
		return msg;
	}


	public String deletCategories(int id) {
    String msg= dao.deleteCategories(id);
		 
		 if(Objects.isNull(msg)) {
				msg="Record is not be Deleted...";
			}
		return msg;
	}


	public String addProducts(Products p) {
     String msg= dao.addProducts(p);
		
		if(Objects.isNull(msg)) {
			msg="Data is not added...";
		}
		return msg;
	}


	public List<Products> getAllProducts(int page) {
		List<Products> list=dao.getAllProducts(page);
		return list;
	}


	public String updateProducts(Products p) {
    String msg= dao.updateProducts(p);
		
		if(Objects.isNull(msg)) {
			msg="Record Is not be updatated....";
		}
	
		return msg;
	}


	public Products productById(int id) {
		Products p=dao.ProductsByID(id);
		if(Objects.isNull(p)) {
			p=null;
		}
		return p;
	}




	public String deletProducts(int id) {
    String msg= dao.deleteProducts(id);
		 
		 if(Objects.isNull(msg)) {
				msg="Record is not be Deleted...";
			}
		return msg;
	}
	
}