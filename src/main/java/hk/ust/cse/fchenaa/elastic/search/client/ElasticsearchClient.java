package hk.ust.cse.fchenaa.elastic.search.client;

import java.io.IOException;

public class ElasticsearchClient {
	
	private ElasticsearchManager manager;
	
	public ElasticsearchClient() {
		manager = new ElasticsearchManager();
	}
	
	public void setup() {
		try {
			manager.setup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void index() {
		try {
			manager.index();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void curlIndex() {
		try {
			manager.curlIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerRepository() {
		try {
			manager.registerRepository();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createSnapshot() {
		try {
			manager.createSnapshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void restoreSnapshot() {
		try {
			manager.restoreSnapshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disabledSharedAllocation() {
		try {
			manager.disabledSharedAllocation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reenabledAllocation() {
		try {
			manager.reenabledAllocation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void synchedFlush() {
		try {
			manager.synchedFlush();
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
	
	public static void main(String[] args) {
		ElasticsearchClient client = new ElasticsearchClient();
		//client.setup();
		//client.curlIndex();
		//client.registerRepository();
		//client.createSnapshot();
		//client.restoreSnapshot();
		//client.disabledSharedAllocation();
		//client.synchedFlush();
		client.reenabledAllocation();
	}
	
}
