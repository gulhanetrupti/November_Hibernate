package com.jbk.hibernate.service;

import java.util.List;

import javax.persistence.criteria.Order;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {
	
	ProductDao productDao = new ProductDao();
	
	public boolean saveProduct(Product product) {
		
		return productDao.saveProduct(product);
	}
	
//**********************************************************************************************//
	public Product getProductById(long productId) {
		
		return productDao.
				getProdutById(productId);
		
	}
	
//**********************************************************************************************//
	
	public boolean deleteProductById(long productId) {
		
		boolean isDeleted = productDao.deleteProductById(productId);
		return isDeleted;
	}

//**********************************************************************************************//

	public boolean updateProduct(Product product) {
		
		boolean isUpdated = productDao.updateProduct(product);
		return isUpdated;
	}
	
//**********************************************************************************************//
	
	public List<Product> getAllProduct() {
		
		  return productDao.getAllProduct();
		
	}
	
//**********************************************************************************************//

	public List<Product> getAllProductSortASCByName() {
		
		List<Product> allProduct = productDao.getAllProductSortASCByName();
		
		return allProduct;
	}
	
//**********************************************************************************************//
	
    public List<Product> getAllProductSortDESCByName() {
		
		List<Product> allProduct = productDao.getAllProductSortDESCByName();
		
		return allProduct;
	}
    
//**********************************************************************************************//

	public List<Product> getMaxFirstProduct() {
		
		List<Product> maxFirstProduct = productDao.getMaxFirstProduct();
		
		return maxFirstProduct;
	}

//**********************************************************************************************//
	public List<Product> getProductByName() {
		
		List<Product> product = productDao.getProductByName();
		
		return product;
	}

//**********************************************************************************************//
	
	public List<Product> getProductStartWithCharacterORLetter() {
		
		List<Product> product = productDao.getProductStartWithCharacterORLetter();
		
		return product;
	}
	
//**********************************************************************************************//
	public List<Product> getProductEndsWithCharacterORLetter() {
		
		List<Product> product = productDao.getProductEndsWithCharacterORLetter();
		
		return product;
	}
	
//**********************************************************************************************//	

	public List<Product> getProductContainCharacterORLetter(String exp) {
		
		List<Product> product = productDao.getProductContainCharacterORLetter(exp);
		
		return product;
	}
	
//**********************************************************************************************//	

	public List<Product> getGreaterProductByProductPrice(double num) {
		
		List<Product> product = productDao.getGreaterProductByProductPrice(num);
		
		return product;
	}
	
//**********************************************************************************************//
	
	public List<Product> getLessProductByProductQTY(int quantity) {
		
		List<Product> product = productDao.getLessProductByProductQTY(quantity);
		
		return product;
	}

	

	public List<Product> getBetweenProductByProductPrice(double lowPrice, double highPrice) {
		
		   List<Product> product = productDao.getBetweenProductByProductPrice(lowPrice,highPrice);
		   
		return product;
	}

//**************************************************************************************************//

	public List<Product> getProductNameBySize(int size) {
		
		List<Product> productName = productDao.getProductNameBySize(size);

		 return productName;
		
		
	}
	
	
	
	
}
	

	

	

