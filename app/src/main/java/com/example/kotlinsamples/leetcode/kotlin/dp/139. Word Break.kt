package com.example.kotlinsamples.leetcode.kotlin.dp

//Recursion, time limit exceeded
private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    fun isWord(s: String, l: Int, dist: List<String>): Boolean {
        if (l == s.length) return true
        var l = l
        var k = 0
        while (l + k < s.length) {
            if (dist.contains(s.substring(l, l + k + 1)) && isWord(s, l + k + 1, dist)) {
                return true
            }
            k++
        }
        return false
    }
    return isWord(s, 0, wordDict)
}

//dp, top-down, recursive
private fun wordBreak2(s: String, wordDict: List<String>): Boolean {
    var set = wordDict.toSet()
    var dp = Array<Boolean?>(s.length + 1) { null }

    //
    fun isWord(idx: Int): Boolean {
        if (idx == s.length) return true
        var k = 0
        while (idx + k < s.length) {
            if (set.contains(s.substring(idx, idx + k + 1))) {
                if (dp[idx + k + 1] == null) dp[idx + k + 1] = isWord(idx + k + 1)
                if (dp[idx + k + 1]!!) return true
            }
            k++
        }
        return false
    }

    return isWord(s.length - 1)
}

//dp, bottom-up, recursive
//O(n^2)
// O(n)
private fun wordBreak3(s: String, wordDict: List<String>): Boolean {
    var set = wordDict.toSet()
    var dp = Array<Boolean?>(s.length + 1) { null }

    fun isWord(l: Int): Boolean {
        if (l == s.length) return true
        var k = 0
        while (l + k < s.length) {
            if (set.contains(s.substring(l, l + k + 1))) {
                if (dp[l + k + 1] == null) dp[l + k + 1] = isWord(l + k + 1)
                if (dp[l + k + 1]!!) return true
            }
            k++
        }
        return false
    }

    return isWord(0)
}