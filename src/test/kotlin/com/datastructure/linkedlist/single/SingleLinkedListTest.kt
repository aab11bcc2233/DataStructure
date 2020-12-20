package com.datastructure.linkedlist.single

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class SingleLinkedListTest {

    @Test
    fun add() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

//        val array = arrayOf(node1, node2, node3, node4)
        val array = arrayOf(node1, node2, node4, node3)

        val linkedList = SingleLinkedList()
        linkedList.add(node1)
        linkedList.add(node2)
//        linkedList.add(node3)
//        linkedList.add(node4)
        linkedList.add(node4)
        linkedList.add(node3)

        linkedList.print()


        var temp = linkedList.head.next

        for (node in array) {
            assertEquals(node.no, temp!!.no, "顺序不对")
            temp = temp.next
        }
    }

    @Test
    fun size() {

        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

        val linkedList = SingleLinkedList()

        linkedList.add(node1)
        linkedList.add(node2)
        linkedList.add(node3)
        linkedList.add(node4)

        assertEquals(4, linkedList.size(), "长度不对")
    }

    @Test
    fun print() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

        val linkedList = SingleLinkedList()

        linkedList.add(node1)
        linkedList.add(node2)
        linkedList.add(node3)
        linkedList.add(node4)

        linkedList.print()
    }

    @Test
    fun addSortByNodeNo() {

        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

        val array = arrayOf(node1, node2, node3, node4)
//        val array = arrayOf(node1, node2, node4, node3)

        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
//        linkedList.addSortByNodeNo(node3)
//        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        linkedList.print()


        var temp = linkedList.head.next

        for (node in array) {
            assertEquals(node.no, temp!!.no, "顺序不对")
            temp = temp.next
        }
    }

    @Test
    fun del() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

        val array = mutableListOf(node1, node2, node3, node4)
//        val array = arrayOf(node1, node2, node4, node3)

        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
//        linkedList.addSortByNodeNo(node3)
//        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        println("删除前-----------")
        linkedList.print()

        linkedList.del(node4)
        array.remove(node4)

        println("删除后-----------")
        linkedList.print()


        var temp = linkedList.head.next

        for (node in array) {
            assertEquals(node.no, temp!!.no, "顺序不对")
            temp = temp.next
        }
    }

    @Test
    fun reverse() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")

        val array = mutableListOf(node1, node2, node3, node4)
//        val array = arrayOf(node1, node2, node4, node3)

        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        println("反转前-----------")
        linkedList.print()

        linkedList.reverse()

        println("反转后-----------")
        linkedList.print()


        var temp = linkedList.head.next
        for (node in array.reversed()) {
            assertEquals(node.no, temp!!.no, "顺序不对")
            temp = temp.next
        }
    }

    @Test
    fun reverseOrderPrintByRecursive() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")


        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        linkedList.reverseOrderPrintByRecursive()
    }

    @Test
    fun reverseOrderPrintByStack() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")


        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        linkedList.reverseOrderPrintByStack()
    }

    @Test
    fun findLastIndex() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")


        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        linkedList.print()

        val lastIndex = 2
        val node = linkedList.findLastIndex(lastIndex)
        println("找到倒数第 $lastIndex 个节点：$node")
        assertEquals(3, node?.no)
    }

    @Test
    fun findLastIndexErrEmpty() {

        val linkedList = SingleLinkedList()

        assertThrows(RuntimeException::class.java) {
            linkedList.findLastIndex(1)
        }
    }

    @Test
    fun findLastIndexErrIndexOut() {
        val node1 = Node(1, "A")
        val node2 = Node(2, "B")
        val node3 = Node(3, "C")
        val node4 = Node(4, "D")


        val linkedList = SingleLinkedList()
        linkedList.addSortByNodeNo(node1)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node2)
        linkedList.addSortByNodeNo(node3)
        linkedList.addSortByNodeNo(node4)
        linkedList.addSortByNodeNo(node4)

        linkedList.print()


        assertThrows(IndexOutOfBoundsException::class.java) {
            linkedList.findLastIndex(5)
        }
    }
}