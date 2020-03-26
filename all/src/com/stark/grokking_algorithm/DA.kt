package com.stark.grokking_algorithm

/**
 * 1. 状态迭代，将所有可能的状态都一一列举出来，然后前一个状态和后一个状态叠加，限制条件就是对两个状态的叠加结果的限制。
 * 2. 初始化，根据某个最大值，取step，如果是整型，那就是1。从1到最大值。
 */
class DA {
    fun knapsack(weight: Array<Int>, n: Int, w: Int): Int {
        val states: Array<Array<Boolean>> = Array(n) { Array(w + 1) { false } }
        states[0][0] = true
        if (weight[0] < w) {
            states[0][weight[0]] = true
        }
        for (i in 1 until n) {
            for (j in 0..w) {
                if (states[i - 1][j]) states[i][j] = states[i - 1][j]
            }
            for (j in 0..(w - weight[i])) {
                if (states[i - 1][j]) states[i][j + weight[i]] = true
            }
        }
        for (i in w downTo 0) {
            if (states[n - 1][i]) return i
        }
        return 0
    }

    fun knapsack2(items: Array<Int>, n: Int, w: Int): Int {
        val states: Array<Boolean> = Array(w + 1) { false }
        states[0] = true
        if (items[0] < w) {
            states[items[0]] = true
        }
        for (i in 1 until n) {
            println("===")
//            for (j in w - items[i] downTo 0) {
            for (j in 0 ..(w - items[i])) {
//                println(j + items[i])
                if (states[j]) {
                    println(j + items[i])
                    states[j + items[i]] = true
                }
            }
        }
        for (i in w downTo 0) {
            if (states[i]) return i
        }
        return 0
    }
}