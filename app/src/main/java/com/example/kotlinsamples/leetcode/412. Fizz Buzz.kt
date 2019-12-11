package com.example.kotlinsamples.leetcode

private fun fizzBuzz(n: Int): List<String> {
    var map = mapOf( // Order matters here, so under the hood LinkedHashMap
        3 to "Fizz",
        5 to "Buzz"
    )
    var ans = ArrayList<String>()
    for (i in 1..n) {
        var str = ""
        for ((k, v) in map.entries) {
            if (i % k == 0) str = str.plus(v)
        }
        if (str == "") str = i.toString()
        ans.add(str)
    }
    return ans
}

private fun fizzBuzz2(n: Int): List<String> {
    return (1..n).map {
        when {
            it % 15 == 0 -> "FizzBuzz"
            it % 5 == 0 -> "Buzz"
            it % 3 == 0 -> "Fizz"
            else -> it.toString()
        }
    }
}