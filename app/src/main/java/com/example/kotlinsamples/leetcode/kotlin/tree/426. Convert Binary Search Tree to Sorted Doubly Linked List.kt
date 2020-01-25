package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private fun treeToDoublyList(root: TreeNode?): TreeNode? {
    if (root == null) return null
    var dummy = TreeNode(-1)
    var pre = dummy
    fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        pre.right = root
        root.left = pre
        pre = root
        inorder(root.right)
    }
    inorder(root)
    pre.right = dummy.right
    dummy.right!!.left = pre
    return dummy.right
}

private fun treeToDoublyList2(root: TreeNode?): TreeNode? {
    if (root == null) return null
    var dummy = TreeNode(-1)
    var pre = dummy
    var curr = root
    var stack: Deque<TreeNode> = LinkedList()
    fun connect(a: TreeNode, b: TreeNode) {
        a.right = b
        b.left = a
    }
    while (curr != null || !stack.isEmpty()) {
        if (curr != null) {
            stack.push(curr)
            curr = curr.left
        } else {
            curr = stack.pop()
            connect(pre, curr)
            pre = curr
            curr = curr.right
        }
    }
    var head = dummy.right
    connect(pre, head!!)
    return head
}