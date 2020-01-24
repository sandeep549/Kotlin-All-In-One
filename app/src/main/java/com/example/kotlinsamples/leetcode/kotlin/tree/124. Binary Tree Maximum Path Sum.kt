package com.example.kotlinsamples.leetcode.kotlin.tree

/**
 * Traverse the tree and while backtrack, maintain mas_so_far at every node, return max passing through
 * current node. We need to return values for first 3 cases from below, 4th case will be considered
 * in max_so_far
 *
 * For each node there can be four ways that the max path goes through the node:
 * 1. Node only
 * 2. Max path through Left Child + Node
 * 3. Max path through Right Child + Node
 * 4. Max path through Left Child + Node + Max path through Right Child
 */
private fun maxPathSum(root: TreeNode?): Int {
    var max_so_far = Int.MIN_VALUE
    fun max(root: TreeNode?): Int {
        if (root == null) return 0
        var l = max(root.left)
        var r = max(root.right)
        max_so_far = max_so_far.coerceAtLeast(l + root.`val`) //max path till now
            .coerceAtLeast(r + root.`val`)
            .coerceAtLeast(l + r + root.`val`)
            .coerceAtLeast(root.`val`)

        return root.`val`.coerceAtLeast(l + root.`val`) //max passing through this node
            .coerceAtLeast(r + root.`val`)
    }
    max(root)
    return max_so_far
}

private fun maxPathSum2(root: TreeNode?): Int {
    var max_so_far = Int.MIN_VALUE
    /**
     * Function return max path sum passing through current node
     */
    fun max(root: TreeNode?): Int {
        if (root == null) return 0
        //if its negative, it will not add any value to max path, mark it 0
        var l = Math.max(0, max(root.left))
        var r = Math.max(0, max(root.right))
        max_so_far = Math.max(max_so_far, l + r + root.`val`)
        return Math.max(l, r) + root.`val`
    }
    max(root)
    return max_so_far
}