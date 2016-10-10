package com.castis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.castis.model.Purchase;
import com.castis.model.SaleProduct;
import com.castis.model.Sale;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/sale")
public class SaleProductController {

	@Autowired
	public IProductService ps;
	
	// Create SaleProduct
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Sale sale, UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
		
		try{
			for(SaleProduct sp : sale.getSales())
				ps.insertSaleProduct(sp);
		} catch(Exception e){
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Get SaleProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SaleProduct> getProduct(@PathVariable("id") String id){
		
		SaleProduct pp = null;
		try{
			pp = ps.getSaleProduct(id);
		} catch(Exception e){
			return new ResponseEntity<SaleProduct>(pp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SaleProduct>(pp, HttpStatus.OK);
	}
	
	//Update SaleProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<SaleProduct> updateProduct(@PathVariable("id") String id, 
														@RequestBody SaleProduct sp){
		SaleProduct existsSP = null;
		try {
			existsSP = ps.getSaleProduct(id);
			
			if(existsSP == null){
				return new ResponseEntity<SaleProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<SaleProduct>(HttpStatus.CONFLICT);
		}
		
		SaleProduct.copySaleProduct(sp, existsSP);
			
		try{
			ps.updateSaleProduct(existsSP);
		} catch(Exception e){
			return new ResponseEntity<SaleProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<SaleProduct>(existsSP, HttpStatus.OK);
	}
	
	//Update SaleProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<SaleProduct> deleteProduct(@PathVariable("id") String id){
		SaleProduct existsSP = null;
		try {
			existsSP = ps.getSaleProduct(id);
			
			if(existsSP == null){
				return new ResponseEntity<SaleProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<SaleProduct>(HttpStatus.CONFLICT);
		}
			
		try{
			ps.deleteSaleProduct(existsSP);
		} catch(Exception e){
			return new ResponseEntity<SaleProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<SaleProduct>(HttpStatus.NO_CONTENT);
	}
}
