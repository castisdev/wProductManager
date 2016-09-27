package com.castis.dao;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.castis.model.BasicProduct;
import com.castis.model.FavoriteProduct;
import com.castis.model.PurchaseProduct;
import com.castis.model.SaleProduct;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	@Autowired
	private MongoTemplate mongo;
	
	// BasicProduct
	public void insertBasicProduct(BasicProduct bp) throws Exception{
		mongo.insert(bp);
	}
	
	public void updateBasicProduct(BasicProduct bp) throws Exception{
		
	}
	
	public void getBasicProduct(String productId) throws Exception{
		
	}
	
	public void deleteBasicProduct(String productId) throws Exception{
		
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
