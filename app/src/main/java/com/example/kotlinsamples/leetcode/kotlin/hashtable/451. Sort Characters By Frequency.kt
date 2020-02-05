package com.example.kotlinsamples.leetcode.kotlin.hashtable

import android.annotation.SuppressLint

//bucket sort
@SuppressLint("NewApi")
private fun frequencySort(s: String): String {
    val map = mutableMapOf<Char, Int>()
    for (c in s.toCharArray()) map[c] = map.getOrDefault(c, 0) + 1

    val bucket = Array<MutableList<Char>?>(s.length + 1) { null }
    for (key in map.keys) {
        map[key]?.let {
            if (bucket[it] == null) bucket[it] = ArrayList()
            bucket[it]?.add(key)
        }
    }

    val sb = StringBuilder()
    for (pos in bucket.indices.reversed()) {
        bucket[pos]?.let {
            for (c in it) {
                map[c]?.let { it ->
                    repeat(it.downTo(0).count()) { sb.append(c) }
                }
            }
        }
    }
    return sb.toString()
}

fun frequencySort2(s: String): String {
    return s.groupBy { it }
        .map { it.key to it.value.size }
        .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }.thenByDescending { it.first })
        .joinToString("") { it.first.toString().repeat(it.second) }
}