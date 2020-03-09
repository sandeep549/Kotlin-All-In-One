package com.example.kotlinsamples.leetcode.kotlin.tree

private fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun makeRoot(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        var m = l + (r - l + 1) / 2 // +1 plays role in case when length is even and you want the middle on right side
        var root = TreeNode(nums[m])
        root.left = makeRoot(l, m - 1)
        root.right = makeRoot(m + 1, r)
        return root
    }
    return makeRoot(0, nums.size - 1)
}

// todo: can we do it iteratively?