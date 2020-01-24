package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.math.abs

/**
 * Traverse the tree in inorder, store result in array, then find closet value searching sorted array
 */
private fun closestValue(root: TreeNode?, target: Double): Int {
    var list = mutableListOf<Int>()
    fun dfs(root: TreeNode?) {
        root?.let {
            dfs(it.left)
            list.add(it.`val`)
            dfs(it.right)
        }
    }
    dfs(root) //store in array

    //find closest in sorted array
    var diff = Double.MAX_VALUE
    var ans = 0
    list.forEach {
        if (abs(it.toDouble() - target) < diff) {
            diff = abs(it.toDouble() - target)
            ans = it
        }
    }

    return ans
}

/**
 * Iterative; Traverse BST in inorder using iterative approach, keep track of min diff so far and element of it.
 * Loop will terminate if we encountered just bigger element or tree is fully traversed.
 * If we found just bigger element than target, that means we have calculated our closed element
 * till now, break the loop.
 */
private fun closestValue2(root: TreeNode?, target: Double): Int {
    var stack = ArrayDeque<TreeNode>()
    var curr = root //to iterate
    var diff = Double.MAX_VALUE //to track min diff
    var ans = root?.`val` ?: 0 // to track element with min diff
    stack.push(curr)
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        if (Math.abs(curr!!.`val` - target) < diff) {
            ans = curr.`val`
            diff = Math.abs(curr.`val` - target)
        }
        if (curr.`val` > target) break
        curr = curr.right
    }
    return ans
}

/**
 * Explanation for solution:
 * To find closet value, we need max-lower-value and min-upper-value available in BST for the target.
 * If we search BST for given target using binary search approach, at every node we cut down the input space
 * by setting either a new lower/upper bound for target.
 * If target is less than node, then we set new upper bound, otherwise new lower bound. This way we go till leaf
 * node and both bound would have come max possible close to each other.
 * As we are calculating closet every time, we will get closet of either of them at the end.
 */
private fun closestValue3(root: TreeNode?, target: Double): Int {
    var root = root
    var ret = root?.`val` ?: 0
    while (root != null) {
        if (Math.abs(target - root.`val`) < Math.abs(target - ret)) {
            ret = root.`val`
        }
        root = if (root.`val` > target) root.left else root.right
    }
    return ret
}