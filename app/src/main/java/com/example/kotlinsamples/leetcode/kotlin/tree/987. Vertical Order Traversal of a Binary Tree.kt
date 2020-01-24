package com.example.kotlinsamples.leetcode.kotlin.tree


class Point(var x: Int, var y: Int, var `val`: Int)

private fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    var mutableList = mutableListOf<Point>()
    fun dfs(root: TreeNode?, x: Int, y: Int) {
        root?.let {
            mutableList.add(Point(x, y, it.`val`))
            dfs(root.left, x - 1, y - 1)
            dfs(root.right, x + 1, y - 1)
        }
    }
    dfs(root, 0, 0)
    val listOfLists: MutableList<List<Int>> = mutableListOf()
    mutableList.groupBy { it.x }.toSortedMap().entries.forEach {
        var column = mutableListOf<Int>()
        it.value.sortedBy { it.`val` }.sortedByDescending { it.y }.forEach {
            column.add(it.`val`)
        }
        listOfLists.add(column)
    }
    return listOfLists
}

//todo: check top solution also in discuss
