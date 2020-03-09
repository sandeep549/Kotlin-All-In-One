package com.example.kotlinsamples.leetcode.kotlin.tree

import android.annotation.SuppressLint
import java.util.*
import kotlin.collections.ArrayList

/**
 * Traverse the tree and maintain hashmap of all elements with their frequencies.
 * Return element with highest frequency from map.
 * O(n), n is no of nodes in tree
 * O(n)
 */
@SuppressLint("NewApi")
private fun findMode(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    var map = hashMapOf<Int, Int>() // HashMap<Int, Int>()
    fun dfs(root: TreeNode?) {
        root?.let {
            map.put(it.`val`, map.getOrDefault(it.`val`, 0) + 1)
            dfs(it.left)
            dfs(it.right)
        }
    }
    dfs(root)
    var maxValue = map.maxBy { it.value }!!.value
    var maxEntries = map.filterValues { it == maxValue }
    return maxEntries.keys.toIntArray()
}

/**
 * Traverse tree in inorder, have a feel like traversing an increasing array, mark down the max frequency found so far
 * and their elements in a list.
 * Single traversal
 * O(n)
 * O(1); if we do not consider recursion stack space and output data structure to hols result to return, O(n) otherwise
 */
private fun findMode2(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    var last: Int? = null
    var frequency = 0
    var max_so_far = 0
    var ans = ArrayList<Int>()
    fun checkValue(curr: Int) {
        if (last == null || curr == last) {
            frequency++
            if (frequency == max_so_far) {
                ans.add(curr)
            } else if (frequency > max_so_far) {
                ans.clear()
                ans.add(curr)
            }
            last = curr // for first element
            max_so_far = max_so_far.coerceAtLeast(frequency)
        } else {
            last = curr
            frequency = 1
            if (max_so_far == frequency) ans.add(curr)
        }
    }

    fun dfs(root: TreeNode?) {
        root?.let {
            dfs(it.left)
            checkValue(it.`val`)
            dfs(it.right)
        }
    }
    dfs(root)
    return ans.toIntArray()
}

/**
 * Same as above but iterative solution
 */
private fun findMode3(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    var last: Int? = null
    var frequency = 0
    var max_so_far = 0
    var ans = ArrayList<Int>()
    fun checkValue(curr: Int) {
        if (last == null || curr == last) {
            frequency++
            if (frequency == max_so_far) {
                ans.add(curr)
            } else if (frequency > max_so_far) {
                ans.clear()
                ans.add(curr)
            }
            last = curr // for first element
            max_so_far = max_so_far.coerceAtLeast(frequency)
        } else {
            last = curr
            frequency = 1
            if (max_so_far == frequency) ans.add(curr)
        }
    }

    var stack = ArrayDeque<TreeNode>()
    var curr = root
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        checkValue(curr.`val`)
        curr = curr.right
    }
    return ans.toIntArray()
}
