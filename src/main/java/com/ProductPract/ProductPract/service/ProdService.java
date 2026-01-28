package com.ProductPract.ProductPract.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductPract.ProductPract.exception.ProdNotFound;
import com.ProductPract.ProductPract.model.ProdDto;
import com.ProductPract.ProductPract.model.Product;
import com.ProductPract.ProductPract.repo.ProdRepo;
@Service
public class ProdService {
   @Autowired
   private ProdRepo repo;
   
   public Product addProduct(ProdDto dto) {
	   Product product=new Product();
	 
	   product.setName(dto.getName());
	   product.setPrice(dto.getPrice());
	   
	   return repo.save(product);
	   
   }
   
   public List<Product> getall(){
	   return repo.findAll();
   }

   public Product getbyid(int id) {
	   return repo.findById(id).orElseThrow(()->new ProdNotFound("product with id not found"));
   }
   
   public Product updtProduct(int id,Product product) {
	   
	   Product p=repo.findById(id).orElseThrow(()->new ProdNotFound("prod not found"));
	   
	  
		 
		   p.setName(product.getName());
		   p.setPrice(product.getPrice());
		   
		  return repo.save(p);
	   
	  
	   
   }

   public void delte(int id) {
	   Product product=repo.findById(id).orElseThrow(()->new ProdNotFound("prod id nt found"));
	   if(product!=null) {
	   repo.deleteById(id);
	   }
   }
}
