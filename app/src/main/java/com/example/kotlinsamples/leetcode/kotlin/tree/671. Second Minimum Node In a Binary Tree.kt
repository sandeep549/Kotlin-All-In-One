package com.example.kotlinsamples.leetcode.kotlin.tree

private fun findSecondMinimumValue(root: TreeNode?): Int {
    var ans = ArrayList<Int>()
    fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        dfs(root.right)
        if (!ans.contains(root.`val`)) ans.add(root.`val`)
        ans.sort() // O(1) performance as size is fixed
        if (ans.size == 3) ans.removeAt(2)
    }
    dfs(root)
    return if (ans.size >= 2) ans[1] else -1
}