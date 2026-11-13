
package com.esdrasmorais.ddd.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
	public List<T> findAll();

	public T findById(Long id);

	public List<T> find(String query, Object[] params);

	public Boolean save(T object);

	public Boolean remove(T object);

	public void dispose();
}
