package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList

// Taken from
// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/464368/Short-O(n)-Python
// In Java also, time performance is almost O(n) when input is almost sorted, which is true in this case.
// Seems java also adopted Timsort for some special cases
private fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    fun dfs(root: TreeNode?) {
        root?.let {
            dfs(it.left)
            ans.add(it.`val`)
            dfs(it.right)
        }
    }
    dfs(root1)
    dfs(root2)
    ans.sort() // Timsort, almost O(n) performance
    return ans
}

private fun getAllElements2(root1: TreeNode?, root2: TreeNode?): List<Int> {
    var list1 = ArrayList<Int>()
    var list2 = ArrayList<Int>()
    fun collect(node: TreeNode?, list: ArrayList<Int>) {
        if (node != null) {
            collect(node.left, list)
            list.add(node.`val`)
            collect(node.right, list)
        }
    }
    collect(root1, list1)
    collect(root2, list2)
    var i = 0
    var j = 0
    var mergedList = ArrayList<Int>()
    while (i < list1.size && j < list2.size) {
        if (list1.get(i) <= list2.get(j)) {
            mergedList.add(list1.get(i++))
        } else {
            mergedList.add(list2.get(j++))
        }
    }
    while (i < list1.size) mergedList.add(list1.get(i++))
    while (j < list2.size) mergedList.add(list2.get(j++))
    return mergedList
}

private fun getAllElements3(root1: TreeNode?, root2: TreeNode?): List<Int> {
    fun collectIterative(root: TreeNode?): ArrayList<Int> {
        var list = ArrayList<Int>()
        var stack = Stack<TreeNode>()
        var curr = root
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            list.add(curr.`val`)
            curr = curr.right
        }
        return list
    }

    var list1 = collectIterative(root1)
    var list2 = collectIterative(root2)
    var i = 0
    var j = 0
    var mergedList = ArrayList<Int>()
    while (i < list1.size && j < list2.size) {
        if (list1.get(i) <= list2.get(j)) {
            mergedList.add(list1.get(i++))
        } else {
            mergedList.add(list2.get(j++))
        }
    }
    while (i < list1.size) mergedList.add(list1.get(i++))
    while (j < list2.size) mergedList.add(list2.get(j++))
    return mergedList
}

/**
 * Traverse iteratively both tree same time inroder, take smallest elment and add it to the list.
 * O(n)
 * O(n)
 */
private fun getAllElements4(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val stack1: ArrayDeque<TreeNode> = ArrayDeque()
    val stack2: ArrayDeque<TreeNode> = ArrayDeque()
    val output: MutableList<Int> = ArrayList()

    var root1 = root1
    var root2 = root2

    while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
        while (root1 != null) {
            stack1.push(root1)
            root1 = root1.left
        }
        while (root2 != null) {
            stack2.push(root2)
            root2 = root2.left
        }
        // Add the smallest value into output,
        // pop it from the stack,
        // and then do one step right
        if (stack2.isEmpty() || !stack1.isEmpty() && stack1.first.`val` <= stack2.first.`val`) {
            root1 = stack1.pop()
            output.add(root1.`val`)
            root1 = root1.right
        } else {
            root2 = stack2.pop()
            output.add(root2.`val`)
            root2 = root2.right
        }
    }
    return output
}