package com.app.stock_exception;

import com.app.stockutils.StockValidation.*;

public class StockException extends Exception {
	public StockException(String mesg) {
		super(mesg);
	}
}
