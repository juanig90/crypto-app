package com.example.cryptoapp.presentation.ui

import android.content.Context
import android.util.AttributeSet
import com.example.cryptoapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ChartView(context: Context, attributeSet: AttributeSet): LineChart(context, attributeSet) {

    fun drawChart(values: List<Float>?) {
        values?.let {
            val entries = ArrayList<Entry>()
            values.forEachIndexed { index, value ->
                entries.add(Entry(index.toFloat(), value))
            }
            val dataSet = LineDataSet(entries, context.getString(R.string.growth_30_days))
            dataSet.run {
                setDrawFilled(true)
                setDrawCircles(false)
                setDrawValues(false)
                mode = LineDataSet.Mode.CUBIC_BEZIER
                setDrawHorizontalHighlightIndicator(false)
                setDrawVerticalHighlightIndicator(false)
            }
            val lineData = LineData(dataSet)
            data = lineData
            description = Description().apply { text = "" }
            with(axisLeft) {
                setDrawLabels(false)
                setDrawGridLines(false)
            }
            with(axisRight) {
                setDrawLabels(false)
                setDrawGridLines(false)
            }
            xAxis.isEnabled = false
        }
    }

}