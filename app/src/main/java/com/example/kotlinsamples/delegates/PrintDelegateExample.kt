package com.example.kotlinsamples.delegates

import com.example.kotlinsamples.DemoFragment
import kotlin.reflect.KProperty

fun main() {
    var example = Example()
    println(example.p)
    example.p = "NEW"
}

class Example {
    var p: String by PrintDelegate()
}

class PrintDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}