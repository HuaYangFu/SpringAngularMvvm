 package com.restful.dao;

 import org.hibernate.HibernateException;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.SessionFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restful.entity.User;

import java.util.List;

 @Repository
 public class UserDAO{

     @Autowired
     private SessionFactory sessionFactory;

     @Transactional
     public List<User> getAllUsers() {
         Session ses = sessionFactory.getCurrentSession();
         Query query = ses.createQuery(" from "+User.class.getName()+"");
         return query.list();
     }
	
     @Transactional
     public User getUser(long id) {
    	 Session ses = sessionFactory.getCurrentSession();
    	 String hql = " from " +User.class.getName()+ " where id = :id";
         Query query = ses.createQuery(hql);
         query.setLong("id", id);
         User user = null;
         if(query.list().size() != 0) {
        	 user = (User) query.list().get(0);
         }
    	 return user;
     }
     
     @Transactional
     public void savelUser(User user) {
         Session ses = sessionFactory.getCurrentSession();
         ses.save(user);
     }
     
     @Transactional
     public void updateUser(User user) {
         Session ses = sessionFactory.getCurrentSession();
         ses.update(user);
     }
     
     @Transactional
     public void deleteUser(User user) {
    	 System.out.println(user.getAddress());
    	 System.out.println(user.getEmail());
    	 System.out.println(user.getId());
         Session ses = sessionFactory.getCurrentSession();
         ses.delete(user);
     }
 }