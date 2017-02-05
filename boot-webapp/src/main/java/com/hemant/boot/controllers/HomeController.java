package com.hemant.boot.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hemant.boot.service.FinanceService;
import com.hemant.boot.service.ReportsUtil;


/**
 * 
 * This is not REST CONTROLLER.
 * If it was a rest controller, its response is directly used as output (converted to JSON)
 * But here we want it to be processed via VIEW RESOLVERS
 * Hence its a normal controller
 * All controllers barring this can be REST CONTROLLERS
 * @author hemantvsn
 * @since 0.0.1
 * 
 * 
 */

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	FinanceService financeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("author", "hemantvsn");
		model.addAttribute("version", "0.0.1");
		model.addAttribute("stocks", financeService.getStockInfos());
		return "index";
	}
	
	@RequestMapping(value = "/excel-report", method = RequestMethod.GET)
	public void getExcelReport(Model model, HttpServletResponse response) throws IOException {
		ByteArrayOutputStream stream = (ByteArrayOutputStream) ReportsUtil.getStockReportXLS(financeService.getStockInfos());
		response.setHeader("Content-Disposition", "attachment;filename=" + "stock-report.xls");
		response.getOutputStream().write(stream.toByteArray());
		stream.flush();
		stream.close();
	}

}
