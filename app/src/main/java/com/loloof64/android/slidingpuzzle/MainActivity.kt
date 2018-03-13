package com.loloof64.android.slidingpuzzle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.loloof64.android.slidingpuzzle.model.GridViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridModel = ViewModelProviders.of(this).get(GridViewModel::class.java)
        gridModel.getGridValues().observe(this, Observer {
            if (it != null){
                updateCell(cell_00, it[0])
                updateCell(cell_01, it[1])
                updateCell(cell_02, it[2])
                updateCell(cell_03, it[3])

                updateCell(cell_10, it[4])
                updateCell(cell_11, it[5])
                updateCell(cell_12, it[6])
                updateCell(cell_13, it[7])

                updateCell(cell_20, it[8])
                updateCell(cell_21, it[9])
                updateCell(cell_22, it[10])
                updateCell(cell_23, it[11])

                updateCell(cell_30, it[12])
                updateCell(cell_31, it[13])
                updateCell(cell_32, it[14])
                updateCell(cell_33, it[15])
            }
        })
        gridModel.randomizeGrid()
    }

    private fun updateCell(cellRef: TextView, value: Int) {
        cellRef.text = if (value > 0) value.toString() else ""
    }

    private lateinit var gridModel: GridViewModel
}
