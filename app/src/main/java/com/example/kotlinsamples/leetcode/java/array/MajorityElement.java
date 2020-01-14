package com.example.kotlinsamples.leetcode.java.array;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement {

	public static void main(String[] args) {
		int[] array = { 3, 2, 3 };
		int[] array1 = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(array));
		System.out.println(majorityElement(array1));

	}

	private static int majorityElement(int[] array) {
		if (array == null || array.length < 1) {
			throw new NullPointerException("Initialize array");
		}

		int majorityElement = array[0];
		int majorityCount = 1;
		for (int i = 1; i < array.length; i++) {

			if (majorityCount == 0) {
				majorityElement = array[i];
				majorityCount = 1;
			} else if (array[i] == majorityElement) {
				majorityCount++;
			} else {
				majorityCount--;
			}
		}

		return majorityElement;
	}

}
