package com.example.kotlinsamples.leetcode.java.array;

import java.util.Arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Input: [1,1,2]
 * Output: 2
 * 
 * Input: [0,0,1,1,1,2,2,3,3,4]
 * Output: 5
 */

public class RemoveDuplicatesInSortedArray {

	public static void main(String[] args) {

		int[] array = { 1, 1, 2 };
		int[] array1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(removeDuplicates(array));
		System.out.println(removeDuplicates(array1));
		// To validate the output, as per leet code question
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array1));
	}

	private static int removeDuplicates(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		int count = 1;
		int currentElement = array[0];
		for (int i = 1; i < array.length; i++) {
			if (currentElement != array[i]) {
				array[count++] = array[i];
				currentElement = array[i];
			}
		}

		return count;
	}

}
