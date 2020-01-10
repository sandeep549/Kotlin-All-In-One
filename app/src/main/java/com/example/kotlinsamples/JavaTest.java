package com.example.kotlinsamples;

public class JavaTest {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) { // find first
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        int first = lo;
        hi = nums.length - 1;
        while (lo < hi) { // find last
            mid = lo + (hi - lo + 1) / 2; //keep mid towards hi side
            if (nums[mid] <= target) lo = mid;
            else hi = mid - 1;
        }
        return (nums.length == 0 || nums[lo] != target) ?
                new int[]{-1, -1} : new int[]{first, lo};
    }
}
