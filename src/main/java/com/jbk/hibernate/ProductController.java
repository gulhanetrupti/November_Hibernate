package com.jbk.hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.Order;

import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {
		
		char ch;
	
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductService();
		
		do {
			System.out.println("****************************Product Commands****************************************");
			System.out.println("Press 1 for Save Product");
			System.out.println("Press 2 for get Product by Id");
			System.out.println("Press 3 for delete Product by Id");
			System.out.println("Press 4 for update Product");
			System.out.println("Press 5 for get all Products");
			System.out.println("Press 6 for get all Products Sort by Name ASC");
			System.out.println("Press 7 for get all Products Sort by Name DESC");
			System.out.println("Press 8 for get max first Product");
			System.out.println("Press 9 for get Product by name");
			System.out.println("Press 10 for get Product start with any character or letter" );
			System.out.println("Press 11 for get Product ends with any character or letter" );
			System.out.println("Press 12 for get Product containing any character or letter" );
			System.out.println("Press 13 for get Product based on product Price(Greater than)" );
			System.out.println("Press 14 for get Product based on product quantity(less than)" );
			System.out.println("Press 15 for get between Product based on product Price" );
			System.out.println("Press 16 for get Product name by size" );
			
			
			int choice = scanner.nextInt();
			
			switch (choice) {
   case 1:
			{
				
				Product product = ProductUtility.prepareProductdata(scanner);
				boolean isadded = productService.saveProduct(product);
				if (isadded) {
					System.out.println("Saved....!!!!!!!!!!!");
				}else {
					System.out.println("Product already exists with id...." +product.getProductId());
				}
				
				break;
			}
				
   case 2:
			{
				
				System.out.println("Enter product Id");
				long productId = scanner.nextLong();
				Product product = productService.getProductById(productId);
				if (product !=null) {
					
					System.out.println(product);
				}else {
					System.out.println("Product not exists with id = " +productId);
				}
				
				break;
			}
			
	case 3:
			{
				System.out.println(" Enter product Id");
				long productId = scanner.nextLong();
				boolean isDeleted = productService.deleteProductById(productId);
				if (isDeleted) {
					
					System.out.println("Product is deleted");
				}else {
					
					System.out.println("Product not exists with id = " +productId);
				 }
				
				break;
				
			}
			
			
	case 4:
			{
				Product product = ProductUtility.prepareProductdata(scanner);
				boolean isUpdated = productService.updateProduct(product);
				
				if (isUpdated) {
					
					System.out.println("Data Updated Successfully.............!!!!!!!!!!!!!");
					
				}else {
					
					System.out.println("Product not exists with id= " +product.getProductId());
				}
				
				break;
			}
			
	case 5:
		  
	 		{
	 			List<Product> allProduct = productService.getAllProduct();
	 			
	 			if (allProduct.isEmpty() || allProduct == null) {
	 				
	 				System.out.println("Product not exists..... ");
					
				}else {
					
					for (Product product : allProduct) {
						
						System.out.println(product);
						
					}
				}
	 			
	 			break;
	 		}
	 		
	case 6:
		  
		{
			List<Product> allProduct = productService.getAllProductSortASCByName();
			
			if (allProduct.isEmpty() || allProduct == null) {
				
				System.out.println("Product not exists..... ");
			
		}else {
			
			for (Product product : allProduct) {
				
				System.out.println(product);
				
			}
		}
			
			break;
		}
		
		
	case 7:
		  
	{
		List<Product> allProduct = productService.getAllProductSortDESCByName();
		
		if (allProduct.isEmpty() || allProduct == null) {
			
			System.out.println("Product not exists..... ");
		
	}else {
		
		for (Product product : allProduct) {
			
			System.out.println(product);
			
		}
	}
		
		break;
	}
	
	
	case 8:
		
	{
		List<Product> maxFirstProduct = productService.getMaxFirstProduct();
		
		if (maxFirstProduct.isEmpty() || maxFirstProduct == null) {
			
			System.out.println("Product not exists..... ");
			
		}else {
			
			for (Product product : maxFirstProduct) {
				
				System.out.println(product);
			}
		}
		
		break;
	}
	
	
  case 9:
		
	{
		List<Product> product = productService.getProductByName();
		
		if (product.isEmpty() || product == null) {
			
			System.out.println("Product not exists..... ");
			
		}else {
			
			for (Product productlist : product) {
				
				System.out.println(productlist);
			}
		}
		
		break;
	}
	
   case 10:
	  
     {    
    
	   List<Product> product = productService.getProductStartWithCharacterORLetter();
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
   }
     
   case 11:
		  
   {    
  	
	   List<Product> product = productService.getProductEndsWithCharacterORLetter();
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
 }
   
   
   case 12:
		  
   {    
  	       System.out.println("Enter for search");
  	      String exp = scanner.next();
	   List<Product> product = productService.getProductContainCharacterORLetter(exp);
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
 }
   
   
   case 13:
		  
   {    
  	       System.out.println("Enter product price");
  	       
  	      double num = scanner.nextDouble();
  	      
	   List<Product> product = productService.getGreaterProductByProductPrice(num);
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
   }
   
   
   case 14:
		  
   {    
  	      System.out.println("Enter product Quanity");
  	       
  	     int quantity = scanner.nextInt();
  	      
	   List<Product> product = productService.getLessProductByProductQTY(quantity);
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
   }
   
   
   case 15:
		  
   {    
  	       System.out.println("Enter low product price");
  	       System.out.println("Enter high product price");
  	       
  	      double lowPrice = scanner.nextDouble();
  	      double highPrice = scanner.nextDouble();
  	      
	   List<Product> product = productService.getBetweenProductByProductPrice(lowPrice,highPrice);
	   
	   if(product.isEmpty() || product == null) {
		   
		   System.out.println("Product not exists..... ");
		
	    }else {
	    	
	    	for (Product productlist : product) {
	    		
	    		System.out.println(productlist);
				
			}
	    }
	   break;
   }
   
   
   case 16:
		  
	{
		System.out.println("Enter size");
		int size = scanner.nextInt();
		List<Product> productName = productService.getProductNameBySize(size);
		
	if (productName == null) {
		
		System.out.println("Product not exists..... ");
	}else {
		
		System.out.println("Product Name is = " +productName);
	}
		
		break;
	}
			
			default:
				break;
			}
			
			System.out.println("Do you wnat to continue y/n");
			 ch = scanner.next().charAt(0);
			
		} while (ch == 'y' || ch == 'Y');
		
		System.out.println("Code terminated");
	}

}
