package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private fun isValidBST(root: TreeNode?): Boolean {
    fun dfs(node: TreeNode?, l: Int?, r: Int?): Boolean {
        if (node == null) return true
        if (l != null && node.`val` <= l) return false
        if (r != null && node.`val` >= r) return false
        return dfs(node.left, l, node.`val`) && dfs(node.right, node.`val`, r)
    }
    return dfs(root, null, null)
}

// same as above only kotlin construct difference
private fun isValidBST2(root: TreeNode?): Boolean {
    fun dfs(node: TreeNode?, l: Int?, r: Int?): Boolean {
        node ?: return true
        l?.let { if (node.`val` <= it) return false }
        r?.let { if (node.`val` >= it) return false }
        return dfs(node.left, l, node.`val`) && dfs(node.right, node.`val`, r)
    }
    return dfs(root, null, null)
}

private fun isValidBST3(root: TreeNode?): Boolean {
    val stack: Deque<TreeNode> = ArrayDeque()
    var inorder: Int? = null
    var curr = root
    while (!stack.isEmpty() || curr != null) {
        while (curr != null) {
            stack.push(root)
            curr = curr.left
        }
        curr = stack.pop()
        // If next element in inorder traversal
        // is smaller than the previous one
        // that's not BST.
        if (inorder != null && curr.`val` <= inorder) return false
        inorder = curr.`val`
        curr = curr.right
    }
    return true
}