package com.idejie.android.quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Resource list
 */
public class ChartResourceActivity extends AppCompatActivity {

    private List<String> titles = new ArrayList<>();
    private List<Integer> nums = new ArrayList<>();

    private DecimalFormat df = new DecimalFormat("0.00");
    private PieChart mPiechart;


    private void initView() {
        initChart();
    }

    /**
     * Initialisation Chart
     */
    private void initChart() {
        mPiechart = (PieChart) findViewById(R.id.mPieChart);
        mPiechart.animateX(1400);
        mPiechart.setUsePercentValues(true);
        mPiechart.getLegend().setEnabled(true);
        mPiechart.getLegend().setFormSize(10);
        mPiechart.getLegend().setTextSize(10);
        mPiechart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        mPiechart.getLegend().setForm(Legend.LegendForm.SQUARE);
        mPiechart.setDescription("pie chart");
        mPiechart.setDescriptionTextSize(12);
        mPiechart.setDescriptionPosition(950, 950);
        mPiechart.setRotationEnabled(false);
    }

    /**
     * Setting data
     */
    private void setData() {
        ArrayList<Entry> entrys = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            entrys.add(new Entry(nums.get(i), i));
        }
        //piechart dataset
        PieDataSet dataset = new PieDataSet(entrys, "");
        //Setting spacing
        dataset.setSliceSpace(3f);
        //spacing when selected
        dataset.setSelectionShift(10f);
        //colors
        dataset.setColors(new int[]{
                Color.rgb(0, 255, 255),
                Color.rgb(60, 179, 113),
                Color.rgb(255, 165, 0),
                Color.rgb(124, 252, 0),
                Color.rgb(255, 182, 193),
                Color.rgb(110, 128, 176),
                Color.rgb(0, 179, 193),
                Color.rgb(124, 165, 113),
                Color.rgb(179, 113, 255),
                Color.rgb(182, 178, 60),
        });
        //padding
        PieData piedata = new PieData(titles, dataset);
        //text sizes
        piedata.setValueTextSize(9);
        piedata.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return df.format(value) + "%";
            }
        });
        mPiechart.setData(piedata);
    }
}
