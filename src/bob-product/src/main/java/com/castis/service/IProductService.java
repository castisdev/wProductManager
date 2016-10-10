package com.castis.service;

import com.castis.model.BasicProduct;
import com.castis.model.FavoriteProduct;
import com.castis.model.PurchaseProduct;
import com.castis.model.SaleProduct;

public interface IProductService {

	// BasicProduct
	public void insertBasicProduct(BasicProduct bp) throws Exception;
	
	public void updateBasicProduct(BasicProduct bp) throws Exception;
	
	public BasicProduct getBasicProduct(String productId) throws Exception;
	
	public void deleteBasicProduct(BasicProduct bp) throws Exception;
	
	// PurchaseProduct
	public void insertPurchaseProduct(PurchaseProduct pp) throws Exception;
	
	public void updatePurchaseProduct(PurchaseProduct pp) throws Exception;
	
	public PurchaseProduct getPurchaseProduct(String purchaseId) throws Exception;
	
	public void deletePurchaseProduct(PurchaseProduct pp) throws Exception;

	// SaleProduct
	public void insertSaleProduct(SaleProduct sp) throws Exception;
	
	public void updateSaleProduct(SaleProduct sp) throws Exception;
	
	public SaleProduct getSaleProduct(String saleId) throws Exception;
	
	public void deleteSaleProduct(SaleProduct sp) throws Exception;

	// FavoriteProduct
	public void insertFavoriteProduct(FavoriteProduct fp) throws Exception;
	
	public void updateFavoriteProduct(FavoriteProduct fp) throws Exception;
	
	public FavoriteProduct getFavoriteProduct(String favoriteId) throws Exception;
	
	public void deleteFavoriteProduct(FavoriteProduct fp) throws Exception;

}
