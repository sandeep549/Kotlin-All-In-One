package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList

// bfs
fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    var res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    var queue = ArrayDeque<TreeNode>() // for traversal
    var stack = ArrayDeque<MutableList<Int>>() // for result storing;
    queue.add(root)
    while (!queue.isEmpty()) {
        var size = queue.size
        var list = ArrayList<Int>()
        while (size > 0) {
            var n = queue.poll()
            n?.let { list.add(it.`val`) }
            n.left?.let { queue.add(it) }
            n.right?.let { queue.add(it) }
            size--
        }
        stack.push(list)
    }
    while (!stack.isEmpty()) res.add(stack.pop())
    return res
}

// dfs
fun levelOrderBottom2(root: TreeNode?): List<List<Int>> {
    var res = LinkedList<MutableList<Int>>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            if (level >= res.size) res.add(0, mutableListOf())
            dfs(it.left, level + 1)
            dfs(it.right, level + 1)
            res.get(res.size - level - 1).add(it.`val`)
        }
    }
    dfs(root, 0)
    return res
}

// dfs
fun levelOrderBottom3(root: TreeNode?): List<List<Int>> {
    var res = mutableListOf<MutableList<Int>>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            if (level >= res.size) res.add(level, mutableListOf())
            dfs(it.left, level + 1)
            dfs(it.right, level + 1)
            res.get(level).add(it.`val`)
        }
    }
    dfs(root, 0)
    return res.reversed()
}