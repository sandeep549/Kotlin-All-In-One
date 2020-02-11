package com.example.kotlinsamples.leetcode.kotlin.array.medium

import kotlin.random.Random


private class RandomizedSet() {

    /** Initialize your data structure here. */
    private var map = mutableMapOf<Int, Int>()
    private var list = mutableListOf<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) return false
        map.put(`val`, list.size)
        list.add(list.size, `val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) return false
        var idx = map.get(`val`)
        idx?.let { list[it] = list[list.lastIndex] }
        map.put(list[idx!!], idx!!)

        list.removeAt(list.lastIndex)
        map.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return list.get(Random.nextInt(list.size))
    }

}