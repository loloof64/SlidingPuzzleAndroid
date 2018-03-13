package com.loloof64.android.slidingpuzzle.model

import java.util.*
import kotlin.math.abs

data class IllegalMoveException(val dx: Int, val dy: Int) : Exception()
data class OutOfGridException(val column: Int, val row: Int) : Exception()

class DataGrid {

    var values: Array<Int>
        get() = _values
        set(update) {
            _values = update
        }

    fun moveHoleToCell(column: Int, row: Int) : DataGrid {
        val holeIndex = findHoleIndex()
        val holeColumn = holeIndex % 4
        val holeRow = holeIndex / 4

        val dx = column - holeColumn
        val dy = row - holeRow

        when {
            column == -1 || column == 4 -> throw OutOfGridException(column = column, row = row)
            row == -1 || row == 4 -> throw OutOfGridException(column = column, row = -1)
            // diagonal move
            abs(dx) > 0 && abs(dy) > 0 -> throw IllegalMoveException(dx = dx, dy = dy)
            //too far away
            abs(dx) >= 2 || abs(dy) >= 2 -> throw IllegalMoveException(dx= dx, dy = dy)
            // horizontal move
            holeColumn != column -> swapCellsHorizontally(firstCellColumn = column, firstCellRow = row,
                    secondCellDistance = -dx)
            else -> swapCellVertically(firstCellColumn = column, firstCellRow = row,
                        secondCellDistance = -dy)
        }

        return this
    }

    fun gameIsWon() : Boolean {
        val expectedOrder = arrayOf(
                1,2,3,4,
                5,6,7,8,
                9,10,11,12,
                13,14,15,0
        )
        return Arrays.equals(values, expectedOrder)
    }

    private fun findHoleIndex() : Int {
        var holeIndex = -1
        while (values[++holeIndex] != 0);
        return holeIndex
    }

    private fun swapCellsHorizontally(firstCellColumn: Int, firstCellRow: Int, secondCellDistance: Int){
        val pointedCellIndex = firstCellColumn + 4 * firstCellRow
        val temp = values[pointedCellIndex]
        values[pointedCellIndex] = values[pointedCellIndex + secondCellDistance]
        values[pointedCellIndex + secondCellDistance] = temp
    }

    private fun swapCellVertically(firstCellColumn: Int, firstCellRow: Int, secondCellDistance: Int){
        val pointedCellIndex = firstCellColumn + 4*firstCellRow
        val temp = values[pointedCellIndex]
        values[pointedCellIndex] = values[pointedCellIndex + 4*secondCellDistance]
        values[pointedCellIndex + 4*secondCellDistance] = temp
    }

    private var _values: Array<Int> = arrayOf()
}