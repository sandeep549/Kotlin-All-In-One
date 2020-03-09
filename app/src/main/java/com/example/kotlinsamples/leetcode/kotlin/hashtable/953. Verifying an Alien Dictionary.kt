package com.example.kotlinsamples.leetcode.kotlin.hashtable

fun main() {
    println()
}

private fun isAlienSorted(words: Array<String>, order: String): Boolean {
    var i = 0
    var map = HashMap<Char, Int>()
    for (c in order.toCharArray()) map.put(c, i++)

    fun compareTo(word1: String, word2: String): Int {
        val len1: Int = word1.length
        val len2: Int = word2.length
        val lim = Math.min(len1, len2)
        val v1: CharArray = word1.toCharArray()
        val v2: CharArray = word2.toCharArray()
        var k = 0
        while (k < lim) {
            val c1 = map.get(v1[k])!!
            val c2 = map.get(v2[k])!!
            if (c1 != c2) {
                return c1 - c2
            }
            k++
        }
        return len1 - len2
    }

    for (i in 1..words.lastIndex) {
        if (compareTo(words[i - 1], words[i]) > 0) return false
    }
    return true
}
