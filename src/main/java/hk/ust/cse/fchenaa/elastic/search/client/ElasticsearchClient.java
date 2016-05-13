package hk.ust.cse.fchenaa.elastic.search.client;

import java.io.IOException;

public class ElasticsearchClient {
	
	private ElasticsearchManager manager;
	
	public ElasticsearchClient() {
		manager = new ElasticsearchManager();
	}
	
	public void index() {
		try {
			manager.index();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void get() {
		try {
			manager.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			manager.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			manager.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search() {
		try {
			manager.search();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
