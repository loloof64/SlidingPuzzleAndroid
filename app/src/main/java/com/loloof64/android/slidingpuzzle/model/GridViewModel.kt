package com.loloof64.android.slidingpuzzle.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.loloof64.android.slidingpuzzle.util.GridRandomize

class GridViewModel : ViewModel() {
    private val _gridValues = MutableLiveData<Array<Int>>()
    private val _dataGrid = DataGrid()
    private var _gameFinished = true

    fun getGridValues() : LiveData<Array<Int>> {
        return _gridValues
    }

    fun moveHoleToCell(column: Int, row: Int) {
        _dataGrid.moveHoleToCell(column = column, row = row)
        _gridValues.value = _dataGrid.values
    }

    fun randomizeGrid() {
        if (_gameFinished){
            val newValues = GridRandomize.generate()
            _dataGrid.values = newValues
            _gridValues.value = newValues
        }
    }
}