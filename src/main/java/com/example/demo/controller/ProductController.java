package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.ProductInterface;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	   
		 
		 
		  @RequestMapping(value = "product", method = RequestMethod.POST)
		    public String saveProduct(Product product) {
			  productService.saveProduct(product);
			  return "redirect:/product/" + product.getId();
		    }
		  
		  @RequestMapping("/product/delete/{id}")
		    public String deleteProduct(Integer id ){
			  productService.deleteProduct(id);
			  return "redirect:/products";
		    }
		  
		  @RequestMapping("/product/{id}")
		    public String showProduct(Integer id, Model model){
			  model.addAttribute("product",productService.getProductById(id));
			  return "productshow";
		    }
		  
		  @RequestMapping("/product/edit/{id}")
		    public String editProduct(Integer id, Model model){
			  model.addAttribute("product", productService.getProductById(id));
			  return "productform";
		    }
		  
		  @RequestMapping(value="products",  method = RequestMethod.GET)
		    public String showProducts(Model model){
			  model.addAttribute("products",productService.listAllProducts());
			  return "products";
		    }
		  
		    @RequestMapping("product/new")
		    public String newProduct(Model model) {
		        model.addAttribute("product", new Product());
		        return "productform";
		    }
		  
		 
		  
		 
		  
}
