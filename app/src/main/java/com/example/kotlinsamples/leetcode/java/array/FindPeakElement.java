package com.example.kotlinsamples.leetcode.java.array;

/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Input: = [1,2,3,1]
 * Output: 2
 * 
 * Input: = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 */

public class FindPeakElement {

	public static void main(String[] args) {
		int[] array = { 1,2,3,1 };
		int[] array1 = { 1,2,1,3,5,6,4 };
		
		System.out.println(peakElement(array));
		System.out.println(peakElement(array1));

	}

	private static int peakElement(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (array[mid] > array[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

}
