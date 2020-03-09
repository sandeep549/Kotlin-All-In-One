package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

// use of global k is discouraged, so see next solution
private fun kthSmallest(root: TreeNode?, k: Int): Int {
    var k = k
    var ans = 0
    fun inorder(root: TreeNode?) {
        if (k == 0 || root == null) return
        inorder(root.left)
        if (--k == 0) ans = root.`val`
        inorder(root.right)
    }
    inorder(root)
    return ans
}

private fun kthSmallest2(root: TreeNode?, k: Int): Int {
    var ans = 0
    fun inorder(root: TreeNode?, cnt: Int): Int {
        if (cnt >= k || root == null) return cnt
        var c = inorder(root.left, cnt)
        if (++c == k) ans = root.`val`
        return inorder(root.right, c)
    }
    inorder(root, 0)
    return ans
}

private fun kthSmallest3(root: TreeNode, k: Int): Int {
    var k = k
    var stack = ArrayDeque<TreeNode>()
    var curr: TreeNode? = root
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        if (--k == 0) return curr.`val`
        curr = curr.right
    }
    return 0
}