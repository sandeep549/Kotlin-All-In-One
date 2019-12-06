package com.example.kotlinsamples.leetcode


fun numJewelsInStones(J: String, S: String): Int {
    val jewels = J.toSet()
    return S.filter { jewels.contains(it) }.length
}

fun numJewelsInStones2(J: String, S: String): Int {
    var set = J.toCharArray().toSet();
    var res = 0;
    for (s in S.toCharArray())
        if (set.contains(s)) res++
    return res
}