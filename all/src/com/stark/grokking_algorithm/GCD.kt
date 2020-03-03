package com.stark.grokking_algorithm

/**
 * 欧几里得算法
 */
class GCD {
    fun gcd(a: Int, b: Int): Int {
        var value = if (a > b) a to b else b to a
        var mod = -1
        do {
            mod = value.first % value.second
            value = value.second to mod
        } while (mod != 0)
        return value.first
    }
}