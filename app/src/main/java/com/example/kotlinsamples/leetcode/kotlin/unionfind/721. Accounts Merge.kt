package com.example.kotlinsamples.leetcode.kotlin.unionfind

import java.util.*

private fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
    var parent = mutableMapOf<String, String>()
    var owner = mutableMapOf<String, String>()
    for (act in accounts) {
        for (i in 1 until act.size) {
            parent[act[i]] = act[i] //MakeSet operation
            owner[act[i]] = act[0]
        }
    }

    //find operation; gives representative of this disjoint set
    fun find(s: String, map: MutableMap<String, String>): String {
        return if (map[s] == s) s else find(map[s]!!, map)
    }

    //perform union operation, mark first email as representative of set for each account
    for (act in accounts) {
        var rpt = find(act[1], parent)
        for (i in 1 until act.size) {
            parent[find(act[i], parent)] = rpt
        }
    }

    //gather all email group, by their representative under a tree (b'coz we need emails sorted)
    var groupMap = mutableMapOf<String, TreeSet<String>>()
    for (act in accounts) {
        var rpt = find(act[1], parent)
        if (!groupMap.contains(rpt)) groupMap.put(rpt, TreeSet())
        for (i in 1 until act.size) {
            groupMap.get(rpt)!!.add(act[i])
        }
    }

    //build required output
    val listOfLists: MutableList<List<String>> = mutableListOf()
    for ((rpt, emails) in groupMap) {
        var emailList = emails.toMutableList()
        emailList.add(0, owner[rpt]!!)
        listOfLists.add(emailList)
    }
    return listOfLists
}