package com.example.kotlinsamples.leetcode.kotlin.hashtable

fun main() {
    println(findAnagrams2("cbaebabacd", "abc"))
    println(findAnagrams2("abab", "ab"))
}

// brute force
private fun findAnagrams(s: String, p: String): List<Int> {
    var frequencyMap = p.toCharArray().groupBy { it }.mapValues { it.value.size }
    fun isAnagram(start: Int): Boolean {
        var map = frequencyMap.toMutableMap()
        for (i in start until start + p.length) {
            if (map.containsKey(s[i])) {
                map[s[i]] = map[s[i]]!! - 1
                if (map[s[i]] == 0) map.remove(s[i])
            } else {
                return false
            }
        }
        return true
    }

    var anslist = mutableListOf<Int>()
    for (i in 0 until s.length - p.length + 1) {
        if (isAnagram(i)) anslist.add(i)
    }
    return anslist
}

// sliding window
private fun findAnagrams2(s: String?, p: String?): List<Int> {
    if (p == null || s == null) return emptyList()

    val list = mutableListOf<Int>()
    var frequencyMap = p.toCharArray().groupBy { it }.mapValues { it.value.size }.toMutableMap()

    // two points, initialize count to p's length
    var left = 0
    var right = 0
    var matches = p.length
    while (right < s.length) {
        var value = frequencyMap.get(s[right])
        value?.let {
            if (it >= 1) matches--
            frequencyMap.put(s[right], it - 1)
        }
        right++

        if (matches == 0) list.add(left)

        if (right - left == p.length) {
            var value = frequencyMap.get(s[left])
            value?.let {
                if (it >= 0) matches++
                frequencyMap.put(s[left], value + 1)
            }
            left++
        }
    }
    return list
}

fun findAnagrams3(txt: String, pat: String): List<Int> {
    val ans = mutableListOf<Int>()
    if (txt.length < pat.length) return ans
    val P = IntArray(256)
    val T = IntArray(256)
    for (i in pat.indices) {
        P[pat[i].toInt()]++
        T[txt[i].toInt()]++
    }
    for (i in pat.length until txt.length) {
        if (isEqual(T, P)) ans.add(i - pat.length)
        T[txt[i].toInt()]++
        T[txt[i - pat.length].toInt()]--
    }
    if (isEqual(T, P)) ans.add(txt.length - pat.length)
    return ans
}

// O(1) function, as hash size does not increase with input size
private fun isEqual(hash1: IntArray, hash2: IntArray): Boolean {
    for (i in hash1.indices) {
        if (hash1[i] != hash2[i]) return false
    }
    return true
}