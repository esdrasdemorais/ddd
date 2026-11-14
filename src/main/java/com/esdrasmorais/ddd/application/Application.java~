package com.esdrasmorais.ddd.application;

import java.util.List;

import com.esdrasmorais.ddd.service.IService;

public abstract class Application<T> implements IApplication<T> {
	private final IService<T> _service;

	public Application(IService<T> service) {
		this._service = service;
	}

	public List<T> findAll() {
		return this._service.findAll();
	}

	public T findById(Long id) {
		return this._service.findById(id);
	}

	public List<T> find(String query, Object[] params) {
		return this._service.find(query, params);
	}

	public Boolean save(T object) {
		return this._service.save(object);
	}

	public Boolean remove(T object) {
		return this._service.remove(object);
	}

	public void dispose() {
		this._service.dispose();
	}
}
