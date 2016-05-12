package hk.ust.cse.fchenaa.elastic.search.client;


public class ElasticsearchClient {
	
	private ElasticsearchManager manager;
	
	public ElasticsearchClient() {
		manager = new ElasticsearchManager();
	}
	
	public void index() {

	}
	
    public static void main( String[] args ) {
    	ElasticsearchClient client = new ElasticsearchClient();
    	client.index();
    }
}
