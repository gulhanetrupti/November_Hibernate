package com.jbk.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.hibernate.entity.Product;

public class HibernateConfiguration {
	
	public static SessionFactory getSessionFactoryObject() {
		
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
		
	}

}
