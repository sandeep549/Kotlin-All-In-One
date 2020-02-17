package com.example.kotlinsamples.leetcode.kotlin.tree.easy

import kotlin.math.abs

fun countNegatives(grid: Array<IntArray>): Int {
    var count = 0
    var r = grid.size - 1
    var c = grid[0].size - 1
    while (r >= 0 && c >= 0) {
        if (grid[r][c] >= 0) break
        var r1 = r
        while (r1 >= 0 && grid[r1][c] < 0) {
            count++
            r1--
        }
        var c1 = c
        while (c1 >= 0 && grid[r][c1] < 0) {
            count++
            c1--
        }
        count--
        r--
        c--
    }
    return count;
}

class ProductOfNumbers() {

    var product = mutableListOf<Double>()
    var zero = mutableListOf<Int>() //index of 0's

    init {
        product.add(1.toDouble())
    }

    fun add(num: Int) {
        if (num == 0) {
            zero.add(product.lastIndex + 1)
            product.add(product[product.lastIndex])
        } else {
            product.add(product[product.lastIndex] * num)
        }
    }

    fun getProduct(k: Int): Int {
        var start = product.size - k + 1
        if (zero[zero.lastIndex] >= start) return 0
        return (product[product.lastIndex] / product[product.lastIndex - k]).toInt()
    }

}

fun main() {
    abs()
}
