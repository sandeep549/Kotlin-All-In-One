package com.example.kotlinsamples.leetcode.kotlin.dp

// Time complexity looks O(n^2) here
// In worst case if all prefix exists in dict. then outer loop is O(n),
// and further O(n) for nested call to same function.
// 3rd nested list iteration will not run if last prefix doesn't match.
private fun wordBreak(s: String, wordDict: List<String>): List<String> {
    var dp: Array<Pair<Boolean, MutableList<String>>?> = Array(s.length + 1) { null }

    fun wordList(s: String, start: Int, dict: Set<String>): Pair<Boolean, MutableList<String>> {
        if (start == s.length) return Pair(true, mutableListOf()) // base case
        var res = mutableListOf<String>()
        var isSegHere = false
        var end = start + 1
        while (end <= s.length) {
            var word = s.substring(start, end)
            if (dict.contains(word)) {
                if (dp[end] == null) dp[end] = wordList(s, end, dict)
                var p = dp[end]
                p?.let {
                    if (p.first) { // right side is segmented only
                        isSegHere = true
                        p.second.forEach { res.add("$word $it") }
                        if (p.second.isEmpty()) res.add(word) // handle backtrack from base case
                    }
                }
            }
            end++
        }
        return Pair(isSegHere, res)
    }

    var pair = wordList(s, 0, wordDict.toSet())
    return if (pair.first) pair.second else emptyList()
}

// note: what if disct size is too big here
private fun wordBreak2(s: String, wordDict: List<String>): List<String>? {
    fun dfs(s: String, wordDict: Set<String>, map: HashMap<String?, MutableList<String>?>): List<String> {
        if (map.containsKey(s)) return map[s]!!
        val res = mutableListOf<String>()
        if (s.isEmpty()) {
            res.add("")
            return res
        }
        for (word in wordDict) {
            if (s.startsWith(word)) {
                val sublist = dfs(s.substring(word.length), wordDict, map)
                for (sub in sublist) res.add(word + (if (sub.isEmpty()) "" else " ") + sub)
            }
        }
        map[s] = res
        return res
    }
    return dfs(s, wordDict.toSet(), HashMap())
}
