package com.ProductPract.ProductPract.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductPract.ProductPract.model.ProdDto;
import com.ProductPract.ProductPract.model.Product;
import com.ProductPract.ProductPract.service.ProdService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProdController {
	@Autowired
	private ProdService service;
	@GetMapping
public List<Product> getll(){
	return service.getall();
}
//
	@GetMapping("{id}")
	public ResponseEntity<Product> getbyid(@PathVariable int id){
		return ResponseEntity.ok(service.getbyid(id));
	}
	
	@PostMapping
	public ResponseEntity<Product> add(
	        @Valid @RequestBody ProdDto product) {

	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(service.addProduct(product));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<String> update(@PathVariable int id,@Valid @RequestBody Product pro){
		Product p=service.updtProduct(id, pro);
		return  ResponseEntity.ok("Updated");
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> del(@PathVariable int id){
		service.delte(id);
		
		return ResponseEntity.ok("deleeted");
		
	}
}
