package com.example.kotlinsamples.leetcode


// iterative
private fun reverseList(head: ListNode): ListNode? {
    var oldhead: ListNode? = head
    var newhead: ListNode? = null
    while (oldhead != null) {
        var tmp = oldhead
        oldhead = oldhead.next
        tmp.next = newhead
        newhead = tmp
    }
    return newhead
}

// recursive implementation
private fun reverseList2(head: ListNode): ListNode? {
    return reverse(head, null)
}

private fun reverse(head: ListNode?, newhead: ListNode?): ListNode? {
    if (head == null) {
        return newhead
    }
    var next = head.next
    head.next = newhead
    return reverse(next, head)
}

fun reverseList4(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head;

    return reverseList4(head.next).apply {
        head.next!!.next = head;
        head.next = null;
    }
}