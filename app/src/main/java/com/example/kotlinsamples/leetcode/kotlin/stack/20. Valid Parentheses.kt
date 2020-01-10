package com.example.kotlinsamples.leetcode.kotlin.stack

import java.util.*

fun main() {
    println(isValid("(){}[]"))
    println(isValid("(}"))
}

private fun isValid(s: String): Boolean {
    var map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
    var stack = ArrayDeque<Char>()
    for (c in s.toCharArray()) {
        if (map.containsKey(c)) stack.push(c)
        else if (map.containsKey(stack.peek()) && map.get(stack.peek()) == c) stack.pop()
        else return false
    }
    return stack.isEmpty()
}

private fun isValid2(s: String): Boolean {
    var map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
    var stack = ArrayDeque<Char>()
    for (c in s.toCharArray()) {
        if (map.containsKey(c)) stack.push(map.get(c))
        else if (stack.isEmpty() || stack.pop() != c) return false
    }
    return stack.isEmpty()
}
