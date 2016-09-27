package com.castis.service;

import com.castis.model.BasicProduct;
import com.castis.model.FavoriteProduct;
import com.castis.model.PurchaseProduct;
import com.castis.model.SaleProduct;

public interface IProductService {

	// BasicProduct
	public void insertBasicProduct(BasicProduct bp) throws Exception;
	
	public void updateBasicProduct(BasicProduct bp) throws Exception;
	
	public void getBasicProduct(String productId) throws Exception;
	
	public void deleteBasicProduct(String productId) throws Exception;
	
	// PurcaseProduct
	public void insertPurchaseProduct(PurchaseProduct pp) throws Exception;
	
	public void updatePurchaseProduct(PurchaseProduct pp) throws Exception;
	
	public void getPurchaseProduct(String purchaseId) throws Exception;
	
	public void deletePurchaseProduct(String purchaseId) throws Exception;

	// SaleProduct
	public void insertSaleProduct(SaleProduct sp) throws Exception;
	
	public void updateSaleProduct(SaleProduct sp) throws Exception;
	
	public void getSaleProduct(String saleId) throws Exception;
	
	public void deleteSaleProduct(String saleId) throws Exception;

	// FavoriteProduct
	public void insertFavoriteProduct(FavoriteProduct fp) throws Exception;
	
	public void updateFavoriteProduct(FavoriteProduct fp) throws Exception;
	
	public void getFavoriteProduct(String favoriteId) throws Exception;
	
	public void deleteFavoriteProduct(String favoriteId) throws Exception;

}
