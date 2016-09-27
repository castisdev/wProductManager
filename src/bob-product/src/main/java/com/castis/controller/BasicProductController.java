package com.castis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castis.model.BasicProduct;
import com.castis.service.IProductService;


@RestController
@RequestMapping(value="/v1/products/product")
public class BasicProductController {


	@Autowired
	public IProductService ps;
	
	@RequestMapping
	public String saveProduct(Model model){
		BasicProduct bp = new BasicProduct();
		bp.setId("unique1");
		bp.setName("test1");
		bp.setDescription("첫 테스트");
		
		try{
			ps.insertBasicProduct(bp);
		} catch(Exception e){
			return "fail" + "-" + e.toString();
		}
		return "success";
	}
}
