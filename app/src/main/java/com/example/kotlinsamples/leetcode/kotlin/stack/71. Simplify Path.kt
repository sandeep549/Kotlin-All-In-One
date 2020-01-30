package com.example.kotlinsamples.leetcode.kotlin.stack

import java.util.*

private fun simplifyPath(path: String): String {
    val stack: Deque<String> = ArrayDeque()
    val skip = setOf("..", ".", "")
    for (dir in path.split("/").toTypedArray()) {
        println(dir)
        if (dir == ".." && !stack.isEmpty()) stack.pop()
        else if (!skip.contains(dir)) stack.push(dir)
    }
    var res = ""
    for (dir in stack) res = "/$dir$res"
    return if (res.isEmpty()) "/" else res
}

fun main() {
    println(simplifyPath("/a//b////c/d//././/.."))
}