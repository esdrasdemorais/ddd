
package com.esdrasmorais.ddd.service;

import java.util.List;

import com.esdrasmorais.ddd.repository.interfaces.IRepository;

public abstract class Service<T> implements IService<T> {

	private final IRepository<T> _repository;

	public Service(IRepository<T> repository) {
		this._repository = repository;
	}

	public List<T> findAll() {
		return this._repository.findAll();
	}

	public T findById(Long id) {
		return this._repository.findById(id);
	}

	public List<T> find(String query, Object[] params) {
		return this._repository.find(query, params);
	}

	public Boolean save(T object) {
		return this._repository.save(object);
	}

	public Boolean remove(T object) {
		return this._repository.remove(object);
	}

	public void dispose() {
		this._repository.dispose();
	}
}