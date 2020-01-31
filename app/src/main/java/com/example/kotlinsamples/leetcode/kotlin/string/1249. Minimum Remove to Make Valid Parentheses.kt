package com.example.kotlinsamples.leetcode.kotlin.string

import java.util.*

private fun minRemoveToMakeValid(s: String): String {
    var ans = StringBuilder()
    var stack = ArrayDeque<Pair<Char, Int>>() //stack will contain only braces
    var i = 0

    //loop will handle invalid closing bracket with stack
    while (i < s.length) {
        var c = s[i++]
        if (c == ')') {
            if (!stack.isEmpty() && stack.peek().first == '(') {
                stack.pop()
                ans.append(c)
            }
        } else if (c == '(') {
            stack.push(Pair('(', ans.length))
            ans.append(c)
        } else {
            ans.append(c)
        }
    }

    //at last, stack will be either empty or will contain invalid open braces
    while (!stack.isEmpty()) {
        ans.deleteCharAt(stack.peek().second)
        stack.pop()
    }
    return ans.toString()
}

fun minRemoveToMakeValid2(s: String): String {
    val sb = StringBuilder(s)
    val st = ArrayDeque<Int>()
    for (i in sb.indices) {
        if (sb[i] == '(') st.add(i)
        if (sb[i] == ')') {
            if (!st.isEmpty()) st.pop() else sb.setCharAt(i, '*')
        }
    }
    while (!st.isEmpty()) sb.setCharAt(st.pop(), '*')
    return sb.toString().replace("\\*".toRegex(), "")
}

fun main() {
    println(minRemoveToMakeValid("lee(t(c)o)de)"))
    println(minRemoveToMakeValid("a)b(c)d"))
    println(minRemoveToMakeValid("))(("))
}