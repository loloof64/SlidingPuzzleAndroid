package com.loloof64.android.slidingpuzzle.util

object GridRandomize {

    fun generate(): Array<Int> {
        val data = (0..15).toMutableList()
        data.shuffle()
        return data.toTypedArray()
    }

}