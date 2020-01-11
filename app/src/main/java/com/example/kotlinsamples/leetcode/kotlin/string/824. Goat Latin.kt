package com.example.kotlinsamples.leetcode.kotlin.string

import java.lang.StringBuilder

fun main() {
    println(toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"))
    println(toGoatLatin("The quick brown fox jumped over the lazy dog").equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"))
}

private fun toGoatLatin(S: String): String {
    var ans = StringBuilder()
    var set = setOf<Char>('a', 'e', 'i', 'o', 'u')
    S.split(' ').forEachIndexed { index: Int, s: String ->
        ans.append(" ")
        if (set.contains(s.first().toLowerCase())) ans.append(s).append("ma")
        else ans.append(s.subSequence(1, s.length)).append(s.first()).append("ma")
        for (i in 1..index + 1) ans.append("a")
    }
    return ans.trim().toString()
}