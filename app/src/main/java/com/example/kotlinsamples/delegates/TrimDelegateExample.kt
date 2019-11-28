package com.example.kotlinsamples.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    var name: String by TrimDelegate()
    name = " sam "
    println(name.equals(" sam"))
    println(name.equals("sam"))
}

class TrimDelegate : ReadWriteProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimmedValue

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimmedValue = value.trim()
    }

    private var trimmedValue: String = ""
}