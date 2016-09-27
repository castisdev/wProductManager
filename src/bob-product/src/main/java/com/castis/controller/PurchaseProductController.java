package com.castis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/purchase")
public class PurchaseProductController {

	@Autowired
	public IProductService ps;
	
	@RequestMapping
	public String saveProduct(Model model){
		return "purchase";
	}
}
