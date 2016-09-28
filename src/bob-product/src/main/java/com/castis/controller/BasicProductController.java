package com.castis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.castis.model.BasicProduct;
import com.castis.model.Product;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/product")
public class BasicProductController {


	@Autowired
	public IProductService ps;
	
	// Create BasicProduct
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody BasicProduct[] bpList, UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
	//	headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(bp.getId()).toUri());
		
		try{
			for(BasicProduct bp : bpList)
				ps.insertBasicProduct(bp);
		} catch(Exception e){
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	// Get BasicProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicProduct> getProduct(@PathVariable("id") String id){
		
		BasicProduct bp = null;
		try{
			bp = ps.getBasicProduct(id);
		} catch(Exception e){
			return new ResponseEntity<BasicProduct>(bp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BasicProduct>(bp, HttpStatus.OK);
	}
	
	//Update BasicProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<BasicProduct> updateProduct(@PathVariable("id") String id, 
														@RequestBody BasicProduct bp){
		BasicProduct existsBP = null;
		try {
			existsBP = ps.getBasicProduct(id);
			
			if(existsBP == null){
				return new ResponseEntity<BasicProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<BasicProduct>(HttpStatus.CONFLICT);
		}
		
		existsBP.setName(bp.getName());
		existsBP.setDescription(bp.getDescription());
			
		try{
			ps.updateBasicProduct(existsBP);
		} catch(Exception e){
			return new ResponseEntity<BasicProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<BasicProduct>(existsBP, HttpStatus.OK);
	}
	
	//Update BasicProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<BasicProduct> deleteProduct(@PathVariable("id") String id){
		BasicProduct existsBP = null;
		try {
			existsBP = ps.getBasicProduct(id);
			
			if(existsBP == null){
				return new ResponseEntity<BasicProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<BasicProduct>(HttpStatus.CONFLICT);
		}
			
		try{
			ps.deleteBasicProduct(existsBP);
		} catch(Exception e){
			return new ResponseEntity<BasicProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<BasicProduct>(HttpStatus.NO_CONTENT);
	}
}
