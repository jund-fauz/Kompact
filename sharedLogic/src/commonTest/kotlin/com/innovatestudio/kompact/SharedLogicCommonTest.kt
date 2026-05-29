package com.innovatestudio.kompact

import capital
import isAllArray
import operate
import kotlin.test.Test
import kotlin.test.assertEquals

class SharedLogicCommonTest {

    @Test
    fun isAllArrayTest() {
        assertEquals(
            true,
            isAllArray(intArrayOf(1, 2), intArrayOf(1, 2))
        )
        assertEquals(
            false,
            isAllArray(intArrayOf(1, 2), 1, 2)
        )
    }

    @Test
    fun operationTest() {
        assertEquals(
            0.3,
            '+'.operate(0.1, 0.2)
        )
    }

    @Test
    fun capitalTest() {
        assertEquals(
            "Lorem ipsum",
            "lorem ipsum".capital()
        )
        assertEquals(
            "Lorem ipsum. Buahlil ireng. Mas Bahlil uwireng.",
            "lorem ipsum. buahlil ireng. mas Bahlil uwireng.".capital()
        )
    }
}