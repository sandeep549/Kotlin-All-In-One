package com.example.kotlinsamples.leetcode.kotlin.twopointer

fun main() {
//    println(Character.isLetter('A'))
//    println(Character.isLetter(' '))
//    println(Character.isLetter(','))
//    println(Character.isLetter('0'))
//    println(Character.isLetter(':'))
//    println(isPalindrome(".,"))
    println(isPalindrome("0P"))
}

private fun isPalindrome(s: String): Boolean {
    var arr = s.toCharArray()
    var l = 0
    var r = arr.lastIndex
    while (l < r) {
        while (l < r && !Character.isLetterOrDigit(arr[l])) l++
        while (l < r && !Character.isLetterOrDigit(arr[r])) r--
        if (Character.toLowerCase(arr[l++]) != Character.toLowerCase(arr[r--])) return false
    }
    return true
}