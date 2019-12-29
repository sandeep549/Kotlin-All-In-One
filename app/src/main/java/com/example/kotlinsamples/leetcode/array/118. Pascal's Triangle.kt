package com.example.kotlinsamples.leetcode.array

private fun generate(numRows: Int): List<List<Int>> {
    val list = ArrayList<List<Int>>()
    for (row in 1..numRows) {
        val currrow = ArrayList<Int>()
        for (item in 1..row) {
            if (item == 1 || item == row) {
                currrow.add(1)
            } else {
                currrow.add(list.get(row - 2).get(item - 2) + list.get(row - 2).get(item - 1))
            }
        }
        list.add(currrow)
    }
    return list
}