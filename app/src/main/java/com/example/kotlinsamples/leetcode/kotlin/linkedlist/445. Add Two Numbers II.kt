package com.example.kotlinsamples.leetcode.kotlin.linkedlist

import java.util.*

// use existing input nodes
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var stack1 = ArrayDeque<ListNode>()
    var stack2 = ArrayDeque<ListNode>()
    var l1 = l1
    var l2 = l2
    while (l1 != null) {
        stack1.push(l1)
        l1 = l1.next
    }
    while (l2 != null) {
        stack2.push(l2)
        l2 = l2.next
    }
    var curr: ListNode? = null
    var carry = 0
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
        var n1 = if (!stack1.isEmpty()) stack1.pop() else null
        var n2 = if (!stack2.isEmpty()) stack2.pop() else null
        var node = n1 ?: n2
        var sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + carry
        node!!.`val` = sum % 10
        carry = sum / 10
        node.next = curr
        curr = node
    }
    if (carry != 0) {
        var node = ListNode(carry)
        node.next = curr
        curr = node
    }
    return curr
}

// don't use input nodes, create new ones
private fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    var stack1 = ArrayDeque<ListNode>()
    var stack2 = ArrayDeque<ListNode>()
    var l1 = l1
    var l2 = l2
    while (l1 != null) {
        stack1.push(l1)
        l1 = l1.next
    }
    while (l2 != null) {
        stack2.push(l2)
        l2 = l2.next
    }
    //iterate till both stack are not empty and adding sum to new nodes
    //At every iteration maintain quotient of earlier sum in first node and result in second node
    var resultNode = ListNode(0)
    var sum = 0 //maintains carry also
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
        sum += if (!stack1.isEmpty()) stack1.pop().`val` else 0
        sum += if (!stack2.isEmpty()) stack2.pop().`val` else 0
        resultNode.`val` = sum % 10
        var quotientNode = ListNode(sum / 10)
        quotientNode.next = resultNode
        resultNode = quotientNode
        sum /= 10 //consider carry
    }
    return if (resultNode.`val` == 0) resultNode.next else resultNode
}