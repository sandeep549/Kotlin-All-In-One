package com.example.kotlinsamples.leetcode.kotlin.linkedlist

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var ans = l1 ?: l2
    var l1 = l1
    var l2 = l2
    var p1: ListNode? = null
    var p2: ListNode? = null
    var carry = 0
    while (l1 != null && l2 != null) {
        var sum = l1.`val` + l2.`val` + carry
        l1.`val` = sum % 10
        carry = sum / 10
        p1 = l1
        p2 = l2
        l1 = l1.next
        l2 = l2.next
    }
    if (l1 == null && l2 == null && carry != 0) {
        var n = ListNode(0)
        p1!!.next = n
        l1 = p1.next
    } else if (l1 == null && l2 != null) {
        if (p1 != null) p1.next = l2
        l1 = l2
    }
    while (l1 != null && carry != 0) {
        var sum = l1.`val` + carry
        l1.`val` = sum % 10
        carry = sum / 10
        p1 = l1
        l1 = l1.next
    }
    if (l1 == null && carry != 0) {
        var n = ListNode(carry)
        p1!!.next = n
    }
    return ans
}

private fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    var dummy = ListNode(0)
    var cur = dummy
    var l1 = l1
    var l2 = l2
    var carry = 0
    while (l1 != null || l2 != null) {
        var sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        var node = l1 ?: l2
        node!!.`val` = sum % 10
        carry = sum / 10
        cur.next = node
        cur = cur.next!!
        l1 = l1?.next
        l2 = l2?.next
    }
    if (carry != 0) cur!!.next = ListNode(carry)
    return dummy.next
}
