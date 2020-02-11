package com.example.kotlinsamples.leetcode.kotlin.array.medium

//TLE
private fun numFriendRequests(ages: IntArray): Int {
    fun canRequest(aAge: Int, bAge: Int) = (bAge <= aAge && (bAge >= 0.5 * aAge + 7))
    var ans = 0
    for (i in ages.indices) {
        for (j in ages.indices) {
            if (i == j) continue
            if (canRequest(ages[i], ages[j])) ans++
        }
    }
    return ans
}

//Time complexity: O(n)
private fun numFriendRequests2(ages: IntArray): Int {
    val count = IntArray(121)
    for (age in ages) count[age]++ //this gives us O(n) time

    //below code doesn't depend on input size
    var ans = 0
    for (ageA in 0..120) {
        val countA = count[ageA]
        for (ageB in 0..120) {
            val countB = count[ageB]
            if (ageA * 0.5 + 7 >= ageB) continue
            if (ageA < ageB) continue
            if (ageA < 100 && 100 < ageB) continue
            ans += countA * countB
            if (ageA == ageB) ans -= countA //important condition to avoid self requests
        }
    }

    return ans
}


