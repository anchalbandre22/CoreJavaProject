package com.app.stocktester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import static com.app.stockutils.StockValidation.*;
import com.app.stock.Stock;
import com.app.stockutils.StockUtils;
import com.app.stockutils.StockValidation;

import static com.app.stockutils.StockUtils.*;

public class StockTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			List<Stock> list = populateStockData();
			while (!exit) {

				System.out.println("Enter your choice");
				System.out.println("1.Add New Stocks\n 2.View Available stocks by Company\n "
						+ "3.Purchase stocks\n 4.Sell Stocks\n 5.Display All Stocks\n 6.Save\n 7.Exit");

				switch (sc.nextInt()) {

				case 1:
					System.out.println("Enter details Id, name, companyName, price, Closingdate, quantity");
					Stock stock = validateInput(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
							sc.nextInt(),list);
					list.add(stock);
					break;
					
				case 2:
					System.out.println("Enter the Company Name");
					StockUtils.displayStockByCompany(sc.next(), list);
					break;
					
				case 3:
					System.out.println("Enter the Id and purchaseQuantity");
					StockValidation.purchaseStockAndValidate(sc.next(), sc.nextInt(),list);
					break;
				case 4:
					System.out.println("Enter the Id and purchaseQuantity");
					StockValidation.sellStockAndValidate(sc.next(), sc.nextInt(),list);
					break;
				case 5:
					  for(Stock s : list) {
						  System.out.println(s);
					  }
					  break;
					                  
				case 6 : System.out.println("Enter the filename");
					  try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sc.next()))) {
						  out.writeObject(list);
					  }
					 System.out.println("Data Saved Succesfully!!");
					
					
					      break;
				case 7 : exit = true ;
				  break;

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
