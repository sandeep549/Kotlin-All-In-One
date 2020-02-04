package com.example.kotlinsamples.leetcode.kotlin.design

import java.util.*

private class MinStack() {

    /** initialize your data structure here. */
    var stack = ArrayDeque<Int>()
    var minstack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (!minstack.isEmpty()) {
            minstack.push(minOf(minstack.peek(), x))
        } else {
            minstack.push(x)
        }
    }

    fun pop() {
        stack.pop()
        minstack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minstack.peek()
    }

}

private class MinStack2 {
    private class Element(val value: Int, val min: Int)

    private var stack = ArrayDeque<Element>()
    fun push(x: Int) {
        val min = if (stack.isEmpty()) x else Math.min(stack.peek().min, x)
        stack.push(Element(x, min))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().min
    }
}