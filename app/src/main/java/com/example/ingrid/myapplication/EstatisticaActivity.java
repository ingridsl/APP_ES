package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica);

        //GRÁFICO DE PIZZA
        PieChart pie = (PieChart) findViewById(R.id.piechart);

        List<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(40f, "Verde"));
        pieEntries.add(new PieEntry(26.7f, "Amarelo"));
        pieEntries.add(new PieEntry(24.0f, "Laranja"));
        pieEntries.add(new PieEntry(30.8f, "Azul"));
        pieEntries.add(new PieEntry(20.8f, "Vermelho"));

        PieDataSet pieSet = new PieDataSet(pieEntries, "Top 5 Ocorrências");
        pieSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData Pdata = new PieData(pieSet);
        pie.setDescription("Top 5 Ocorrências");
        pie.setData(Pdata);
        pie.animateY(3000, Easing.EasingOption.EaseInCirc);
        pie.animateX(3000, Easing.EasingOption.EaseInCirc);
        pie.invalidate(); // refresh*/

        //GRÁFICO DE BARRAS
        BarChart bar = (BarChart) findViewById(R.id.barchart);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(6f, 10f));
        barEntries.add(new BarEntry(8f, 20f));
        barEntries.add(new BarEntry(10f, 25f));
        barEntries.add(new BarEntry(12f, 50f));
        barEntries.add(new BarEntry(14f, 58f));
        barEntries.add(new BarEntry(16f, 60f));
        barEntries.add(new BarEntry(18f, 55f));
        barEntries.add(new BarEntry(20f, 25f));
        barEntries.add(new BarEntry(22f, 30f));
        barEntries.add(new BarEntry(24f, 10f));

        BarDataSet barSet = new BarDataSet(barEntries, "BarDataSet");
        barSet.setColors(ColorTemplate.LIBERTY_COLORS);
        BarData bardata = new BarData(barSet);
        bardata.setBarWidth(0.9f); // set custom bar width
        bar.setData(bardata);
        bar.setFitBars(true); // make the x-axis fit exactly all bars
        bar.setDescription("Número de ocorrências ao longo do dia no último semestre");
        bar.animateY(3000, Easing.EasingOption.EaseInBack);
        bar.invalidate(); // refresh

        //GRÁFICO DE BOLHAS
        BubbleChart bubble = (BubbleChart) findViewById(R.id.bubblechart);

        List<BubbleEntry> bubbleEntries = new ArrayList<>();
        bubbleEntries.add(new BubbleEntry(0, 1, 10));
        bubbleEntries.add(new BubbleEntry(1, 2, 12));
        bubbleEntries.add(new BubbleEntry(2, 1, 15));
        bubbleEntries.add(new BubbleEntry(3, 0, 10));

        BubbleDataSet bubbleSet = new BubbleDataSet(bubbleEntries, "BubbleDataSet");
        bubbleSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        BubbleData bubbledata = new BubbleData(bubbleSet);
        bubble.setData(bubbledata);
        bubble.setDescription("Mais Ocorrências");
        bubble.animateY(3000, Easing.EasingOption.EaseInBack);
        bubble.invalidate(); // refresh
    }
}
