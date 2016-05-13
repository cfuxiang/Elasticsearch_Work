package hk.ust.cse.fchenaa.elastic.search.client;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.BulkResult;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;


public class ElasticsearchManager {

	private static JestClient client; //since this is a singleton, I'm going to just initialise it once.

	static {
		if(client == null) {
			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(new HttpClientConfig
					.Builder("http://localhost:9200")
					.multiThreaded(true)
					.build());
			client = factory.getObject();
		}
	}

	public boolean index() throws IOException {
		client.execute(new CreateIndex.Builder("articles").build());

		Map<String, String> source = new LinkedHashMap<String,String>();
		source.put("user", "Fuxiang Chen");
		source.put("tel", "999");
		source.put("email", "cfuxiang@gmail.com");

		Index index = new Index.Builder(source).index("articles").type("testing").build();
		DocumentResult docResult = client.execute(index);
		return docResult.getResponseCode() == 200;
	}

	public String get() throws IOException {
		Get get = new Get.Builder("twitter", "1").type("tweet").build();
		JestResult result = client.execute(get);
		//for now just return the json string
		//later on will use gson - java bean
		return result.getJsonString();
	}

	public boolean update() throws IOException {
		String script = "{ \"user\" : \"New User\", " +
				"  \"tel\" : \"999\", " +
				"  \"new field\" : \"test\"" +
				"}";

		//careful - if none of the index, type & id exist, it will create a new record
		//safer to do a search then update! 
		DocumentResult docResult = client.execute(new Index.Builder(script)
									.index("articles11")
									.type("testing22")
									.id("AVSoCLq_zHpvC9RUdv1A")
									.build());
		return docResult.getResponseCode() == 200;
	}	

	public boolean delete() throws IOException {
		DocumentResult docResult = client.execute(new Delete.Builder("AVSoB6pzzHpvC9RUdv0_")
									.index("articles")
									.type("tweet")
									.build());
		return docResult.getResponseCode() == 200;
	}

	public String search() throws IOException {	
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("user", "Fuxiang"));

		Search search = new Search.Builder(searchSourceBuilder.toString())
				// multiple index or types can be added.
				.addIndex("tweeter")
				.addIndex("articles")
				.build();

		SearchResult result = client.execute(search);
		//for now just return the json string
		//later on will use gson - java bean
		return result.getJsonString();
	}

	public boolean batchOp() throws IOException {
		Bulk bulk = new Bulk.Builder()
				.defaultIndex("twitter")
				.defaultType("tweet")
				//can use java beans!
				//.addAction(new Index.Builder(article1).build())
				//.addAction(new Index.Builder(article2).build())
				.addAction(new Delete.Builder("1").index("twitter").type("tweet").build())
				.build();

		BulkResult bulkResult = client.execute(bulk);	
		return bulkResult.getResponseCode() == 200;
	}
}
