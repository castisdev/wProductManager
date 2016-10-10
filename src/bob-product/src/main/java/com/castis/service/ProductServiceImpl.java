package com.castis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castis.dao.IProductDao;
import com.castis.model.BasicProduct;
import com.castis.model.FavoriteProduct;
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
	
	// PurchaseProduct
	public void insertPurchaseProduct(PurchaseProduct pp) throws Exception{
		productDao.insertPurchaseProduct(pp);
	}
	
	public void updatePurchaseProduct(PurchaseProduct pp) throws Exception{
		productDao.updatePurchaseProduct(pp);
	}
	
	public PurchaseProduct getPurchaseProduct(String purchaseId) throws Exception{
		return productDao.getPurchaseProduct(purchaseId);
	}
	
	public void deletePurchaseProduct(PurchaseProduct pp) throws Exception{
		productDao.deletePurchaseProduct(pp);
	}

	// SaleProduct
	public void insertSaleProduct(SaleProduct sp) throws Exception{
		productDao.insertSaleProduct(sp);
	}
	
	public void updateSaleProduct(SaleProduct sp) throws Exception{
		productDao.updateSaleProduct(sp);
	}
	
	public SaleProduct getSaleProduct(String saleId) throws Exception{
		return productDao.getSaleProduct(saleId);
	}
	
	public void deleteSaleProduct(SaleProduct sp) throws Exception{
		productDao.deleteSaleProduct(sp);
	}

	// FavoriteProduct
	public void insertFavoriteProduct(FavoriteProduct fp) throws Exception{
		productDao.insertFavoriteProduct(fp);
	}
	
	public void updateFavoriteProduct(FavoriteProduct fp) throws Exception{
		productDao.updateFavoriteProduct(fp);
	}
	
	public FavoriteProduct getFavoriteProduct(String favoriteId) throws Exception{
		return productDao.getFavoriteProduct(favoriteId);
	}
	
	public void deleteFavoriteProduct(FavoriteProduct fp) throws Exception{
		productDao.deleteFavoriteProduct(fp);
	}
}
