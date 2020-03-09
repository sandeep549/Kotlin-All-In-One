package com.example.kotlinsamples.leetcode.kotlin.misc

private fun filterRestaurants(
    restaurants: Array<IntArray>,
    veganFriendly: Int,
    maxPrice: Int,
    maxDistance: Int
): List<Int> {
    return restaurants
        .filter { it[2] >= veganFriendly } // Vegan-Friendly or Both
        .filter { it[3] <= maxPrice }
        .filter { it[4] <= maxDistance }
        .sortedWith(
            compareByDescending<IntArray> { it[1] } // sort by descending rating
                .thenByDescending { it[0] }) // if rating match, then descending id
        .map { it[0] } // gather only id's
}