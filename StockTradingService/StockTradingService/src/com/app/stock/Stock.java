package com.app.stock;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Stock implements Serializable {
//stock id (unique : string), stock name (string), company name(string) , 
	// price (double), closing date (Date) , quantity (int)
    
	private String id;
	private String StockName;
	private String CompanyName;
	private double price;
	private Date closingDate;
	private int quantity;

	public Stock(String id, String stockName, String companyName, double price, Date closingDate, int quantity) {
		super();
		this.id = id;
		StockName = stockName;
		CompanyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}

	public Stock(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		StockName = stockName;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", StockName=" + StockName + ", CompanyName=" + CompanyName + ", price=" + price
				+ ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}

}
