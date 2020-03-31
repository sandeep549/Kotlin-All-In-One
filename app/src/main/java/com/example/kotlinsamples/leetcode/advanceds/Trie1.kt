package com.example.kotlinsamples.leetcode.advanceds

/**
 * A sample Trie to store only lower case alphabets.
 */
class Trie {
    private val root = TrieNode()
    /**
     * Insert string into Trie.
     */
    fun insert(str: String) {
        var node: TrieNode = root
        for (c in str) {
            val index: Int = c - 'a' // index is mark of this char presence, index null means this char absent
            if (node.children[index] == null) node.children[index] = TrieNode()
            node = node.children[index]!!
        }
        node.isEndOfWord = true
    }

    /**
     * Find string in Trie.
     */
    fun search(str: String): Boolean {
        var node: TrieNode? = root
        for (c in str) {
            val index = c - 'a'
            if (node!!.children[index] == null) return false
            node = node.children[index]
        }
        return node != null && node.isEndOfWord
    }

    /**
     * This function will print all the words in the dictionary
     * that have given string as prefix.
     * 1. Check if prefix itself not present.
     * 2. Check if prefix end itself as word.
     * 3. Print all words that has this prefix.
     */
    fun printSuggestions(prefix: String) {
        var node: TrieNode? = root
        for (c in prefix) {
            val index = c - 'a'
            if (node!!.children[index] == null) return // prefix not present
            node = node.children[index]
        }
        if (node != null && node.isEndOfWord) {
            println(prefix)
            return // prefix itself is word
        }
        printSuggestions(prefix, node)
    }

    private fun printSuggestions(prefix: String, node: TrieNode?) {
        if (node == null) return
        if (node.isEndOfWord) println(prefix)
        for (i in node.children.indices) {
            val ch = ('a'.toInt() + i).toChar()
            printSuggestions(prefix + ch, node.children[i])
        }
    }

    /**
     * Node in Trie data structure.
     */
    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(SIZE)
        var isEndOfWord = false
    }

    companion object {
        private const val SIZE = 25
    }
}

fun main() {
    val trie = Trie()
    trie.insert("sandeep")
    trie.insert("simar")
    trie.insert("daksh")
    trie.insert("anaya")
    trie.insert("howareyou")
    trie.insert("howdoyoudo")

    println("Find simar=" + trie.search("simar"))
    println("Find anya=" + trie.search("anaya"))

    trie.printSuggestions("how")
}