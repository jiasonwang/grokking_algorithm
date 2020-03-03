package com.stark.grokking_algorithm

class ChoiceSort {
    fun sort(source: Array<Int>, bigFirst: Boolean = true): Array<Int> {
        if (source == null || source.isEmpty() || source.size == 1) {
            return source
        }
        val finder= { arr:MutableList<Int> ->
            var target = arr[0]
            var index = 0
            for ((i, value) in arr.withIndex()) {
                target = if (bigFirst) {
                    if (target > value) {
                        target
                    } else {
                        index = i
                        value
                    }
                } else {
                    if (target < value) {
                        target
                    } else {
                        index = i
                        value
                    }
                }
            }
            arr.removeAt(index)
        }
        val findTemp = source.toMutableList()
        val sorted = mutableListOf<Int>()
        source.forEach {
            sorted.add(finder(findTemp))
        }
        return sorted.toTypedArray()
    }
}