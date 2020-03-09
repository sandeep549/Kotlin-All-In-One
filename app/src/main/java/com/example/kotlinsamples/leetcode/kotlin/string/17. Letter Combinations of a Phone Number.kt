package com.example.kotlinsamples.leetcode.kotlin.string

private fun letterCombinations(digits: String): List<String> {
    var map = mapOf(
        2 to listOf('a', 'b', 'c'),
        3 to listOf('d', 'e', 'f'),
        4 to listOf('g', 'h', 'i'),
        5 to listOf('j', 'k', 'l'),
        6 to listOf('m', 'n', 'o'),
        7 to listOf('p', 'q', 'r', 's'),
        8 to listOf('t', 'u', 'v'),
        9 to listOf('w', 'x', 'y', 'z')
    )

    var res = mutableListOf<String>()
    fun dfs(idx: Int, str: StringBuilder) {
        if (idx == digits.length) {
            res.add(str.toString())
            return
        }
        var str = str
        var value = digits[idx].toString().toInt()
        for (ch in map.getValue(value)) dfs(idx + 1, StringBuilder(str).append(ch))
    }
    if (digits.isNotEmpty()) dfs(0, StringBuilder())
    return res
}

// todo: try iterative solution