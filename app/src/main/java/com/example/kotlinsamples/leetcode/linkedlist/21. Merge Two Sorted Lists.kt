package com.example.kotlinsamples.leetcode.linkedlist

fun main() {
    println(mergeTwoList("[1,2,4]".toLinkedList(), "[1,3,4]".toLinkedList()).toString())
    println(mergeTwoList("[1,3,5]".toLinkedList(), "[2,4,6,8]".toLinkedList()).toString())
    println(mergeTwoList2("[1,3,5,7]".toLinkedList(), "[2,4]".toLinkedList()).toString())
    println(mergeTwoList("[]".toLinkedList(), "[2,4]".toLinkedList()).toString())
}

private fun mergeTwoList(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(-1)
    var first: ListNode? = l1
    var second: ListNode? = l2
    var curr: ListNode = dummy
    while (first != null && second != null) {
        curr.next = if (first.`val` < second.`val`) {
            val tmp = first
            first = first.next
            tmp
        } else {
            val tmp = second
            second = second.next
            tmp
        }
        curr = curr.next!!
    }
    curr.next = first ?: second
    return dummy.next
}

private fun mergeTwoList2(l1: ListNode?, l2: ListNode?): ListNode? {
    return when {
        l1 == null -> l2
        l2 == null -> l1
        l1.`val` <= l2.`val` -> {
            l1.next = mergeTwoList2(l1.next, l2)
            l1
        }
        else -> {
            l2.next = mergeTwoList2(l1, l2.next)
            l2
        }
    }
}