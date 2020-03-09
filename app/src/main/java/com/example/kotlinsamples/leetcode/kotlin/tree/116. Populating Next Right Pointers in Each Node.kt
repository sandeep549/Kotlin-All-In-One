package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private class Node {
    var `val`: Int = 0
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

// need to verify this solution
private fun connect(root: Node?) {
    if (root == null) return
    var q = ArrayDeque<Node>()
    q.add(root)
    while (!q.isEmpty()) {
        var size = q.size
        while (size > 0) {
            var node = q.poll()
            if (size != 1) node.next = q.peek()
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
            size--
        }
    }
}

private fun connect2(root: Node?) {
    if (root == null) return
    if (root.left != null) {
        root.left!!.next = root.right
        if (root.next != null) root.right!!.next = root.next!!.left
    }
    connect(root.left)
    connect(root.right)
}

private fun connect3(root: Node?) {
    var level_start = root
    while (level_start != null) { // this loop will traverse from top-down on extreme left side of tree
        var cur = level_start
        while (cur != null) { // this will take us horizontally let to right on each level, handling each node's left and right pointer
            if (cur.left != null) cur.left!!.next = cur.right
            if (cur.right != null && cur.next != null) cur.right!!.next = cur.next!!.left
            cur = cur.next
        }
        level_start = level_start.left
    }
}