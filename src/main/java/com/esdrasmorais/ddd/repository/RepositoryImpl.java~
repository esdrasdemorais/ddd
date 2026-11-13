
package com.esdrasmorais.ddd.repository;

import java.util.List;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;

public abstract class RepositoryImpl<T> extends Context {
	public RepositoryImpl(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}
	
	public abstract List<T> find(String query, Object[] params);

	public abstract Boolean save(T object);

	public abstract Boolean remove(T object);
	
	public abstract List<T> findAll();

	public abstract T findById(Long id);
	
	public abstract void dispose();
}