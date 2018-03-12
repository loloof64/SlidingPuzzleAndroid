package com.loloof64.android.slidingpuzzle.model

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*

class DataGridTest {

    @Before
    fun setupBeforeEach(){
        data = DataGrid()
    }

    @Test
    fun tryingToBringTheHoleJustLeftToItsCellShouldSucceed_1(){
        data.values = dataInit1
        data.moveHoleToCell(column = 0, row = 1)
        assertTrue(Arrays.equals(data.values.toIntArray(), dataOutput1.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustLeftToItsCellShouldSucceed_2(){
        data.values = dataInit2
        data.moveHoleToCell(column = 1, row = 3)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput2.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustRightToItsCellShouldSucceed_1(){
        data.values = dataInit3
        data.moveHoleToCell(column = 2, row = 1)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput3.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustRightToItsCellShouldSucceed_2(){
        data.values = dataInit4
        data.moveHoleToCell(column = 3, row = 0)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput4.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustUpToItsCellShouldSucceed_1(){
        data.values = dataInit5
        data.moveHoleToCell(column = 1, row = 0)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput5.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustUpToItsCellShouldSucceed_2(){
        data.values = dataInit6
        data.moveHoleToCell(column = 2, row = 2)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput6.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustDownItsCellShouldSucceed_1(){
        data.values = dataInit7
        data.moveHoleToCell(column = 1, row = 2)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput7.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustDownItsCellShouldSucceed_2(){
        data.values = dataInit8
        data.moveHoleToCell(column = 2, row = 1)
        assertTrue(Arrays.equals(data.values.toIntArray() , dataOutput8.toIntArray()))
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleFollowingADiagonalMove_1(){
        data.values = dataInit1
        data.moveHoleToCell(column = 2, row = 2)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleFollowingADiagonalMove_2(){
        data.values = dataInit2
        data.moveHoleToCell(column = 3, row = 2)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleFollowingADiagonalMove_3(){
        data.values = dataInit4
        data.moveHoleToCell(column = 1, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleFollowingADiagonalMove_4(){
        data.values = dataOutput3
        data.moveHoleToCell(column = 0, row = 3)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_1(){
        data.values = dataInit1
        data.moveHoleToCell(column = 3, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_2(){
        data.values = dataOutput1
        data.moveHoleToCell(column = 3, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_3(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 0, row = 0)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_4(){
        data.values = dataOutput6
        data.moveHoleToCell(column = 0, row = 2)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_5(){
        data.values = dataOutput2
        data.moveHoleToCell(column = 1, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_6(){
        data.values = dataInit1
        data.moveHoleToCell(column = 1, row = 3)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_7(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 3, row = 3)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt_8(){
        data.values = dataInit6
        data.moveHoleToCell(column = 2, row = 0)
    }

    @Test(expected = OutOfGridException::class)
    fun cannotMoveTheHoleOutOfGrid_1(){
        data.values = dataOutput1
        data.moveHoleToCell(column = -1, row = 1)
    }

    @Test(expected = OutOfGridException::class)
    fun cannotMoveTheHoleOutOfGrid_2(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 4, row = 0)
    }

    @Test(expected = OutOfGridException::class)
    fun cannotMoveTheHoleOutOfGrid_3(){
        data.values = dataInit4
        data.moveHoleToCell(column = 2, row = -1)
    }

    @Test(expected = OutOfGridException::class)
    fun cannotMoveTheHoleOutOfGrid_4(){
        data.values = dataInit2
        data.moveHoleToCell(column = 2, row = 4)
    }

    @Test
    fun gameWonWithGridInOrder(){
        data.values = expectedOrder
        assertTrue(data.gameIsWon())
    }

    private lateinit var data: DataGrid

    private val expectedOrder = arrayOf(
            1,2,3,4,
            5,6,7,8,
            9,10,11,12,
            13,14,15,0
    )

    private val dataInit1 = arrayOf(
            4, 1, 12,7,
            3, 0, 8, 6,
            10, 15, 2, 11,
            14, 5, 13, 9
    )

    private val dataOutput1 = arrayOf(
            4, 1, 12, 7,
            0, 3, 8, 6,
            10, 15, 2, 11,
            14, 5, 13, 9
    )

    private val dataInit2 = arrayOf(
            4, 1, 12,7,
            3, 13, 8, 6,
            10, 15, 2, 11,
            14, 5, 0, 9
    )

    private val dataOutput2 = arrayOf(
            4, 1, 12, 7,
            3, 13, 8, 6,
            10, 15, 2, 11,
            14, 0, 5, 9
    )

    private val dataInit3 = arrayOf(
            8, 15, 3, 2,
            14, 0, 13, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataOutput3 = arrayOf(
            8, 15, 3, 2,
            14, 13, 0, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataInit4 = arrayOf(
            8, 15, 0, 2,
            14, 3, 13, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataOutput4 = arrayOf(
            8, 15, 2, 0,
            14, 3, 13, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataInit5 = arrayOf(
            4, 1, 12,7,
            3, 0, 8, 6,
            10, 15, 2, 11,
            14, 5, 13, 9
    )

    private val dataOutput5 = arrayOf(
            4, 0, 12,7,
            3, 1, 8, 6,
            10, 15, 2, 11,
            14, 5, 13, 9
    )

    private val dataInit6 = arrayOf(
            4, 1, 12,7,
            3, 13, 8, 6,
            10, 15, 2, 11,
            14, 5, 0, 9
    )

    private val dataOutput6 = arrayOf(
            4, 1, 12,7,
            3, 13, 8, 6,
            10, 15, 0, 11,
            14, 5, 2, 9
    )

    private val dataInit7 = arrayOf(
            8, 15, 3, 2,
            14, 0, 13, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataOutput7 = arrayOf(
            8, 15, 3, 2,
            14, 5, 13, 7,
            1, 0, 9, 6,
            12, 4, 11, 10
    )

    private val dataInit8 = arrayOf(
            8, 15, 0, 2,
            14, 3, 13, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )

    private val dataOutput8 = arrayOf(
            8, 15, 13, 2,
            14, 3, 0, 7,
            1, 5, 9, 6,
            12, 4, 11, 10
    )
}