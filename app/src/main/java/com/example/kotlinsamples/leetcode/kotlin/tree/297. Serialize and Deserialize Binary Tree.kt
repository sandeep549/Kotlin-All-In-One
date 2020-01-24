package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*


private class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String? {
        var str = StringBuilder()
        fun serialise(root: TreeNode?, str: StringBuilder): StringBuilder {
            if (root == null) str.append("N").append(",")
            str.append(root!!.`val`).append(",")
            serialise(root.left, str)
            serialise(root.right, str)
            return str
        }
        serialise(root, str)
        return str.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String?): TreeNode? {
        val nodes: Deque<String> = LinkedList()
        nodes.addAll(data!!.split(","))
        fun deserialise(nodes: Deque<String>): TreeNode? {
            var value = nodes.remove()
            if (value == "X") {
                return null
            } else {
                var node = TreeNode(value.toInt())
                node.left = deserialise(nodes)
                node.right = deserialise(nodes)
                return node
            }
        }
        return deserialise(nodes)
    }
}