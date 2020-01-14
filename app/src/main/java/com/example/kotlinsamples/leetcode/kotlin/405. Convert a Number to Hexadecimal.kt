package com.example.kotlinsamples.leetcode.kotlin

fun main() {
    println(toHex2(26))
}

/**
 * Conversion to hex can be done directly from binary.
 * We can take each set of 4 bits(nibble) and convert them into hex directly.
 * After all, under the hood, computer treats them (hex, decimal) to binary.
 * Those(hex, decimal) are sake of human representation(debatable**).
 */
fun toHex(n: Int): String {
    if (n == 0) return "0"
    var map = mapOf(
        0 to "0", 1 to "1", 2 to "2", 3 to "3",
        4 to "4", 5 to "5", 6 to "6", 7 to "7",
        8 to "8", 9 to "9", 10 to "a", 11 to "b",
        12 to "c", 13 to "d", 14 to "e", 15 to "f"
    )
    var ans = StringBuilder()
    var n = n
    while (n != 0) {
        ans.append(map[n.and(0x0f)])
        n = n.ushr(4) //we want logical shift right(i.e. unsigned), don't want to preserve sign bit
    }
    return ans.reverse().toString()
}

fun toHex2(n: Int): String {
    if (n == 0) return "0"
    var map = mapOf(
        0 to "0", 1 to "1", 2 to "2", 3 to "3",
        4 to "4", 5 to "5", 6 to "6", 7 to "7",
        8 to "8", 9 to "9", 10 to "a", 11 to "b",
        12 to "c", 13 to "d", 14 to "e", 15 to "f"
    )
    var ans = StringBuilder()
    var n = n
    while (n != 0) {
        ans.append(map[n.and(0b1111)])
        n = n.ushr(4) //we want logical shift right(i.e. unsigned), don't want to preserve sign bit
    }
    return ans.reverse().toString()
}