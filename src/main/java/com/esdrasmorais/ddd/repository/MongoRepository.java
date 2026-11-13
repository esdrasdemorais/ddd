
package com.esdrasmorais.ddd.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.Function;
import com.mongodb.client.MongoCollection;
import com.mongodb.DBCollection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.esdrasmorais.ddd.repository.interfaces.IRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.google.gson.Gson;

public abstract class MongoRepository<T> extends RepositoryImpl<T> 
	implements IRepository<T> 
{
	public MongoRepository(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}

	@Override
	public List<T> find(String query, Object[] params) {
		FindIterable<Document> result = this.findByKey(
			"Employee", "age", 32, (value) -> new Integer(value));
		/*while (result.hasNext()) {
		}*/
		return (List<T>) result;
	}

	public <T, X> FindIterable<Document> findByKey(String collectionName, 
		String key, T value, Function<T, X> convertDataType)
	{
		MongoCollection<Document> collection = this.getMongoDatabase()
			.getCollection(collectionName);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(key, convertDataType.apply(value));
		FindIterable<Document> cursor = collection.find(searchQuery);
		return cursor;
	}

	@Override
	public Boolean save(T object) {
		DBCollection collection = this.getDB()
			.getCollection(object.getClass().getName());
		Gson gson = new Gson();
//		BasicDBObject document = (BasicDBObject)JSON.parse(
//			gson.toJson(object)
//		);
		BasicDBObject document = BasicDBObject.parse(gson.toJson(object));
		collection.save(document);
		return true;
	}

	@Override
	public Boolean remove(T object) {
		DBCollection collection = this.getDB()
			.getCollection(object.getClass().getName());
		Gson gson = new Gson();
//		BasicDBObject document = (BasicDBObject)JSON.parse(
//				gson.toJson(object)
//			);
		BasicDBObject document = BasicDBObject.parse(gson.toJson(object));
		collection.remove(document);
		return true;
	}

	@Override
	public List<T> findAll(T clas) {
		List<T> list = new ArrayList<>();
		FindIterable<Document> iterable = this.getMongoDatabase()
			.getCollection(clas.getClass().getSimpleName()).find();
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				Gson gson = new Gson();
				T obj = (T) gson.fromJson(
					document.toJson(), 
					clas.getClass()
				);
				list.add(obj);
			}
		});
		return list;
	}

	@Override
	public T findById(Long id) {
		T object = null;
		List<T> list = new ArrayList<>();
		
	    Document query = new Document();
	    query.append("id", id);
		
		FindIterable<Document> result = this.getMongoDatabase()
			.getCollection(object.getClass().getName()).find(
				query
			);
		
		return list.get(0);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub	
	}
}
