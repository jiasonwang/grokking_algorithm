package com.stark.grokking_algorithm

import com.stark.grokking_algorithm.utils.Queue
import com.stark.grokking_algorithm.utils.push

/**
 * 广度优先搜索
 */
class BreadthFirstSearch {
    fun find(root: Node, judgement: (node: Node?) -> Boolean): Node? {
        if (root?.nodes != null) {
            val friendsQueue = Queue<Node>(root.nodes)
            val skip = mutableSetOf<Node>()
            while (friendsQueue.peek() != null) {
                val friend = friendsQueue.dequeue()
                if (!skip.contains(friend)) {
                    if (judgement(friend)) {
                        return friend
                    } else {
                        friendsQueue.push(friend?.nodes)
                        if (friend != null) skip.add(friend)
                    }
                }
            }
        }
        return null
    }
}

data class Node(val nodes: List<Node>?, val name: String)