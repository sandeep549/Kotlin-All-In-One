package com.example.kotlinsamples.leetcode.kotlin

class TweetCounts() {

    var map = sortedMapOf<Int, String>()
    fun recordTweet(tweetName: String, time: Int) {
        map.put(time, tweetName)
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List<Int> {
        return map.entries
            .filter { it.key in startTime..endTime && it.value == tweetName }
            .groupBy {
                when (freq) {
                    "minute" -> it.key / 60
                    "hour" -> it.key / 3600
                    else -> it.key / 86400
                }
            }.map { it.value.size }
    }
}

fun main() {
    val tweetCounts = TweetCounts()
    tweetCounts.recordTweet("tweet3", 0)
    tweetCounts.recordTweet("tweet3", 60)
    tweetCounts.recordTweet("tweet3", 10) // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.

    println(tweetCounts.getTweetCountsPerFrequency(
        "minute",
        "tweet3",
        0,
        59
    ))

    println(tweetCounts.getTweetCountsPerFrequency(
        "minute",
        "tweet3",
        0,
        60
    ))

    tweetCounts.recordTweet("tweet3", 120)

    println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210))
}