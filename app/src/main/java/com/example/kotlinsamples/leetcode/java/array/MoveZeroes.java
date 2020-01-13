package com.example.kotlinsamples.leetcode.java.array;

import java.util.Arrays;

/*
 * Given an array nums, 
 * write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *  
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */

public class MoveZeroes {

	public static void main(String[] args) {
		int[] array = {0,1,0,3,12};
		moveZeroes(array);
		System.out.println(Arrays.toString(array));
	}

	private static void moveZeroes(int[] array) {
		if (array == null || array.length < 1)
			throw new NullPointerException("Initialize array");

		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[index++] = array[i];
			}
		}

		for (int i = index; i < array.length; i++) {
			array[i] = 0;
		}
	}
}
