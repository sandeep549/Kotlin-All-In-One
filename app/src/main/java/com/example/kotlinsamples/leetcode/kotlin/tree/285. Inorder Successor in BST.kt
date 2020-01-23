package com.example.kotlinsamples.leetcode.kotlin.tree

// solution not verified, as env. not available
private fun inorderSuccessor(root: TreeNode?, p: TreeNode): TreeNode? {
    var seen = false
    var ans: TreeNode? = null
    fun dfs(root: TreeNode?) {
        if (root != null && ans == null) {
            dfs(root.left)
            if (seen) ans = root
            if (!seen && root == p) seen = true
            dfs(root.right)
        }
    }
    dfs(root)
    return ans
}

/**
 * We can think it like a binary search on sorted array,
 * where we need to find just next bigger element for the given element.
 * Every time root is considered as mid, and input space is pruned keeping next bigger within input space.
 *
 * 1. If given element if bigger or equal to current root, then next bigger will definitely be in right side of it,
 *  whether its present or not, we don't care , just return it, null means it do not exist in tree.
 *
 * 2. If given element if small than root, then next bigger can be in left or may be current root is the next bigger.
 *    If backtracking gives non-null node then we found next bigger in left subtree otherwise, current root is next bigger, return it.
 *
 */
private fun inorderSuccessor2(root: TreeNode?, p: TreeNode): TreeNode? {
    root?.let {
        if (p.`val` >= root.`val`) {
            return inorderSuccessor2(root.right, p)
        } else {
            var node = inorderSuccessor2(root.left, p)
            return node ?: root
        }
    }
    return null
}