package com.datastructure.linkedlist.circle

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CircleSingleLinkedListTest {

    @Test
    fun addNode() {
        val linkedList = CircleSingleLinkedList()

        linkedList.addNode(5)

        linkedList.print()
    }

    @Test
    fun print() {
        val linkedList = CircleSingleLinkedList()

        linkedList.addNode(5)

        linkedList.print()
    }

    @Test
    fun count() {
        val linkedList = CircleSingleLinkedList()

        val total = 5
        linkedList.addNode(total)

        linkedList.print()

        println("-----------------------")

        linkedList.count(1, 2, total)
    }
}