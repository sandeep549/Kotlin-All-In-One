package com.example.kotlinsamples.leetcode.kotlin.tree

private fun binaryTreePaths(root: TreeNode?): List<String> {
    fun dfs(root: TreeNode?): List<String> {
        root?.let {
            if (it.left == null && it.right == null) return mutableListOf("" + it.`val`)
            var l = dfs(it.left).map { "" + root.`val` + "->" + it }
            var r = dfs(it.right).map { "" + root.`val` + "->" + it }
            return l + r
        }
        return listOf()
    }
    return dfs(root)
}

private fun binaryTreePaths2(root: TreeNode?): List<String>? {
    val answer = arrayListOf<String>()
    fun dfs(root: TreeNode?, path: String, answer: MutableList<String>) {
        if (root!!.left == null && root.right == null) answer.add(path + root.`val`)
        root.left?.let { dfs(it, path + root.`val` + "->", answer) }
        root.right?.let { dfs(it, path + root.`val` + "->", answer) }
    }
    root?.let { dfs(it, "", answer) }
    return answer
}

fun binaryTreePaths3(root: TreeNode?): List<String> {
    if (root == null) return emptyList()
    if (root.left == null && root.right == null) return listOf(root.`val`.toString())
    val left = binaryTreePaths(root.left)
    val right = binaryTreePaths(root.right)
    return (left + right).map { root.`val`.toString() + "->" + it }
}

fun binaryTreePaths4(root: TreeNode?): List<String> {
    return when {
        root == null -> emptyList()
        root.left == null && root.right == null -> listOf(root.`val`.toString())
        else -> (binaryTreePaths(root.left) + binaryTreePaths(root.right)).map { root.`val`.toString() + "->" + it }
    }
}

//TODO: do it with iteration
//TODO: calculate exact time complexity