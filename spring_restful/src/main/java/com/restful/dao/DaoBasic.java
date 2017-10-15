package com.restful.dao;

import java.util.List;

import com.restful.entity.User;

public interface DaoBasic {

	public <T> List<T> find_multi(List<T> any);
	public <T> T find_single(T any);
	
	public <T> List<T> create_multi(List<T> any);
	public <T> T create_single(T any);
	
	public <T> List<T> delete_multi(List<T> any);
	public <T> T delete_single(T any);
	
	public <T> List<T> update_multi(List<T> any);
	public <T> T update_single(T any);
}
