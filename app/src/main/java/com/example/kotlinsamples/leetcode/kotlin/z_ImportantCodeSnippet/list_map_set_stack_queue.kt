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

private fun stackInKotlin() {
    val stack1: ArrayDeque<Int> = ArrayDeque()
    stack1.push(1)
    stack1.push(2)
    stack1.pop()
    stack1.peek()
    stack1.peekFirst()
    stack1.isEmpty()
    stack1.size
}

private fun queueInKotlin() {
    val queue1: ArrayDeque<Int> = ArrayDeque()
    queue1.add(1)
    queue1.add(2)
    queue1.remove()
    queue1.peekFirst()
    queue1.isEmpty()
    queue1.size
}