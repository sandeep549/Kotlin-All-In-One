package com.example.kotlinsamples.leetcode.kotlin.tree

private fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    var res = false
    fun dfs(root: TreeNode?, x: Int, y: Int): Int { // return depth of any target found first
        root?.let {
            if (it.`val` == x || it.`val` == y) return 1
            var l = dfs(it.left, x, y)
            var r = dfs(it.right, x, y)
            if (l > 1 && l == r) res = true // both at more than 1 depth and at same level
            return if (l == r && l == 0) 0 else maxOf(l, r) + 1
        }
        return 0
    }
    dfs(root, x, y)
    return res
}