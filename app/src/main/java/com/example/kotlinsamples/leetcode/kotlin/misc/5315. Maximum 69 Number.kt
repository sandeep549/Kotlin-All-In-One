package com.example.kotlinsamples.leetcode.kotlin.misc

private fun maximum69Number(num: Int): Int {
    return num.toString().replaceFirst("6", "9").toInt()
}

// the interview way
private fun maximum69Number2(num: Int): Int {
    var arr = num.toString().toCharArray()
    for (i in arr.indices) {
        if (arr[i] == '6') {
            arr[i] = '9'
            break
        }
    }
    return String(arr).toInt() // don't use arr.toString()
}
