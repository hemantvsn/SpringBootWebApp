package com.hemant.boot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FileReaderService {
	private static final Logger LOG = LoggerFactory.getLogger(FileReaderService.class);
	
	private String yql;
	private List<String> symbols = new ArrayList<>();

	/**
	 * 1. Read stocks.txt 2. prepare symbols list as well as yql
	 * 
	 * @throws FileNotFoundException
	 */
	@PostConstruct
	public void init() throws FileNotFoundException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Stocks.txt").getFile());
		Scanner linReader = new Scanner(file);

		while (linReader.hasNext()) {
			String line = linReader.nextLine();
			symbols.add(line);
		}
		linReader.close();
		yql = StringUtils.collectionToCommaDelimitedString(symbols);
		
		LOG.info("Stocks.txt read successfully and contains :{} symbols", symbols.size());
		LOG.info("YQL clause obtained via joining all symbols :{}", yql);
	}
	
	public List<String> getSymbols() {
		return symbols;
	}
	
	public String getYql() {
		return yql;
	}

}
