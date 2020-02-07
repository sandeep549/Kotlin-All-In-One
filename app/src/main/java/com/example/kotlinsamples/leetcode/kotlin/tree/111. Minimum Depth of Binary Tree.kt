package com.example.kotlinsamples.leetcode.kotlin.tree


private fun minDepth(root: TreeNode?): Int {
    fun dfs(root: TreeNode): Int {
        if (root.left == null && root.right == null) return 1
        var l = root.left?.let { dfs(it) } ?: Int.MAX_VALUE
        var r = root.right?.let { dfs(it) } ?: Int.MAX_VALUE
        return minOf(l, r) + 1
    }
    if (root == null) return 0
    return dfs(root)
}

private fun minDepth2(root: TreeNode?): Int {
    if (root == null) return 0
    val left = minDepth2(root.left)
    val right = minDepth2(root.right)
    return if (left == 0 || right == 0) left + right + 1 else Math.min(left, right) + 1
}

//todo: try with bfs or iteration