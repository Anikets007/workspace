package com.practice.dsa.leetcode;

public class BestTimeBuySellStock {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };
//		int[] prices = {7,6,4,3,1};

		int resulMaxProfitBF = maxProfit(prices);

		System.out.println(resulMaxProfitBF);

		int optimalResult = maxProfitOptimalWay(prices);
		System.err.println(optimalResult);

	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {

				int profit = prices[j] - prices[i];
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	public static int maxProfitOptimalWay(int[] prices) {
		int maxProfit = 0;
		int minValue = Integer.MAX_VALUE;

		for (int price : prices) {
			if (price < minValue) {
				minValue = price;
			} else {
				int profit = price - minValue;
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}

//		for (int i = 0; i < prices.length; i++) {
//			if (prices[i] < minValue) {
//				minValue = prices[i];
//			} else {
//				int profit = prices[i] - minValue;
//				if (profit > maxProfit) {
//					maxProfit = profit;
//				}
//			}
//		}
		return maxProfit;
		
	}
}
