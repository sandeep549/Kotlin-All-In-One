package com.example.kotlinsamples.leetcode.kotlin.tree

fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    var seen = mutableSetOf<Int>()
    var ans = true
    fun dfs(node: Int) {
        var left = leftChild[node]
        if (left != -1) {
            if (seen.contains(left)) ans = false
            else {
                seen.add(left)
                leftChild[node] = -1
                dfs(left)
            }
        }
        var right = rightChild[node]
        if (right != -1) {
            if (seen.contains(right)) ans = false
            else {
                seen.add(right)
                rightChild[node] = -1
                dfs(right)
            }
        }
    }
    seen.add(0)
    dfs(0)
    if (!ans) return false
    for (i in leftChild) if (i != -1) return false
    for (i in rightChild) if (i != -1) return false
    return true
}