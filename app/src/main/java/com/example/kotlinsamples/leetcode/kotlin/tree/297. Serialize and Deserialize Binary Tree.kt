package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private class Codec {
    private val spliter = ","
    private val NN = "X"

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String? {
        val sb = StringBuilder()
        buildString(root, sb)
        return sb.toString()
    }

    private fun buildString(node: TreeNode?, sb: StringBuilder) {
        if (node == null) {
            sb.append(NN).append(spliter)
        } else {
            sb.append(node.`val`).append(spliter)
            buildString(node.left, sb)
            buildString(node.right, sb)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val nodes = ArrayDeque<String>()
        nodes.addAll(data.split(spliter))
        return buildTree(nodes)
    }

    private fun buildTree(nodes: Deque<String>): TreeNode? {
        val `val` = nodes.remove()
        if (`val` == NN) {
            return null
        } else {
            val node = TreeNode(Integer.valueOf(`val`))
            node.left = buildTree(nodes)
            node.right = buildTree(nodes)
            return node
        }
    }
}