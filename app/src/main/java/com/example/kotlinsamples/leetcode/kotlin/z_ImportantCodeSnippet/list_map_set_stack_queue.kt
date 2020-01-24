package com.example.kotlinsamples.leetcode.kotlin.z_ImportantCodeSnippet

import java.util.*

private fun listInKotlin() {
    //1
    var l1 = listOf<Int>() // read-only, random access like ArrayList
    //2
    var l2 = mutableListOf<Int>() // mutable, random access like ArrayList
    //work with above 2 whenever possible


    //3
    var l3 = arrayListOf<Int>() // same as 2, mutable ArrayList
    var l4 = emptyList<Int>()// read-only, random access
    var l5 = listOfNotNull<Int>() //read-only, random access

    //No sequential access list in kotlin ???
}

private fun mapsInKotlin() {
    // inbuilt maps (non java maps, though needs clarification)
    /*1*/
    var immutableMap = mapOf<Int, Int>() // maintains insertion order, immutable
    /*2*/
    var mutableMap = mutableMapOf<Int, Int>() // maintains order, mutable

    //work with below 3 whenever possible
    //factory method for java maps
    /*3*/
    var sortedmap = sortedMapOf<Int, Int>() //java TreeMap, mutable
    /*4*/
    var hasmap = hashMapOf<Int, Int>() // java HashMap, mutable
    /*5*/
    var likedhashmap = linkedMapOf<Int, Int>() // java LinkedHashMap, mutable, same as 2 internally
}

fun main() {
    PleaseRunToBetterUnderstandMe()
}

private fun PleaseRunToBetterUnderstandMe() {
    val m: Deque<Int> = LinkedList()//ArrayDeque()
    m.push(1)
    m.push(2)
    m.push(3)
    println(m.toList())
    println(m.peek())
    println(m.peekFirst())
    println(m.peekLast())
    m.offer(4)
    println(m.toList())
    println(m.peek())
    println(m.peekFirst())
    println(m.peekLast())
    m.add(5)
    println(m.toList())
    m.addFirst(6)
    m.addLast(7)
    println(m.toList())
    m.pop()
    println(m.toList())
    m.push(8)
    println(m.toList())
    m.poll()
    println(m.toList())
}

/**
 * Stack:
 * push()
 * pop()
 * peek()
 */
private fun stackInKotlin() {
    //1
    val stack1: Deque<Int> = ArrayDeque()
    stack1.push(1)
    stack1.push(2)
    stack1.pop()
    stack1.peek()
    stack1.peekFirst()
    stack1.isEmpty()
    stack1.size

    //2
    val stack2: Deque<Int> = LinkedList()
    stack2.push(1)
    stack2.push(2)
    stack2.pop()
    stack2.peek()
    stack2.peekFirst()
    stack2.isEmpty()
    stack2.size

}


/**
 * Queue:
 * offer(), add()
 * remove(), poll()
 * peek()
 */
private fun queueInKotlin() {
    //1
    val queue1: Deque<Int> = ArrayDeque()
    queue1.add(1)
    queue1.add(2)
    queue1.remove()
    queue1.peekFirst()
    queue1.isEmpty()
    queue1.size

    //2
    var queue2: Deque<Int> = LinkedList()
    queue2.offer(1)
    queue2.offer(2)
    queue2.offer(3)
    println(queue2.toList())
    queue2.poll()
    println(queue2.toList())
    println(queue2.peek())
}