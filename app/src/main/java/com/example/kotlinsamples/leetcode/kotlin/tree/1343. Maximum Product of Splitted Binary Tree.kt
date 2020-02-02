package com.example.kotlinsamples.leetcode.kotlin.tree

private fun maxProduct(root: TreeNode?): Int {
    var total: Long = 0
    var max: Long = 0
    var sub: Long = 0
    var MOD: Int = (1e9 + 7).toInt()
    fun dfs(root: TreeNode?): Long {
        if (root == null) return 0
        sub = root.`val` + dfs(root.left) + dfs(root.right)
        max = Math.max(max, sub * (total - sub))
        return sub
    }
    total = dfs(root)
    dfs(root)
    return (max % MOD).toInt()
}