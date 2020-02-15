package com.example.kotlinsamples.leetcode.kotlin.tree.easy

import com.example.kotlinsamples.leetcode.kotlin.tree.TreeNode

private fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null && t == null) return true
        if (s == null || t == null) return false
        if (s.`val` != t.`val`) return false
        return isSame(s.left, t.left) && isSame(s.right, t.right)
    }

    if (s == null) return false
    if (isSame(s, t)) return true
    return isSubtree(s.left, t) || isSubtree(s.right, t)
}