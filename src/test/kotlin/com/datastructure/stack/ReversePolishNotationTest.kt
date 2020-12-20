package com.datastructure.stack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReversePolishNotationTest {

    @Test
    fun calculate() {
        /**
         * 用后缀表达式计算下面的表达式
         *   3+2*6-4 （中缀表达式） -> 3 2 6 * + 4 - (后缀（逆波兰）表达式)
         *
         * 思路：
         * 准备一个 numStack,
         * 从左往右遍历字符串，遇到数字入栈 numStack，遇到运算符从 numStack 取出两个数字
         * 参与运算，将结果入栈 numStack。
         *
         * 先不考虑括号，还有小数。
         */

//        val formula = "3 2 6 * + 4 -" // 这里用空格分隔一下，便于处理
//        val formulaResult = 3+2*6-4
        val formula = "300 2 60 * + 40 -" // 这里用空格分隔一下，便于处理
        val formulaResult = 300+2*60-40

        println("开始计算：$formula")

        val list = formula.split(" ").toList()

        val result = ReversePolishNotation().calculate(list)

        println("计算结果是：$formula = $result")
        assertEquals(formulaResult, result)
    }

    @Test
    fun toInfixList() {
        val formula = "1+((2+3)*4)-5"
        val arr = formula.map { it.toString() }.toList()
        println("期待值：${arr}") //注意这个 arr 只能测试单个数字的情况

        val rpn = ReversePolishNotation()
        val result = rpn.toInfixList(formula)
        println("计算结果：$result")

        assertArrayEquals(arr.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun isNum() {
        assertEquals(true, ReversePolishNotation().isNum('9'))
        assertEquals(true, ReversePolishNotation().isNum('5'))
        assertEquals(true, ReversePolishNotation().isNum('0'))
        assertEquals(false, ReversePolishNotation().isNum('i'))
    }

    @Test
    fun infix2SuffixExpression() {
        val infix = "1+((20+3)*4)-5"
        val infixResult = 1+((20+3)*4)-5

        println("中缀表达式：$infix")

        val rpn = ReversePolishNotation()
        val infixList = rpn.toInfixList(infix)
        val suffixList = rpn.infix2SuffixExpression(infixList)
        println("后缀表达式：$suffixList")

        assertEquals(infixResult, rpn.calculate(suffixList))
    }
}