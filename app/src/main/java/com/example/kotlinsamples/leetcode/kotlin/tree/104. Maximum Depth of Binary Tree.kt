package com.example.kotlinsamples.leetcode.kotlin.tree

private fun maxDepth(root: TreeNode?): Int {
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(dfs(root.left), dfs(root.right)) + 1
    }
    return dfs(root)
}

private fun maxDepth2(n: TreeNode?): Int {
    return if (n == null) 0 else maxOf(maxDepth2(n.left), maxDepth2(n.right)) + 1
}

//todo: do it iteratively