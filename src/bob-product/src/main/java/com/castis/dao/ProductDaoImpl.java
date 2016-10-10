package com.castis.dao;

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
		mongo.save(bp);
	}
	
	public BasicProduct getBasicProduct(String productId) throws Exception{
		return mongo.findById(productId, BasicProduct.class);
	}
	
	public void deleteBasicProduct(BasicProduct bp) throws Exception{
		mongo.remove(bp);
	}
	
	// PurchaseProduct
	public void insertPurchaseProduct(PurchaseProduct pp) throws Exception{
		mongo.insert(pp);
	}
	
	public void updatePurchaseProduct(PurchaseProduct pp) throws Exception{
		mongo.save(pp);
	}
	
	public PurchaseProduct getPurchaseProduct(String purchaseId) throws Exception{
		return mongo.findById(purchaseId, PurchaseProduct.class);
	}
	
	public void deletePurchaseProduct(PurchaseProduct pp) throws Exception{
		mongo.remove(pp);
	}

	// SaleProduct
	public void insertSaleProduct(SaleProduct sp) throws Exception{
		mongo.insert(sp);
	}
	
	public void updateSaleProduct(SaleProduct sp) throws Exception{
		mongo.save(sp);
	}
	
	public SaleProduct getSaleProduct(String saleId) throws Exception{
		return mongo.findById(saleId, SaleProduct.class);
	}
	
	public void deleteSaleProduct(SaleProduct sp) throws Exception{
		mongo.remove(sp);
	}

	// FavoriteProduct
	public void insertFavoriteProduct(FavoriteProduct fp) throws Exception{
		mongo.insert(fp);
	}
	
	public void updateFavoriteProduct(FavoriteProduct fp) throws Exception{
		mongo.save(fp);
	}
	
	public FavoriteProduct getFavoriteProduct(String favoriteId) throws Exception{
		return mongo.findById(favoriteId, FavoriteProduct.class);
	}
	
	public void deleteFavoriteProduct(FavoriteProduct fp) throws Exception{
		mongo.remove(fp);
	}
}
