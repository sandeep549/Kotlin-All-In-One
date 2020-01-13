package com.example.kotlinsamples.leetcode.java.array;

import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */

public class MissingNumber {

	public static void main(String[] args) {
		int[] array = { 3, 0, 1 };
		int[] array1 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int[] array2 = { 0, 1, 2, 3 };

		System.out.println(missingNumber(array));
		System.out.println(missingNumber(array1));
		System.out.println(missingNumber(array2));

		System.out.println(missingNumber2(array));
		System.out.println(missingNumber2(array1));
		System.out.println(missingNumber2(array2));

		System.out.println(missingNumber3(array));
		System.out.println(missingNumber3(array1));
		System.out.println(missingNumber3(array2));
		
		System.out.println(missingNumber4(array));
		System.out.println(missingNumber4(array1));
		System.out.println(missingNumber4(array2));
	}

	private static int missingNumber(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		int expectedSum = (array.length * (array.length + 1)) / 2;
		int actualSum = 0;

		for (int number : array)
			actualSum += number;

		return expectedSum - actualSum;
	}

	private static int missingNumber2(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		int result = array.length;
		for (int i = 0; i < array.length; i++) {
			result = result ^ i ^ array[i];
		}

		return result;
	}

	/*
	 * Follow up Question, What if numbers are sorted?
	 *
	 * Input: [0,1,2,3]
	 *  Output: 4
	 * 
	 * Input: [3,0,1]
	 * Output: 2
	 * 
	 */

	private static int missingNumber3(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		// Not to be considered as sorting, as the input will be sorted. This is just to
		// replicate
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			if (array[i] != i)
				return i;
		}

		return array.length;
	}
	
	private static int missingNumber4(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		// Not to be considered as sorting, as the input will be sorted. This is just to
		// replicate
		Arrays.sort(array);
		int start = 0;
		int end = array.length-1;
		
		while (start <= end) {
			int mid = start + (end-start)/2;
			
			if(array[mid] == mid) {
				start = mid +1;
			} else {
				end = mid -1;
			}
		}

		return start;
	}

}
