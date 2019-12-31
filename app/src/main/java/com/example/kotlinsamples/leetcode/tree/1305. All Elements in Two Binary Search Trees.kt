package com.example.kotlinsamples.leetcode.tree

import java.util.*
import kotlin.collections.ArrayList

// Taken from
// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/464368/Short-O(n)-Python
// In Java also, time performance is almost O(n) when input is almost sorted, which is true in this case.
// Seems java also adopted Timsort for some special cases
private fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    fun collect(node: TreeNode?) {
        if (node != null) {
            collect(node.left)
            list.add(node.`val`)
            collect(node.right)
        }
    }
    collect(root1)
    collect(root2)
    list.sort()
    return list
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