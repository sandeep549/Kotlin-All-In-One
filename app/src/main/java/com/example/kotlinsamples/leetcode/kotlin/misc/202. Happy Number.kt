package com.example.kotlinsamples.leetcode.kotlin.misc

fun main() {
    var x = 789
    println(x.toString().split("").filter { it != "" }.map { it.toInt() * it.toInt() }.sum())
}

private fun isHappy(n: Int): Boolean {
    var slow = n
    var fast = n
    do {
        slow = next(slow)
        fast = next(
            next(fast)
        )
    } while (slow != fast)
    return if (slow == 1) true else false
}

private fun next(n: Int): Int {
    var s = 0
    var num = n
    while (num != 0) {
        var i = num % 10
        s += (i * i)
        num /= 10
    }
    return s
}

private fun isHappy2(n: Int): Boolean {
    val set = HashSet<Int>()
    set.add(n)
    var x = n
    while (true) {
        x = next2(x)
        if (x == 1) {
            return true
        }
        if (set.contains(x)) {
            return false
        }
        set.add(x)
    }
}

private fun isHappy3(n: Int): Boolean {
    var slow = n
    var fast = n
    do {
        slow = next2(slow)
        fast = next2(
            next2(fast)
        )
    } while (slow != fast)
    return if (slow == 1) true else false
}

private inline fun next2(n: Int): Int {
    return n.toString().split("").filter { it != "" }.map { it.toInt() * it.toInt() }.sum()
}