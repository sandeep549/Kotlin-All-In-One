package com.example.kotlinsamples.leetcode.kotlin.design

private class LRUCache(capacity: Int) {

    private var count: Int = 0
    private var capacity = 0
    private var cache: HashMap<Int, DLinkedNode> = HashMap()
    private var head: DLinkedNode
    private var tail: DLinkedNode

    init {
        this.capacity = capacity

        head = DLinkedNode()
        head.pre = null

        tail = DLinkedNode()
        tail.next = null

        head.next = tail
        tail.pre = head

    }

    private fun addNode(node: DLinkedNode) {
        node.pre = head
        node.next = head.next

        head.next!!.pre = node
        head.next = node
    }

    private fun removeNode(node: DLinkedNode) {
        var pre = node.pre
        var next = node.next

        pre!!.next = next
        next!!.pre = pre
    }

    private fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): DLinkedNode? {
        var res = tail.pre
        removeNode(res!!)
        return res
    }

    fun get(key: Int): Int {
        var node = cache.get(key)
        if (node == null) return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var node = cache.get(key)
        if (node == null) {
            var new = DLinkedNode()
            new.key = key
            new.value = value
            cache.put(key, new)
            addNode(new)
            ++count
            if (count > capacity) {
                var tail = popTail()
                cache.remove(tail!!.key)
                --count
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }

    private class DLinkedNode {
        var key = 0
        var value = 0
        var pre: DLinkedNode? = null
        var next: DLinkedNode? = null
    }
}