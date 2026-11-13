
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public abstract class Client implements IClient {
	private String database;
	private final String host;
	private final Integer port;
	private final String connectionString;
	protected MongoClient mongoClient = null;
	
	public Client(String connectionString, String host, Integer port) {
		this.connectionString = connectionString;
		this.host = host;
		this.port = port;
		mongoClient = new MongoClient();
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return this.host;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	public Integer getPort() {
		return this.port;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public String getDatabase() {
		return this.database;
	}

	public IDb getDb(String database) {
		MongoDatabase mongoDb = null;
		try {
			mongoDb = this.mongoClient.getDatabase(database);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new MongoDb(this, mongoDb); 
	}

	public MongoClient getMongoClient() {
		return this.mongoClient;
	}
}
