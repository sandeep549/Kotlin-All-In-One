package com.example.kotlinsamples.leetcode.kotlin.tree

//backtracking
/**
 * Traverse the tree in dfs, and while backtrack, keep track of 2 things
 * 1. Max of (Max distance between any 2 nodes under this node, and max_so_far)
 * 2. Max length from this node to any leaf
 *
 * Every node will return max length path available under it.
 * For every node calculate max distance by adding max length on left and right side of it,
 * and keep track'of max found so far.
 */
private fun diameterOfBinaryTree(root: TreeNode?): Int {
    var ans = 0
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        var l = dfs(root.left)
        var r = dfs(root.right)
        ans = Math.max(ans, l + r)
        return maxOf(l, r) + 1
    }
    dfs(root)
    return ans
}

//TODO : try iteratively