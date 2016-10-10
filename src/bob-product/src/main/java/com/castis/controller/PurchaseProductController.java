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

import com.castis.model.PurchaseProduct;
import com.castis.model.Purchase;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/purchase")
public class PurchaseProductController {

	@Autowired
	public IProductService ps;
	
	// Create PurchaseProduct
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Purchase purchase, UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
		
		try{
			for(PurchaseProduct pp : purchase.getPurchases())
				ps.insertPurchaseProduct(pp);
		} catch(Exception e){
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Get PurchaseProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PurchaseProduct> getProduct(@PathVariable("id") String id){
		
		PurchaseProduct pp = null;
		try{
			pp = ps.getPurchaseProduct(id);
		} catch(Exception e){
			return new ResponseEntity<PurchaseProduct>(pp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PurchaseProduct>(pp, HttpStatus.OK);
	}
	
	//Update PurchaseProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<PurchaseProduct> updateProduct(@PathVariable("id") String id, 
														@RequestBody PurchaseProduct pp){
		PurchaseProduct existsPP = null;
		try {
			existsPP = ps.getPurchaseProduct(id);
			
			if(existsPP == null){
				return new ResponseEntity<PurchaseProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<PurchaseProduct>(HttpStatus.CONFLICT);
		}
		
		PurchaseProduct.copyPurchaseProduct(pp, existsPP);
			
		try{
			ps.updatePurchaseProduct(existsPP);
		} catch(Exception e){
			return new ResponseEntity<PurchaseProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<PurchaseProduct>(existsPP, HttpStatus.OK);
	}
	
	//Update PurchaseProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<PurchaseProduct> deleteProduct(@PathVariable("id") String id){
		PurchaseProduct existsPP = null;
		try {
			existsPP = ps.getPurchaseProduct(id);
			
			if(existsPP == null){
				return new ResponseEntity<PurchaseProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<PurchaseProduct>(HttpStatus.CONFLICT);
		}
			
		try{
			ps.deletePurchaseProduct(existsPP);
		} catch(Exception e){
			return new ResponseEntity<PurchaseProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<PurchaseProduct>(HttpStatus.NO_CONTENT);
	}
}
