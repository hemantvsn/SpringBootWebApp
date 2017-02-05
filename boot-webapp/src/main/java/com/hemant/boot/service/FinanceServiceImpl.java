package com.hemant.boot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.hemant.boot.model.StockInfo;

@Service
public class FinanceServiceImpl implements FinanceService {

	@Autowired
	FileReaderService readerService;

	@Override
	public List<StockInfo> getStockInfos() {
		List<StockInfo> stocks;
		try {
			stocks = getStocksInfoYahooAPI();
		} catch (Exception e) {
			throw new IllegalStateException("Unable to query YAHOO FINANCE API", e);
		}
		return stocks;
		
	}
	
	private List<StockInfo> getStocksInfoYahooAPI() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		String query = "select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20("+readerService.getYql()+")";
		HttpGet request = new HttpGet("https://query.yahooapis.com/v1/public/yql?q="+query+"&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
		HttpResponse response = client.execute(request);
		return comprehendResponse(response);
	}
	
	private List<StockInfo> comprehendResponse(HttpResponse httpResponse) throws JsonParseException, UnsupportedOperationException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jsonParser = jsonFactory.createParser(httpResponse.getEntity().getContent());
		JsonNode root = objectMapper.readTree(jsonParser);
		JsonNode results = root.path("query").path("results");
		ArrayNode quotes = (ArrayNode) results.path("quote");
		
		List<StockInfo> stocks = new ArrayList<>();
		
		for(JsonNode quote : quotes) {
			stocks.add(objectMapper.readValue(quote.toString(), StockInfo.class));
		}
		return stocks;
	}

}
