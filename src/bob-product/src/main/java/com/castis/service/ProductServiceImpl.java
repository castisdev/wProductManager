package com.castis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.castis.dao.IProductDao;
import com.castis.model.BasicProduct;
import com.castis.model.FavoriteProduct;
import com.castis.model.Product;
import com.castis.model.PurchaseProduct;
import com.castis.model.SaleProduct;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	public IProductDao productDao;
	
	// BasicProduct
	public void insertBasicProduct(BasicProduct bp) throws Exception{
		productDao.insertBasicProduct(bp);
	}
	
	public void updateBasicProduct(BasicProduct bp) throws Exception{
		productDao.updateBasicProduct(bp);
	}
	
	public BasicProduct getBasicProduct(String productId) throws Exception{
		return productDao.getBasicProduct(productId);
	}
	
	public void deleteBasicProduct(BasicProduct bp) throws Exception{
		productDao.deleteBasicProduct(bp);
	}
	
	// PurcaseProduct
	public void insertPurchaseProduct(PurchaseProduct pp) throws Exception{
		
	}
	
	public void updatePurchaseProduct(PurchaseProduct pp) throws Exception{
		
	}
	
	public void getPurchaseProduct(String purchaseId) throws Exception{
	
	}
	
	public void deletePurchaseProduct(String purchaseId) throws Exception{
		
	}

	// SaleProduct
	public void insertSaleProduct(SaleProduct sp) throws Exception{
		
	}
	
	public void updateSaleProduct(SaleProduct sp) throws Exception{
		
	}
	
	public void getSaleProduct(String saleId) throws Exception{
		
	}
	
	public void deleteSaleProduct(String saleId) throws Exception{
		
	}

	// FavoriteProduct
	public void insertFavoriteProduct(FavoriteProduct fp) throws Exception{
		
	}
	
	public void updateFavoriteProduct(FavoriteProduct fp) throws Exception{
		
	}
	
	public void getFavoriteProduct(String favoriteId) throws Exception{
		
	}
	
	public void deleteFavoriteProduct(String favoriteId) throws Exception{
		
	}
}
