package com.greatlearning.stockers;

public class CompanyStockers {
	// to store stock prices
	double[] stockPrice;
	// to store whether the sock price rose or declined?
	boolean[] status;

	public CompanyStockers(int n) {
		// TODO Auto-generated constructor stub
		stockPrice = new  double[n]; //allocate stockPrice to store stock prices for n companies
		status = new boolean[n]; ////allocate status to store whether stock rose or declined for n companies
	}

	// sort stock prices in ascending order
	public void sortStockAscend(double[] stockPrice, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			//divide stock prices in left and right array
			sortStockAscend(stockPrice, left, mid);
			sortStockAscend(stockPrice, mid+1, right);

			//to merge the left and right array in ascending order
			mergeStockAscend(stockPrice, left, mid, right);
		}
	}

	// merge the stock prices in ascending order
	private void mergeStockAscend(double[] stockPrice, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int len1 = mid - left + 1;
		int len2 = right - mid;
		double leftArr[] = new double[len1];
		double rightArr[] = new double[len2];

		for(int i = 0; i < len1; i++)
			leftArr[i] = stockPrice[left + i];
		for(int j = 0; j < len2; j++)
			rightArr[j] = stockPrice[mid + 1 + j];

		int i, j, k;
		i = j = 0;
		k = left;

		while(i < len1 && j < len2) {
			// to sort in ascending order so start with leftArr < rightArr
			if(leftArr[i] < rightArr[j]) {
				stockPrice[k] = leftArr[i];
				i++;
			}else {
				stockPrice[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while(i < len1) {
			stockPrice[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < len2) {
			stockPrice[k] = rightArr[j];
			j++;
			k++;
		}
	}

	// sort stock prices in descending order
	public void sortStockDescend(double[] stockPrice, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			//divide stock prices in left and right parts
			sortStockDescend(stockPrice, left, mid);
			sortStockDescend(stockPrice, mid+1, right);

			// to merge the left and right array in descending order
			mergeStockDescend(stockPrice, left, mid, right);
		}
	}

	// merge the stock prices in descending order
	private void mergeStockDescend(double[] stockPrice, int left, int mid, int right) {
		int len1 = mid - left + 1;
		int len2 = right - mid;
		double leftArr[] = new double[len1];
		double rightArr[] = new double[len2];

		for(int i = 0; i < len1; i++)
			leftArr[i] = stockPrice[left + i];
		for(int j = 0; j < len2; j++)
			rightArr[j] = stockPrice[mid + 1 + j];

		int i, j, k;
		i = j = 0;
		k = left;

		while(i < len1 && j < len2) {
			// to sort in descending order so start with leftArr > rightArr
			if(leftArr[i] > rightArr[j]) {
				stockPrice[k] = leftArr[i];
				i++;
			}else {
				stockPrice[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while(i < len1) {
			stockPrice[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < len2) {
			stockPrice[k] = rightArr[j];
			j++;
			k++;
		}	
	}

	// method to calculate companies stock rose or declined?
	public int isStockRoseDecline(int choice) {
		int countT = 0; // store count of stock rose companies
		int countF = 0; // store count of stock declined companies
		for(int i = 0; i < status.length; i++) {
			if(status[i] == true) {
				countT++; // increment count of stock rose companies
			}	
			else if(status[i] == false) {
				countF++; // increment count of stock declined companies
			}	
		}

		if(choice == 3) {
			return countT; // return only count of companies for which stock rose
		}else {
			return countF; // return only count of companies for which stock got declined
		}		
	}	

	//method to check entered stock is present or not?
	public void findStock(double[] stockPrice, int first, int last, double keyStock) {
		//first sort all the stocks present in ascending order
		sortStockAscend(stockPrice,0 ,stockPrice.length-1);

		int mid = (first + last);

		while(first <= last) {
			if(stockPrice[mid] < keyStock) {
				first = mid + 1;
			}
			else if(stockPrice[mid] == keyStock) {
				System.out.println("Stock of value "+ keyStock +" is present ");
				break;
			}
			else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if(first > last) {
			System.out.println("Value not found!!! \n");
		}	
	}

	// to display stock prices of companies
	public void display(double[] stockPrice) {
		int n = stockPrice.length;

		for(int i = 0; i < n; i++) {
			System.out.print(stockPrice[i] + "  ");	
		}
	}
}
