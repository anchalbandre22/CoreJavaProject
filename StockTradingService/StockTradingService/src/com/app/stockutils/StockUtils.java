package com.app.stockutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.stock.Stock;
import com.app.stock_exception.StockException;

public class StockUtils {

	public static List<Stock> populateStockData() throws Exception {
		List<Stock> list = new ArrayList<>();
		Stock s1 = new Stock("101", "AlphaTech", "AlphaInc.", 120.50,
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-30"), 1000);

		Stock s2 = new Stock("102", "BetaHealth", "BetaLtd.", 85.75,
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-15"), 500);

		Stock s3 = new Stock("103", "GammaEnergy", "GammaCorp.", 150.00,
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-20"), 2000);

		Stock s4 = new Stock("104", "DeltaFinance", "DeltaBank", 95.25,
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-08-01"), 750);

		Stock s5 = new Stock("105", "EpsilonTech", "EpsilonTechnologies", 180.10,
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-09-10"), 1200);

		Stock arr[] = { s1, s2, s3, s4, s5 };
		for (Stock s : arr) {
			list.add(s);
		}
		return list;
	}

	public static void displayStockByCompany(String company, List<Stock> list) {
		for (Stock s : list) {
			if (s.getCompanyName().equalsIgnoreCase(company)) {
				System.out.println(s);
			}
		}

	}

	
	public static Stock findById(String id, List<Stock> list) {
        for (Stock s : list) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

}
