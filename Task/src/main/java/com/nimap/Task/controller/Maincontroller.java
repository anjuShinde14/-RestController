package com.nimap.Task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.Task.entity.Categories;
import com.nimap.Task.entity.Products;
import com.nimap.Task.service.MainService;


@RestController
@RequestMapping("/api")
public class Maincontroller {

	@Autowired
	MainService service;
	
	
	//category
	// create a new category
	@PostMapping("/categories")
	public String addcategories(@RequestBody Categories c) {
	String msg=	service.addcategories(c);
	return msg;
	}
	
	//GET all the categories
	@GetMapping("/getAllCategories?")
	public List<Categories>getAllcategories(@RequestParam int page){
		
		List<Categories> list= service.getAllcategories(page);
		return list;
    }
	
	// category by Id
	@GetMapping("/getparticularEmp/{id}")
	public Categories getParticularEmployeeById(@PathVariable int id) {
		
		Categories ct= service.CategoriesByID(id);
		return ct;
	}
	
	// update category
	@PutMapping("/updateCategories")
	public String updateCategories(@RequestBody Categories c) {
		
		String msg= service.updateCategories(c);
		
		return msg;
		
	}
	
	// Delete category by id
	@DeleteMapping("/deleteCategories/{id}")
	public String deleteCategories(@PathVariable int id) {
		
		String msg= service.deletCategories(id);
		return msg;
	}
	
	//Products
	
	//create a new product
	@PostMapping("/addProducts")
	public String addProducts(@RequestBody Products p) {
	String msg=	service.addProducts(p);
	return msg;
	}
	
	// all the products
	@GetMapping("/getAllProducts")
	public List<Products> getAllproducs(@RequestParam int page){
		List<Products> list= service.getAllProducts(page);
		return list;
    }
	
	//update product
	@PutMapping("/updateProducts?")
	public String updateProducts(@RequestBody Products p) {
		String msg= service.updateProducts(p);
		return msg;
	}
	
	//product by Id
	@GetMapping("/productById/{id}")
	public Products getParticularproductById(@PathVariable int id) {
		
		Products p= service.productById(id);
		return p;
		
	}

    //Delete product by id
	@DeleteMapping("/deleteProducts/{id}")
	public String deleteProducts(@PathVariable int id) {
		
		String msg= service.deletProducts(id);
		return msg;
	}
}