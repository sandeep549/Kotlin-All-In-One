package com.example.kotlinsamples.leetcode.kotlin.linkedlist

fun main() {

}

private fun hasCycle(head: ListNode?): Boolean {
    var visited = HashSet<ListNode>()
    var curr = head
    while (curr != null) {
        if (visited.contains(curr)) {
            return true
        } else {
            visited.add(curr)
        }
        curr = curr.next
    }
    return false
}

private fun hasCycle2(head: ListNode?): Boolean {
    if (head == null || head.next == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false
        }
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return true
}

private fun hasCycle3(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
        if (slow == fast) {
            return true
        }
    }
    return false
}