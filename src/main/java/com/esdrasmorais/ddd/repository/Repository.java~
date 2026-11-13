
package com.esdrasmorais.ddd.repository;

import java.util.List;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.esdrasmorais.ddd.repository.interfaces.IRepository;

public abstract class Repository<T> extends Context implements IRepository<T> {
	
	public Repository(IContext context, IClient client, IDb db) {
		super(context, client, db);
		// TODO Auto-generated constructor stub
	}

	private RepositoryImpl repositoryImpl;

	public List<T> find(String query, Object[] params) {
		return repositoryImpl.find(query, params);
	}

	public Boolean save(T object) {
		return repositoryImpl.save(object);
	}

	public Boolean remove(T object) {
		return repositoryImpl.remove(object);
	}

	@Override
	public List<T> findAll() {
		return repositoryImpl.findAll();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public T findById(Long id) {
		return (T) repositoryImpl.findById(id);
	}
}
