package com.example.kotlinsamples.leetcode.kotlin.array.medium

//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()

    fun backtrack(path: MutableList<Int>, remain: Int, startIdx: Int) {
        when {
            remain < 0 -> return
            remain == 0 -> ans.add(path.toList()) //we got one answer, copy to final answer
            else -> {
                for (i in startIdx..candidates.lastIndex) {
                    path.add(candidates[i])
                    backtrack(path, remain - candidates[i], i)
                    path.removeAt(path.lastIndex) //remove current element, we have gone through this path
                }
            }
        }
    }

    backtrack(ArrayList(), target, 0)
    return ans
}