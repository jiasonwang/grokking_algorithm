package com.stark.grokking_algorithm

class QuickSort :ISort<Int>{
    override fun sort(ary: Array<Int>): Array<Int> {
        return quickSort(ary?.toMutableList())?.toTypedArray()
    }
    private fun quickSort(ary:MutableList<Int>):MutableList<Int>{
        if (ary == null || ary.size < 2)
            return ary
        else {
            val pivot = ary[0]
            val smaller = mutableListOf<Int>()
            val bigger = mutableListOf<Int>()
            for(value in ary.slice(1 until ary.size)){
                if (value < pivot)
                    smaller.add(value)
                else
                    bigger.add(value)
            }
            val sQuick = quickSort(smaller)
            val bQuick = quickSort(bigger)
            val all = mutableListOf<Int>()
            all.addAll(sQuick)
            all.add(pivot)
            all.addAll(bQuick)
            return all
        }
    }
}