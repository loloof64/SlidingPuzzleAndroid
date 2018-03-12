package com.loloof64.android.slidingpuzzle.util

import org.hamcrest.Matchers.arrayContainingInAnyOrder
import org.junit.Assert.assertThat
import org.junit.Test

class GridRandomizeTest {

    @Test
    fun generateCorrectGrid(){
        val generatedGrid = GridRandomize.generate()
        assertThat(generatedGrid, arrayContainingInAnyOrder(0,1,2,3,4,5,6,
                7,8,9,10,11,12,13,14,15))
    }

}