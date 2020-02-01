package com.example.kotlinsamples.leetcode.kotlin.tree


/**
 * 1. Perform DFS on tree, maintain reference to parent node for ech node.
 * 2. Now start from target node, and perform dfs in 3 directions,left, right and up.
 *    When dist is required record the node. Main seen set to avoid duplicate traversal.
 */
private fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
    var parentMap = mutableMapOf<TreeNode, TreeNode?>()

    fun dfs(root: TreeNode?, parent: TreeNode?) {
        root?.let {
            parentMap.put(it, parent)
            dfs(it.left, it)
            dfs(it.right, it)
        }
    }
    dfs(root, null)

    var ans = mutableListOf<Int>()
    var seen = mutableSetOf<TreeNode>()
    fun dfs2(root: TreeNode?, dist: Int) {
        root?.let {
            if (seen.contains(it)) return
            else seen.add(it)
            if (dist == K) ans.add(it.`val`)
            dfs2(it.left, dist + 1)
            dfs2(it.right, dist + 1)
            dfs2(parentMap.get(it), dist + 1)
        }
    }
    dfs2(target, 0)

    return ans
}