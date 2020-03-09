package com.example.kotlinsamples.leetcode.kotlin.string

import java.lang.StringBuilder

/**
 * 1. Make frequency map of chars.
 * 2. Take last two char of max frequency and append them, take max frequency one as first one always
 * 3. modify used frequencies in list, and sort again according to frequencies
 * 4. Repeat 2, 3 until list size is 1; check base case at size 1 and return answer.
 */
private fun reorganizeString(S: String): String {
    var entries =
        S.toCharArray()
            .groupBy { it }.mapValues { it.value.size }.toList()
            .sortedBy { it.second }
            .toMutableList()
    println(entries.toString())
    var ans = StringBuilder()
    while (entries.size > 0) {
        println("---size is " + entries.size)
        if (entries.size == 1 && entries.get(0).second >= 2) {
            println("size is 1")
            return ""
        }
        if (entries.size == 1) {
            ans.append(entries[0].first)
            break
        }
        var last = entries.size - 1
        var limit = minOf(entries[last].second, entries[last - 1].second)
        var c1 = entries[last].first
        var c2 = entries[last - 1].first

        while (limit > 0) {
            ans.append(c1).append(c2)
            limit--
        }
        if (entries[last].second == entries[last - 1].second) {
            entries.removeAt(last)
            entries.removeAt(last - 1)
        } else if (entries[last - 1].second < entries[last].second) {
            var pair = kotlin.Pair<Char, Int>(
                entries[last].first,
                entries[last].second - entries[last - 1].second
            )
            entries.removeAt(last)
            entries.removeAt(last - 1)
            entries.add(pair)
            entries.sortBy { it.second }
        } else {
            var pair = kotlin.Pair<Char, Int>(
                entries[last - 1].first,
                entries[last - 1].second - entries[last].second
            )
            entries.removeAt(last)
            entries.removeAt(last - 1)
            entries.add(pair)
            entries.sortBy { it.second }
        }
    }
    return ans.toString()
}

fun main() {
    // println(reorganizeString("aab"))
    println(reorganizeString2("aaab"))
}

private fun reorganizeString2(S: String): String {
    var arr = S.toCharArray()
    var hash = IntArray(26)
    for (c in arr) hash[c - 'a']++
    var max = hash[0]
    var letter = 0
    for (i in 0 until 26) {
        if (hash[i] > max) {
            max = hash[i]
            letter = i
        }
    }
    if (max > (arr.size + 1) / 2) return ""

    var ans = CharArray(arr.size)
    var idx = 0
    while (hash[letter] > 0) {
        ans[idx] = 'a' + letter
        idx += 2
        hash[letter]--
    }
    for (i in 0 until 26) {
        while (hash[i] > 0) {
            if (idx >= arr.size) idx = 1
            ans[idx] = 'a' + i
            idx += 2
            hash[i]--
        }
    }
    return String(ans)
}