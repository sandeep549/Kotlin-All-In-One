package com.example.kotlinsamples.leetcode.advanceds

private class Trie2 {
    private class TrieNode {
        var end = false
        var children: MutableMap<Char, TrieNode?> = HashMap()
    }

    private var root = TrieNode()

    // Insert word into Trie
    fun insert(word: String) {
        var trieNode: TrieNode = root
        for (ch in word) {
            if (!trieNode.children.containsKey(ch)) trieNode.children[ch] = TrieNode()
            trieNode = trieNode.children[ch]!!
        }
        trieNode.end = true
    }

    // Find word into Trie
    fun find(word: String): Boolean {
        var trieNode: TrieNode? = root
        for (ch in word) {
            if (trieNode!!.children.containsKey(ch)) trieNode = trieNode.children[ch]
            else return false
        }
        return trieNode != null && trieNode.end
    }

    /**
     * This function will print all the words in the dictionary
     * that have given string as prefix.
     * 1. Check if prefix itself not present.
     * 2. Check if prefix end itself as word.
     * 3. Print all words that has this prefix.
     */
    fun printSuggestions(prefix: String) {
        var trieNode: TrieNode? = root
        for (ch in prefix) {
            trieNode = if (trieNode!!.children.containsKey(ch)) trieNode.children[ch] else return // prefix not present
        }
        if (trieNode != null && trieNode.end) {
            println(prefix)
            return // prefix itself is word
        }
        printSuggestions(prefix, trieNode)
    }

    private fun printSuggestions(prefix: String, trieNode: TrieNode?) {
        if (trieNode == null) return
        if (trieNode.end) println(prefix)
        for ((key, value) in trieNode.children) {
            printSuggestions(prefix + key, value)
        }
    }
}

fun main() {
    val trie2 = Trie2()
    trie2.insert("sandeep")
    trie2.insert("simar")
    trie2.insert("daksh")
    println("Find sandeep=" + trie2.find("sandeep"))

    trie2.printSuggestions("s")

    trie2.insert("how are you ?")
    trie2.insert("how do you do ?")
    trie2.printSuggestions("how")
}