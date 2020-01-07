package com.example.kotlinsamples.higherorderfunctions

fun main() {

    // example-1
    var list = arrayListOf("sandeep", "mandeep", "ajay")
    list = list.filterOnCondition { it.contains("deep", true) }
    println(list)

    // example-2
    var list2 = arrayListOf<Int>()
    for (number in 1..10) {
        list2.add(number)
    }
    list2 = list2.filterOnCondition { isMultipleOf(it, 5) }
    println(list2)
}

fun <T> ArrayList<T>.filterOnCondition(condition: (T) -> Boolean): ArrayList<T> {
    val result = arrayListOf<T>()
    for (item in this) {
        if (condition(item)) {
            result.add(item)
        }
    }
    return result
}

fun isMultipleOf(number: Int, multipleOf: Int): Boolean {
    return number % multipleOf == 0
}