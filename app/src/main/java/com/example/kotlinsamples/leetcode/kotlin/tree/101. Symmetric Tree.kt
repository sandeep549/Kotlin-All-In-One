package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private fun isSymmetric(root: TreeNode?): Boolean {
    fun isMirror(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true
        if (n1 == null || n2 == null) return false
        return (n1.`val` == n2.`val`) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left)
    }
    return isMirror(root, root)
}

private fun isSymmetric2(root: TreeNode?): Boolean {
    if (root == null) return true
    fun bothNull(n1: TreeNode?, n2: TreeNode?) = (n1 == null && n2 == null)
    fun eitherNull(n1: TreeNode?, n2: TreeNode?) = (n1 == null || n2 == null)
    var queue = ArrayDeque<TreeNode?>()
    queue.add(root)
    queue.add(root)
    while (!queue.isEmpty()) {
        var n1 = queue.poll()
        var n2 = queue.poll()

        if (n1!!.`val` != n2!!.`val`) return false

        if (bothNull(n1.left, n2.right)) continue //note: ArrayDeque do not allow null
        if (eitherNull(n1.left, n2.right)) return false
        queue.offer(n1.left)
        queue.offer(n2.right)

        if (bothNull(n1.right, n2.left)) continue
        if (eitherNull(n1.right, n2.left)) return false
        queue.offer(n1.right)
        queue.offer(n2.left)
    }
    return true
}

private fun isSymmetric3(root: TreeNode?): Boolean {
    if (root == null) return true
    var queue = LinkedList<TreeNode?>()
    queue.add(root)
    queue.add(root)
    while (!queue.isEmpty()) {
        var n1 = queue.poll()
        var n2 = queue.poll()

        if ((n1 == null && n2 == null)) return continue
        if (n1 == null || n2 == null) return false
        if (n1!!.`val` != n2!!.`val`) return false

        queue.offer(n1.left) //LinkedList allows null
        queue.offer(n2.right)

        queue.offer(n1.right)
        queue.offer(n2.left)
    }
    return true
}

