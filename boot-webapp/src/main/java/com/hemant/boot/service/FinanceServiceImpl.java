package com.hemant.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.boot.model.StockInfo;

@Service
public class FinanceServiceImpl implements FinanceService {

	@Autowired
	FileReaderService readerService;

	@Override
	public List<StockInfo> getStockInfos() {
		return null;
	}

}
