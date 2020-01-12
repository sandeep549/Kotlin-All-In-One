package com.example.kotlinsamples.leetcode.kotlin

import com.example.kotlinsamples.leetcode.kotlin.linkedlist.ListNode


// Solution-1
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null || head.next == null) return true
    var slow: ListNode? = head
    var fast: ListNode? = head
    while (fast != null && fast.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    if (fast != null) {
        slow = slow!!.next
    }
    fast = reverse(slow)
    slow = head
    while (fast != null) {
        if (fast.`val` != slow!!.`val`) return false
        fast = fast.next
        slow = slow.next
    }
    return true
}

private fun reverse(head: ListNode?): ListNode? {
    if (head == null) return null
    var newhead: ListNode? = null
    var currhead: ListNode? = head
    while (currhead != null) {
        var next = currhead.next
        currhead.next = newhead
        newhead = currhead
        currhead = next
    }
    return newhead
}

// Solution-2, tough needs more verification on edge cases to check
//TODO verify it
private fun isPalindrome2(head: ListNode?): Boolean {
    var sum = 0
    var mul = -1
    var curr = head
    while (curr != null) {
        sum += (2.shl(++mul)) * curr.`val`
        curr = curr!!.next
    }
    curr = head
    while (curr != null) {
        sum -= (2.shl(mul--)) * curr.`val`
        curr = curr!!.next
    }
    return sum == 0
}
