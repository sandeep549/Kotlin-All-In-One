package com.example.kotlinsamples.leetcode.linkedlist

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a = headA
    var b = headA
    // loop stops in second iteration
    while (a != b) {
        // at the end of first iteration reset pointer to the end of another list
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
    }
    return a // if we meet at null, means no intersection point at all
}