package com.example.kotlinsamples.leetcode.kotlin.linkedlist

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var dummy = ListNode(-1)
    dummy.next = head
    var curr = head
    var prev = dummy
    while (curr != null) {
        if (curr.`val` == `val`) prev.next = curr.next
        else prev = curr
        curr = curr.next
    }
    return dummy.next
}