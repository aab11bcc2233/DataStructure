package com.datastructure.stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.RuntimeException
import com.datastructure.stack.ReversePolishNotation.Operator
import java.util.*

internal class ArrayStackTest {

    @Test
    fun isFull() {
        val stack = ArrayStack(4)

        stack.push(10)
        stack.push(20)
        stack.push(30)
        stack.push(40)
        stack.push(50)

        println("打印栈元素")
        stack.print()

        assertEquals(true, stack.isFull())
    }

    @Test
    fun isEmpty() {
        val stack = ArrayStack(4)

        println("打印栈元素")
        stack.print()

        assertEquals(true, stack.isEmpty())
    }

    @Test
    fun isNotEmpty() {
        val stack = ArrayStack(4)

        stack.push(10)
        stack.push(20)

        println("打印栈元素")
        stack.print()

        assertEquals(true, !stack.isEmpty())
    }

    @Test
    fun push() {

        val arr = intArrayOf(10, 20, 30, 40)

        val stack = ArrayStack(4)

        arr.forEach {
            stack.push(it)
        }

        println("打印栈元素")
        stack.print()

        assertEquals(true, stack.isFull())
    }

    @Test
    fun pop() {

        val arr = intArrayOf(10, 20, 30, 40)

        val stack = ArrayStack(arr.size)

        arr.forEach {
            stack.push(it)
        }

        println("打印栈元素")
        stack.print()

        println("--------")

        arr.reversedArray().forEachIndexed { index, it ->
            val value = stack.pop()
            println("pop 第 ${index + 1} 个元素: $value ")
            assertEquals(it, value)
        }

    }

    @Test
    fun calc() {
        /**
         * 比如输入下面这个字符串，要求计算出结果
         *   3+2*6-4
         *
         * 思路
         *
         * 用两个 stack，一个 numStack 存放数字，一个 operatorStack 存放运算符。
         * 遍历字符串，假设遍历的当前元素叫 currValue：
         *   · currValue 是 数字 时，push 进 numStack。
         *   · currValue 是 运算符 时，
         *       · 当 operatorStack 为空时，直接 push。
         *       · operatorStack 不为空时，
         *           currValue 与 栈顶运算符（topOperator）做比较,
         *             · currValue > topOperator（当前运算符 优先级 大于 栈顶运算符）,
         *                 直接 push 进 operatorStack。
         *             · currValue <= topOperator（当前运算符 优先级 小于等于 栈顶运算符）, 从 numStack 取出两个数字，
         *                与 topOperator(这里需要通过 operatorStack.pop 出来) 做运算，（注意这两数字在运算时的顺序，先 pop 出来的在 topOperator 运算符的右边，后 pop 出来的在 左边。），
         *                将结果存入 numStack。然后将 currValue 运算符，push 进 operatorStack。
         *
         *                假设 numStack： 3 2 6
         *                    operatorStack: + *
         *                当 '-' 与 topOperator(也就是 '*') 对比时，'-' < '*',
         *                那就是计算 2 × 6 = 12，将结果入栈 numStack, 并将 '-' 入栈 operatorStack
         *                    numStack： 3 12
         *                    operatorStack: + -
         *                将最后一个数字 4 入栈：
         *                    numStack： 3 12 4
         *                    operatorStack: + -
         *
         *
         *                假设将  currValue > topOperator 和 currValue <= topOperator 的后面的操作互换下
         *                    numStack： 3 2
         *                    operatorStack: +
         *                当 '*' 与 topOperator(也就是 '+') 对比时，'*' > '+',
         *                那就是计算 3 + 2 = 5，可以看到 运算的优先级就不对了，或者你知道需要用 '*' 去计算，
         *                3 * 2 = 6, 参与计算的数字不对。
         *                numStack 里只有 2 与 '*' 有关，而下一个与 '*' 有关的 6，你还没有遍历到，无法
         *                参与运算。
         *                这就是为什么 currValue > topOperator 入栈，currValue <= topOperator 去
         *                计算 topOperator。 当 currValue <= topOperator 是说明 topOperator 所对应的两个需
         *                要参与运算的数字，已经存在于 numStack 里。
         *
         * 遍历字符串结束，得到有数据的 numStack 和 有运算符的 operatorStack。
         * 然后 每从 numStack 取出两个数字，与 operatorStack 的 topOperator 做运算，
         * 将结果存入 numStack。知道 numStack 只剩一个元素时，就是运算结果。
         */

//        val formula = "3+2*6-4"
//        val formulaResult = 3+2*6-4
//        val formula = "300+2*60-40"
//        val formulaResult = 300+2*60-40
        val formula = "1+((2+3)*4)-5"
        val formulaResult = 1+((2+3)*4)-5
        val length = formula.length

        println("开始计算：$formula")

//        val maxSize = 20
//        val numStack = ArrayStack(maxSize)
//        val operatorStack = ArrayStack(maxSize)

        val numStack = Stack<Int>()
        val operatorStack = Stack<Char>()

        var index = 0
        var numberSB = StringBuilder()
        while (index < formula.length) {
            val currValue = formula.elementAt(index)


            if (isNum(currValue)) {
                numberSB.clear() // 要清空数据，要不然这个数字会超级大

                var ch: Char
                do { //处理连续数字的情况，多位数字
                    ch = formula.elementAt(index)
                    numberSB.append(ch)
                    index += 1
                } while (index < length && isNum(formula.elementAt(index)))

                numStack.push(numberSB.toString().toInt())
                continue
            }

            if (operatorStack.isEmpty() || Operator.isParenthesisLeft(currValue)) {
                operatorStack.push(currValue)
                index += 1
                continue
            }

            if (Operator.isParenthesisRight(currValue)) {
                while (!Operator.isParenthesisLeft(operatorStack.peek())) {

                    val right = numStack.pop()
                    val left = numStack.pop()
                    val result = calculate(left, right, operatorStack.pop())
                    numStack.push(result)
                }

                operatorStack.pop() //删除左括号
                index += 1
                continue
            }

            if (Operator.isParenthesisLeft(operatorStack.peek())) {
                operatorStack.push(currValue)
                index += 1
                continue
            }

            if (Operator.priority(currValue) > Operator.priority(operatorStack.peek())) {
                operatorStack.push(currValue)
                index += 1
                continue
            }

            val right = numStack.pop()
            val left = numStack.pop()
            val result = calculate(left, right, operatorStack.pop())
            numStack.push(result)
            operatorStack.push(currValue)
            index += 1
        }



        while (numStack.size > 1) {
            val right = numStack.pop()
            val left = numStack.pop()
            val result = calculate(left, right, operatorStack.pop())
            numStack.push(result)
        }

        println("计算结果是：" + formula + " = ${numStack.peek()}")
        assertEquals(formulaResult, numStack.peek())
    }

    fun isNum(char: Char) = char.toInt() in 48..57

    fun calculate(left: Int, right: Int, operator: Char): Int {
        return when (operator) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            '/' -> left / right
            else -> throw RuntimeException("运算符错误")
        }
    }

    fun isOperator(char: Char): Boolean {
        return when (char) {
            '+', '-', '*', '/' -> true
            else -> false
        }
    }

}