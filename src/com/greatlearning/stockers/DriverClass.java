package com.greatlearning.stockers;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, choice;
		double keyStock ;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of companies -> ");
		n = sc.nextInt();

		CompanyStockers cs = new CompanyStockers(n); 

		for(int i = 0; i < n; i++) {
			System.out.println("Enter current stock price of the company " + (i+1) + " : ");
			cs.stockPrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday? ");
			cs.status[i] = sc.nextBoolean();
		}
		int len = (cs.stockPrice).length - 1;
		do {
			System.out.println("\n -----------------------------------------------");
			System.out.println("Enter the operation that you want to perform\r\n" + 
					"1. Display the companies stock prices in ascending order\r\n" + 
					"2. Display the companies stock prices in descending order\r\n" + 
					"3. Display the total no of companies for which stock prices rose today\r\n" + 
					"4. Display the total no of companies for which stock prices declined today\r\n" + 
					"5. Search a specific stock price\r\n" + 
					"6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			choice = sc.nextInt();

			switch(choice) {
			case 1:
				/*Display the companies stock prices in ascending order*/
				cs.sortStockAscend(cs.stockPrice, 0, len);
				System.out.println("Stock prices in ascending order are : ");
				cs.display(cs.stockPrice);
				break;
			case 2:
				/*Display the companies stock prices in descending order*/
				cs.sortStockDescend(cs.stockPrice, 0, len);
				System.out.println("Stock prices in descending order are : ");
				cs.display(cs.stockPrice);
				break;
			case 3:
				/*Display the total no of companies for which stock prices rose today*/
				System.out.println(" Total no of companies whose stock price rose today : " + cs.isStockRoseDecline(choice));
				break;
			case 4:
				/*Display the total no of companies for which stock prices declined today*/
				System.out.println("Total no of companies whose stock price declined today : " + cs.isStockRoseDecline(choice));
				break;
			case 5:
				/*Search a specific stock price*/
				System.out.println("enter the key value ");
				keyStock = sc.nextDouble();
				cs.findStock(cs.stockPrice, 0, len, keyStock);
				break;
			case 0:
				System.out.println("Exited successfully");
				break;
			}
		}while(choice!=0);

		sc.close();
	}	
}
