package com.example.kotlinsamples.leetcode.kotlin.linkedlist

fun main() {
    var head = "[4,5,1,9]".toLinkedList()
    println(head.toString())
    deleteNode(head?.next)
    println(head.toString())
}

private fun deleteNode(node: ListNode?): Unit {
    var tmp = node!!.next
    node.`val` = tmp!!.`val`
    node.next = tmp.next
    tmp!!.next = null // isolate this mode from list
}