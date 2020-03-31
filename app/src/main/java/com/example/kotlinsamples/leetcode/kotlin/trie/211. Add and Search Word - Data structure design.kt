package com.example.kotlinsamples.leetcode.kotlin.trie

class WordDictionary() {

    /** Initialize your data structure here. */
    private class TrieNode {
        var end = false
        var children: MutableMap<Char, TrieNode?> = HashMap()
    }
    private var root = TrieNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var trieNode: TrieNode = root
        for (ch in word) {
            if (!trieNode.children.containsKey(ch)) trieNode.children[ch] = TrieNode()
            trieNode = trieNode.children[ch]!!
        }
        trieNode.end = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return search(word, root)
    }
    private fun search(word: String, trieNode: TrieNode?): Boolean {
        println(word)
        var node = trieNode
        for (i in word.indices) {
            var ch = word[i]
            println("->" + ch)
            if (ch == '.') {
                for (node in node!!.children.values) {
                    return search(word.substring(i + 1, word.length), node)
                }
                return false
            } else if (node!!.children.containsKey(ch)) {
                node = node.children[ch]
            } else {
                return false
            }
        }
        return node != null && node.end
    }
}

fun main() {
    var d = WordDictionary()
    d.addWord("at")
    d.addWord("and")
    d.addWord("an")
    d.addWord("add")
    d.addWord("bat")
    println(d.search(".at"))
}