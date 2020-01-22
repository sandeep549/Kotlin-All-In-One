package com.example.kotlinsamples.leetcode.kotlin.misc

fun countCharacters(words: Array<String>, chars: String): Int {
    val count = IntArray(26)
    chars.forEach { count[it - 'a']++ }
    var res = 0
    words.forEach loop@{
        val countClone = count.clone()
        it.forEach {
            if (--countClone[it - 'a'] < 0) return@loop
        }
        res += it.length
    }
    return res
}