package com.example.kotlinsamples.leetcode.java.array;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *  
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * 
 * Input: [1,2,3,4,5]
 * Output: 4
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 */

public class BuySellStock2 {

	public static void main(String[] args) {
		int[] array = { 7, 1, 5, 3, 6, 4 };
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 7, 6, 4, 3, 1 };
		System.out.println(buySellStock2(array));
		System.out.println(buySellStock2(array1));
		System.out.println(buySellStock2(array2));

	}

	private static int buySellStock2(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		int maxProfit = 0;

		for (int i = 0; i < array.length-1; i++) {
			maxProfit += (array[i + 1] > array[i]) ? (array[i + 1] - array[i]) : 0;
		}

		return maxProfit;

	}

}
