package com.example.kotlinsamples.leetcode.kotlin.tree

/**
 * Binary tree node
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * N-ary tree node
 */
class NTreeNode(var `val`: Int) {
    var children: ArrayList<NTreeNode>? = null
}