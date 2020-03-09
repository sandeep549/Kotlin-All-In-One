package com.example.kotlinsamples.leetcode.kotlin.tree

/**
 * Binary tree node
 */
class TreeNode(var `val`: Int) {
    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.left = left
        this.right = right
    }

    // only to be used in special cases when asked,otherwise not available
    var parent: TreeNode? = null
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * N-ary tree node
 */
class NTreeNode(var `val`: Int) {
    constructor(`val`: Int, children: ArrayList<NTreeNode>?) : this(`val`) {
        this.children = children
    }

    var children: ArrayList<NTreeNode>? = null
}