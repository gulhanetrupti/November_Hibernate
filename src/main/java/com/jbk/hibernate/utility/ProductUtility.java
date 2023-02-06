package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility {
	
	public static Product prepareProductdata(Scanner scanner) {
		
		System.out.println("Enter Product Id");
		long productId = scanner.nextLong();
		
		System.out.println("Enter Product Name");
		String productName =scanner.next();
		
		System.out.println("Enter Supplier Id");
		long supplierId =scanner.nextLong();
		
		System.out.println("Enter Category Id");
		long categoryId =scanner.nextLong();
		
		System.out.println("Enter Product Quantity");
		int productQTY =scanner.nextInt();
		
		System.out.println("Enter Product Price");
		double productPrice =scanner.nextDouble();
		
		Product product = new Product(productId, productName, supplierId, categoryId, productQTY, productPrice);
		
		return product;
		
	}

}
