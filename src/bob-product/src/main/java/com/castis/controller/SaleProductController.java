package com.castis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.castis.model.SaleProduct;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/sale")
public class SaleProductController {

	@Autowired
	public IProductService ps;
	
	// Create SaleProduct
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody SaleProduct sp, UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
		
		try{
			ps.insertSaleProduct(sp);
		} catch(Exception e){
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
