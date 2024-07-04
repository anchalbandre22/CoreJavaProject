package com.app.stockutils;
import com.app.stockutils.StockUtils.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.app.stock.Stock;
import com.app.stock_exception.StockException;

public class StockValidation {

	// stock id (unique : string), stock name (string), company name(string) ,
	// price (double), closing date (Date) , quantity (int)

	public static Stock validateInput(String id, String name, String companyName, double price, String closingDate,
			int quantity ,List<Stock> list) throws Exception {
	          NoDuplicateId(id,list);
		Date Closingdate = DateValidation(closingDate);
		return new Stock(id, name, companyName, price, Closingdate, quantity);

	}

	public static void NoDuplicateId(String id,List<Stock> list) throws StockException {
		Stock stock = StockUtils.findById(id,list);
		if (stock !=null){
			throw new StockException("Id can't be duplicate");
		}
		

	}

	public static Date DateValidation(String ClosingDate) throws Exception {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ClosingDate);
		if (isFutureDate(date)) {
			return date;
		} else {
			throw new Exception("stock closing date must be a future date");

		}

	}

	private static boolean isFutureDate(Date date) {
		return date.after(new Date());
	}

	public static void purchaseStockAndValidate(String id, int purchaseQuantity,List<Stock> list) throws StockException {
		Stock stock = StockUtils.findById(id, list);
	    if (stock == null) {
	        throw new StockException("Invalid Stock ID: " + id);
	    }
	    if (purchaseQuantity > stock.getQuantity()) {
	        throw new StockException("Insufficient stock available");
	    } else {
	        stock.setQuantity(stock.getQuantity() - purchaseQuantity);
	        System.out.println("Stock purchased successfully. Updated stock: " + stock);
	    }
	}
	
	
	
	    public static void sellStockAndValidate(String id, int sellQuantity ,List<Stock> list) throws StockException {
		Stock stock = StockUtils.findById(id, list);
	    if (stock == null) {
	        throw new StockException("Invalid Stock ID: " + id);
	    }
		int quantity = stock.getQuantity() + sellQuantity;
		stock.setQuantity(quantity);
		System.out.println("Stock Sold Succesfully");
		System.out.println(stock);
	}

}
