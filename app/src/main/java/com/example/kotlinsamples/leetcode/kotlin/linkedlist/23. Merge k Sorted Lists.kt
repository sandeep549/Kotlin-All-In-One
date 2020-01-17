package com.example.kotlinsamples.leetcode.kotlin.linkedlist

import java.util.*
import kotlin.collections.ArrayList


// Upper Bound -> O(N * klogk)
// N = no of total node in all lists
// k = no of lists
// Time would be less than this, as only first time klogk time will be taken in sorting, afterwards
// it will O(k), as TimSort takes linear time on almost sorted elements. Other factor is list
// size(k) also will get reducing, coz al list will not have same size.
private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var ans = ListNode(0)
    var curr = ans
    var currList = ArrayList<ListNode>()
    lists.forEach { listNode -> listNode?.let { currList.add(listNode) } }

    while (currList.size > 0) {
        currList.sortBy { it.`val` }
        var first = currList.first()
        curr.next = first
        curr = first
        if (first.next == null) currList.removeAt(0)
        else currList[0] = first.next!!
    }
    return ans.next
}

private fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    var dummyhead = ListNode(0) //dummy node
    var tail = dummyhead
    var queue = PriorityQueue<ListNode>(lists.size) { l1, l2 -> l1.`val` - l2.`val` }
    lists.forEach { it?.let { queue.add(it) } }
    while (!queue.isEmpty()) {
        tail.next = queue.poll()
        tail = tail.next as ListNode
        if (tail.next != null) queue.add(tail.next)
    }
    return dummyhead.next
}