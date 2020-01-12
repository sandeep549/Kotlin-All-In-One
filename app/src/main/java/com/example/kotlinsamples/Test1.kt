package com.example.kotlinsamples

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory
import java.util.*
import kotlin.math.min

fun main() {
    //stackExample()
//    val gson = GsonBuilder()
//        .registerTypeAdapterFactory(subtypeRAF)
//        .create()

    //serializeAndDeserialize(gson, Subtype1()) // this works (but not suitable)
    //serializeAndDeserialize(gson, Subtype2("s2")) // broken
    //serializeAndDeserialize(gson, Subtype3("s3", Parent.EnumField.SUBTYPE3)) // broken

    println(minFlips(2, 6, 5))
    println(minFlips(4, 2, 7))
    println(minFlips(1, 2, 3))
}

fun minFlips(a: Int, b: Int, c: Int): Int {
    var res = a.or(b)
    var expected = c
    var i = 1
    var ans = 0
    while (i <= 32) {
        if (res.shr(i - 1).and(1) != expected.shr(i - 1).and(1)) {
            if (a.shr(i - 1).and(1) == b.shr(i - 1).and(1) && a.shr(i - 1).and(1) == 1) ans += 2
            else ans++
        }
        i++
    }
    return ans
}

fun getNoZeroIntegers(n: Int): IntArray {
    fun haszero(r: Int): Boolean {
        var b = r
        while (b > 0) {
            if (b % 10 == 0) return true
            else b /= 10

        }
        return false
    }
    for (i in 1..n / 2) if (!haszero(i) && !haszero(n - i)) return intArrayOf(i, n - i)
    return intArrayOf()
}

private fun stackExample() {
    var stack1 = ArrayDeque<Char>()

    var stack = ArrayDeque<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack.toString())
    println(stack.isEmpty())

    println(stack.peek())
    println(stack.toString())

    println(stack.pop())
    println(stack.toString())

    println(stack.push(9))
    println(stack.toString())
}


//########################################################
// TEST CODE  - START
//########################################################
var arr = Array(3) { IntArray(2) }
var arr1 =
    Array(4) { Array(3) { IntArray(2) } }


fun containsDuplicate(nums: IntArray): Boolean {
    arr[0][1] = 2
    for (i in 0..nums.lastIndex - 1) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] == nums[j]) return true
        }
    }
    return false
}


//########################################################
// TEST CODE  - END
//########################################################

open class Parent(
    val stringField: String,
    val enumField: EnumField
) {

    enum class EnumField {
        SUBTYPE1,
        SUBTYPE2,
        SUBTYPE3
    }
}


class Subtype1() : Parent("s1", EnumField.SUBTYPE1)
class Subtype2(stringField: String) : Parent(stringField, EnumField.SUBTYPE2)
class Subtype3(stringField: String, type: EnumField) : Parent(stringField, type)

val subtypeRAF = RuntimeTypeAdapterFactory.of(Parent::class.java, "enumField")
    .registerSubtype(Subtype1::class.java, Parent.EnumField.SUBTYPE1.name)
    .registerSubtype(Subtype2::class.java, Parent.EnumField.SUBTYPE2.name)
    .registerSubtype(Subtype3::class.java, Parent.EnumField.SUBTYPE3.name)


private fun serializeAndDeserialize(gson: Gson, obj: Parent) {
    println("-----------------------------------------")
    val json = gson.toJson(obj)
    println(json)
    val obj = gson.fromJson(json, Parent::class.java)
    println("stringField=${obj.stringField}, enumField=${obj.enumField}")

}