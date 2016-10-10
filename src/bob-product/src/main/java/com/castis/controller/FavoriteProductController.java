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

import com.castis.model.Favorite;
import com.castis.model.Sale;
import com.castis.model.FavoriteProduct;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/favorite")
public class FavoriteProductController {

	@Autowired
	public IProductService ps;
	
	// Create FavoriteProduct
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Favorite favorite, UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
		
		try{
			for(FavoriteProduct fp : favorite.getFavorites())
				ps.insertFavoriteProduct(fp);
		} catch(Exception e){
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Get FavoriteProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FavoriteProduct> getProduct(@PathVariable("id") String id){
		
		FavoriteProduct fp = null;
		try{
			fp = ps.getFavoriteProduct(id);
		} catch(Exception e){
			return new ResponseEntity<FavoriteProduct>(fp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<FavoriteProduct>(fp, HttpStatus.OK);
	}
	
	//Update FavoriteProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<FavoriteProduct> updateProduct(@PathVariable("id") String id, 
														@RequestBody FavoriteProduct fp){
		FavoriteProduct existsFP = null;
		try {
			existsFP = ps.getFavoriteProduct(id);
			
			if(existsFP == null){
				return new ResponseEntity<FavoriteProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<FavoriteProduct>(HttpStatus.CONFLICT);
		}
		
		FavoriteProduct.copyFavoriteProduct(fp, existsFP);
			
		try{
			ps.updateFavoriteProduct(existsFP);
		} catch(Exception e){
			return new ResponseEntity<FavoriteProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<FavoriteProduct>(existsFP, HttpStatus.OK);
	}
	
	//Update FavoriteProduct
	@RequestMapping(value="/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<FavoriteProduct> deleteProduct(@PathVariable("id") String id){
		FavoriteProduct existsFP = null;
		try {
			existsFP = ps.getFavoriteProduct(id);
			
			if(existsFP == null){
				return new ResponseEntity<FavoriteProduct>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<FavoriteProduct>(HttpStatus.CONFLICT);
		}
			
		try{
			ps.deleteFavoriteProduct(existsFP);
		} catch(Exception e){
			return new ResponseEntity<FavoriteProduct>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<FavoriteProduct>(HttpStatus.NO_CONTENT);
	}
}
