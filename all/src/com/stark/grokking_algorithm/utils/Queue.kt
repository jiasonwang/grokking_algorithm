package com.stark.grokking_algorithm.utils

class Queue<T>(collection: Collection<T>? = null) {
    private val elements: MutableList<T> = mutableListOf()

    init {
        elements.addAll(collection.orEmpty())
    }

    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun enqueue(item: T) = elements.add(item)
    fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
    fun peek() = if (!isEmpty()) elements[0] else null

    override fun toString(): String = elements.toString()
}

fun <T> Queue<T>.push(items: Collection<T>?) = items?.forEach { this.enqueue(it) }
