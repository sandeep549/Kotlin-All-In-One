package com.example.kotlinsamples.leetcode.kotlin.array.hard

import kotlin.random.Random

private class RandomizedCollection() {

    var list = mutableListOf<Int>()
    var map = mutableMapOf<Int, MutableSet<Int>>()

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.  */
    fun insert(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) map[`val`] = sortedSetOf()
        map[`val`]?.add(list.size)
        list.add(`val`)
        return map[`val`]?.size == 1
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.  */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`) || map[`val`]?.size == 0) return false
        val idx = map[`val`]?.iterator()?.next()
        map[`val`]?.remove(idx)
        val last = list[list.lastIndex]
        idx?.let {
            list[it] = last
            map[last]?.add(it)
            map[last]?.remove(list.lastIndex)
        }
        list.removeAt(list.lastIndex) //todo: removeAt() v/s remove()
        return true
    }

    /** Get a random element from the collection.  */
    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }

}
