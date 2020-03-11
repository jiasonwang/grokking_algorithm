package com.stark.grokking_algorithm

/**
 * 迪杰斯特拉算法
 */
class DirectedGraph private constructor(private val weights: Array<Array<Int>>) {
    private val processed: MutableSet<Int> = mutableSetOf(0)

    companion object {
        fun test() {
            /**
             * 0,1,2,3 四个点
             * weight(0,1) = 4
             * weight(0,2) = 1
             * weight(2,1) = 2
             * weight(2,3) = 4
             * weight(1,3) = 1
             * 求 0->3 的最短距离,结果是0->2->1->3 = 4
             */
            val w0 = arrayOf(0, 4, 1, Int.MAX_VALUE)//0到各个顶点的边的权重,顺序按0~3排列
            val w1 = arrayOf(Int.MAX_VALUE, 0, Int.MAX_VALUE, 1)//1到各个顶点的边的权重,顺序按0~3排列
            val w2 = arrayOf(Int.MAX_VALUE, 2, 0, 4)//2到各个顶点的边的权重,顺序按0~3排列
            val w3 = arrayOf(Int.MAX_VALUE,Int.MAX_VALUE,Int.MAX_VALUE,0)//3到各个顶点的边的权重,顺序按0~3排列
            val paths = DirectedGraph(arrayOf(w0,w1,w2,w3)).caculate()
            println("v0->v3 cost ${w0[3]}")
            var p = mutableListOf<String>()
            p.add("v3")
            var find = paths[3]
            while (find != Int.MAX_VALUE){
                p.add("v${find}")
                find = paths[find]
            }
            p.reverse()
            println("v0-v3 path ${p}")
        }
    }


    fun caculate() :IntArray{
        val w0 = weights[0]
        //记录每个节点的最小cost的上游
        var paths = IntArray(weights.size){ Int.MAX_VALUE}
        //起始点的下游节点初始化
        for((i,v)in w0.withIndex()){
            if (v!=0 && v!=Int.MAX_VALUE){
                paths[i] = 0
            }
        }
        var currentIndex = getLightestNodeIndex(w0)
        while (currentIndex != Int.MAX_VALUE) {
            processed.add(currentIndex)
            val base = w0[currentIndex]
            for ((i, v) in weights[currentIndex].withIndex()) {
                if (v != Int.MAX_VALUE && v != 0) {
                    if (w0[i] > (base + v)) {//发现近路
                        w0[i]= base + v
                        paths[i] = currentIndex
                    }
                }
            }
            currentIndex = getLightestNodeIndex(w0)
        }
        return paths
    }

    private fun getLightestNodeIndex(w: Array<Int>): Int {
        var lightest = Int.MAX_VALUE
        for ((index, value) in w.withIndex()) {
            if (!processed.contains(index) && value != Int.MAX_VALUE) {
                lightest = if (lightest == Int.MAX_VALUE || w[lightest] > value) index else lightest
            }
        }
        return lightest
    }
}


