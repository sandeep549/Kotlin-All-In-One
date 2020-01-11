package com.example.kotlinsamples.leetcode.kotlin.linkedlist


// iterative
private fun reverseList(head: ListNode?): ListNode? {
    var hd: ListNode? = head
    var first: ListNode? = null
    while (hd != null) {
        var next = hd.next
        hd.next = first
        first = hd
        hd = next
    }
    return first
}

// recursive implementation
private fun reverseList2(head: ListNode?): ListNode? {
    fun recur(curr: ListNode?, hd: ListNode?): ListNode? {
        if (hd == null) return curr
        var next = hd.next
        hd.next = curr
        return recur(hd, next)
    }
    return recur(null, head)
}