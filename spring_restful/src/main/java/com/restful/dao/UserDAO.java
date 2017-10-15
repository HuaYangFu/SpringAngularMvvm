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

 /**
  * @author Lexel PRO
  * @version 1.0
  */

 @Repository
 public class UserDAO implements DaoBasic{

     @Autowired
     private SessionFactory sessionFactory;

     @Transactional
     public List<User> getAllUsers() {
             Session ses = sessionFactory.openSession();
             Query query = ses.createQuery(" from "+User.class.getName()+"");
             return query.list();
     }

	@Override
	public <T> List<T> find_multi(List<T> any) {
		Session ses = sessionFactory.openSession();
        Query query = ses.createQuery(" from "+User.class.getName()+"");
        return query.list();
	}

	@Override
	public <T> T find_single(T any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> create_multi(List<T> any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T create_single(T any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> delete_multi(List<T> any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T delete_single(T any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> update_multi(List<T> any) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T update_single(T any) {
		// TODO Auto-generated method stub
		return null;
	}
 }