package com.example.demo.leetcode;

public class BestTimeStockPrice {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int result = maxProfit(prices);
		int results = mxProfitUsingOptimalWay(prices);

		System.out.println("Maximum Profit using BruteForce: " + result);
		System.out.println("Maximum profit usng optimal way: " + results);
	}

	// Using Brute Force
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {

				int profit = prices[j] - prices[i];
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	// Using optimal way
	public static int mxProfitUsingOptimalWay(int[] prices) {
		int maxProfitt = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int price : prices) {

			if (price < minPrice) {
				minPrice = price;
			} else {
				int profit = price - minPrice;
				if (profit > maxProfitt)
					maxProfitt = profit;
			}
		}

		return maxProfitt;
	}
}
