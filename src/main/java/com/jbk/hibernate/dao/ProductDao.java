package com.jbk.hibernate.dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfiguration;
import com.jbk.hibernate.entity.Product;

public class ProductDao {
	
	private SessionFactory sessionFactory = HibernateConfiguration.getSessionFactoryObject();
	
	public boolean saveProduct(Product product) {
		
	    Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		
		return true;
		
	}
	
//***********************************************************************************//
	public Product getProdutById(long productId) {
		
		Session session = sessionFactory.openSession();
		
		Product product=null;
		
		try {
			product = session.get(Product.class, productId);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return product;
		
	}
	
	
//*************************************************************************************//
	
	public boolean deleteProductById(long productId) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		
		try {
		
			Product dbProduct = getProdutById(productId);
			
		   if (dbProduct != null) {
			
			session.delete(dbProduct);
			transaction.commit();
			isDeleted = true;
			
		    }
			
		} catch (Exception e) {
			
			e.getStackTrace();
			
		}finally {
			session.close();
		}
		return false;
		
	}
	
//*******************************************************************************//

	public boolean updateProduct(Product product) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;

		
		try {
				Product dbproduct = getProdutById(product.getProductId());
			
			if (dbproduct != null) {
				
				session.update(product);
				transaction.commit();
				isUpdated = true;
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		
		return isUpdated;
	}
	
//*********************************************************************************************//
	

	/*public List<Order> getAllProduct() {
		
		Session session = sessionFactory.openSession();
		List<Order> orderList=null;

		   try {
			
			  // Criteria createCriteria = session.createCriteria(Product.class);  //deprecated method
			  // List<Product> list = createCriteria.list();
			   
			// Create CriteriaBuilder(search on google create criteria alternative-new method from below)
			   CriteriaBuilder builder = session.getCriteriaBuilder();

			   // Create CriteriaQuery
			   CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
			   
			     orderList = criteria.getOrderList();
			   
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
      
		return orderList;
	}
	
}*/
	
//*********************************************************************************************//
	
public List<Product> getAllProduct() {
		
		Session session = sessionFactory.openSession();
		List<Product> list=null;

		   try {
			
			   Criteria createCriteria = session.createCriteria(Product.class);  //deprecated method
			       list = createCriteria.list();
			   
			   
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
      
		return list;
	}

//**********************************************************************************//

   public List<Product> getAllProductSortASCByName() {
	   
	Session session = sessionFactory.openSession();
	List<Product> list=null;

	   try {
		
		   Criteria createCriteria = session.createCriteria(Product.class);  //deprecated method
		   createCriteria.addOrder(Order.asc("productName"));
		     list = createCriteria.list();	   
		   
		   
	   } catch (Exception e) {
		
		e.printStackTrace();
		
	      }finally {
		
		session.close();
	        }
  
	return list;
      }
   
 //********************************************************************************************//
   
   public List<Product> getAllProductSortDESCByName() {
	   
		Session session = sessionFactory.openSession();
		List<Product> list=null;

		   try {
			
			   Criteria criteria = session.createCriteria(Product.class);  //deprecated method
			   criteria.setFirstResult(1); //start from second no. product after ascending order
			   criteria.setMaxResults(3); //max 3 first 3 result only
			   criteria.addOrder(Order.desc("productName"));
			     list = criteria.list();	   
			   
			   
		   } catch (Exception e) {
			
			e.printStackTrace();
			
		      }finally {
			
			session.close();
		        }
	  
		return list;
	      }
   
//************************************************************************************************//

    public List<Product> getMaxFirstProduct() {
    	
    	Session session = sessionFactory.openSession();
    	List<Product> list = null;
    	
    	try {
    		
    		Criteria criteria = session.createCriteria("Product.class");
    		criteria.setMaxResults(3);
    		criteria.addOrder(Order.desc("productName"));
    		 list = criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			session.close();
		}
	
	return list;
     }
    
//*****************************************************************************************//

	public List<Product> getProductByName() {
		
		Session session = sessionFactory.openSession();
		List<Product> list=null;

		   try {
			
			   Criteria criteria = session.createCriteria(Product.class);  //deprecated method
			   criteria.add(Restrictions.gt("productPrice", 100.0)); // or 100d/D
			     list = criteria.list();	   
			   
			   
		   } catch (Exception e) {
			
			e.printStackTrace();
			
		      }finally {
			
			session.close();
		        }
	  
		return list;
	      }
	
//*******************************************************************************************//

	public List<Product> getProductStartWithCharacterORLetter() {
		
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "p%"));
			   list = criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		return list;
		
	}
	
//*****************************************************************************************//

	public List<Product> getProductEndsWithCharacterORLetter() {
		
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%n"));
			   list = criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		return list;
	}
	
//*********************************************************************************//

	public List<Product> getProductContainCharacterORLetter(String exp) {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%"+exp+"%"));
			   list = criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		return list;
	}
	
//************************************************************************************//

	public List<Product> getGreaterProductByProductPrice(double num) {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.ge("productPrice", num));
			//criteria.add(Restrictions.gt("productPrice", num));
			   list = criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		return list;
	}

//***************************************************************************************//
	
	public List<Product> getLessProductByProductQTY(int quantity) {
		
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.lt("productQTY", quantity));
			//criteria.add(Restrictions.le("productQTY", quantity));
			   list = criteria.list();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		 }finally {
			
			session.close();
		  }
		
		return list;
 
	}
	
//*********************************************************************************************//

	public List<Product> getBetweenProductByProductPrice(double lowPrice, double highPrice) {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			
			criteria.add(Restrictions.between("productPrice", lowPrice, highPrice));
			
			   list = criteria.list();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		 }finally {
			
			session.close();
		  }
		
		return list;
	}

	
//*************************************************************************************//

	public List<Product> getProductNameBySize(int size) {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			
			Criteria criteria = session.createCriteria(Product.class);
			
			criteria.add(Restrictions.sizeEq("productName", size));
			
			 list = criteria.list();
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

}
		
  
