package com.example.kotlinsamples.leetcode.advanceds

// https://en.wikipedia.org/wiki/Disjoint-set_data_structure
// https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/

/**
 * Problem Statement: We have some number of items. We are allowed to merge any two items to consider them equal.
 * At any point we should be able to answer whether two items are equal or not ?
 */

private class DisjointSet {
    private var parent = mutableMapOf<Int, Int>()
    private var rank = mutableMapOf<Int, Int>()

    // perform MakeSet operation
    fun makeSet(x: Int) {
        parent.put(x, x) // create new disjoint set point to itself
        rank.put(x, 0)
    }

    // find root/representative of disjoint set to which x belongs
    fun find(x: Int): Int {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)!!)) // path compression
        }
        return parent.get(x)!!
    }

    // perform union of two disjoint sets
    fun union(x: Int, y: Int) {
        var a = find(x)
        var b = find(y)
        if (a == b) return // if already in same set

        // perform union by rank
        // attach smaller depth tree under the root of deeper tree
        if (rank.get(x)!! < rank.get(y)!!)
            parent.put(y, x)
        else if (rank.get(x)!! > rank.get(y)!!)
            parent.put(x, y)
        else {
            parent.put(x, y)
            rank.put(y, rank.get(y)!! + 1)
        }
    }

    // helper function to print all disjoints sets, i.e. print all representatives
    fun printDisjointSets() {
        parent.forEach {
            if (it.key == it.value) print(it.key)
        }
        println()
    }
}

fun main() {
    var dj = DisjointSet()
    dj.makeSet(1)
    dj.makeSet(2)
    dj.makeSet(3)
    dj.makeSet(4)
    dj.makeSet(5)
    dj.printDisjointSets()
    dj.union(1, 2)
    dj.printDisjointSets()
    dj.union(2, 3)
    dj.printDisjointSets()
    dj.union(4, 5)
    dj.printDisjointSets()

    // is 1 and 3 are equal(or friends), yes as belong to same disjoint set
    println(dj.find(1) == dj.find(3))
}