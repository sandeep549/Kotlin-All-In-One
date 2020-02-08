package com.example.kotlinsamples.leetcode.kotlin.tree

/**
 * 1. traverse in preorder from left to right and pick one element e1.
 * 2. find this element e1's location in inorder, divide inorder in two parts being e1 as pivot.
 * 3. Make e1 as root, recur in left sub-part of inorder for left subtree and right part of inorder for right subtree.
 */
private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    var i = 0
    fun dfs(l: Int, r: Int): TreeNode? {
        if (i >= preorder.size || l > r) return null
        var ele = preorder[i++]
        var k = l - 1
        while (k < r) if (inorder[++k] == ele) break
        var node = TreeNode(ele)
        node.left = dfs(l, k - 1)
        node.right = dfs(k + 1, r)
        return node
    }
    return dfs(0, inorder.size - 1)
}