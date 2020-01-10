package com.example.kotlinsamples

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

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

fun main() {
    val gson = GsonBuilder()
        .registerTypeAdapterFactory(subtypeRAF)
        .create()

    serializeAndDeserialize(gson, Subtype1()) // this works (but not suitable)
    serializeAndDeserialize(gson, Subtype2("s2")) // broken
    //serializeAndDeserialize(gson, Subtype3("s3", Parent.EnumField.SUBTYPE3)) // broken
}

private fun serializeAndDeserialize(gson: Gson, obj: Parent) {
    println("-----------------------------------------")
    val json = gson.toJson(obj)
    println(json)
    val obj = gson.fromJson(json, Parent::class.java)
    println("stringField=${obj.stringField}, enumField=${obj.enumField}")

}