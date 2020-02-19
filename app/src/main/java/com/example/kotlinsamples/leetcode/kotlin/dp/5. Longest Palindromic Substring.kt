package com.example.kotlinsamples.leetcode.kotlin.dp

//dp, bottom-up
//Time:O(n^2)
private fun longestPalindrome(str: String): String {
    var table = Array<BooleanArray>(str.length) { BooleanArray(str.length) }
    var max = 0
    var start = 0 //beginning index of max palindrome
    for (k in 1..str.length) { //size of palindrome
        for (i in 0..str.length - k) { //start index
            var j = i + k - 1
            if (k == 1) { //single length palindrome
                table[i][j] = true
            } else if (k == 2) {
                if (str[i] == str[j]) table[i][j] = true
            } else { //for more than 3 length, w'll have middle elements
                if (table[i + 1][j - 1] && str[i] == str[j]) table[i][j] = true
            }
            //we found new bigger palindrome
            if (table[i][j] && k > max) {
                max = k
                start = i
            }
            // println("i$i, j=$j, k=$k table=${table[i][j]}, max=$max, start=$start")
        }
    }
    return str.substring(start, start + max)
}