package com.example.kotlinsamples.leetcode.java.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *  
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Input: [1,2,3,4]
 * Output: false
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] array = {1,2,3,1};
		int[] array1 = {1,2,3,4};
		int[] array2 = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(containsDuplicate(array));
		System.out.println(containsDuplicate(array1));
		System.out.println(containsDuplicate(array2));

	}

	private static boolean containsDuplicate(int[] array) {
		if (array == null || array.length < 1)
			return false;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		return !(set.size() == array.length);
	}

}
