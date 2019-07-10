package com.gft.upv.flink.process;

import java.util.HashMap;
import java.util.Map;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentType;

import com.gft.upv.config.ElasticConfig;


public class StockElasticSink implements ElasticsearchSinkFunction<GenericRecord> {
	
	ElasticConfig config;
	
	public StockElasticSink(ElasticConfig config) {
		this.config=config;
	}
	
	public IndexRequest createIndexRequest(GenericRecord element) {
   
		
		Map<String, Object> map = new HashMap<>();
		
		//TODO Exercise 3 fill Map with element values
		//take a look  to flink documentation https://ci.apache.org/projects/flink/flink-docs-stable/dev/connectors/elasticsearch.html
		
		
		//TODO create a index Request
		
	}
	
	
	@Override
	public void process(GenericRecord element, RuntimeContext ctx, RequestIndexer indexer) {
		 indexer.add(createIndexRequest(element));
		
	}
}

/*

}*/