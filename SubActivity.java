package app_osaero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.Calendar;

import es.exsample.R;

public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub);
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener((View view2)-> { finish(); });
        EditText editText = findViewById(R.id.editTextTextPersonName);
        editText.setOnClickListener((View view2) -> {
            String et = editText.getText().toString();
            int num = Integer.parseInt(et);
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra( "name" );
//        TextView tv = findViewById(R.id.textView8);
//        tv.setText(name);
        String[] strlist = name.split("/");
        int[] namelist = new  int[3];
        for (int i = 0; i < strlist.length; i++) {
            namelist[i] = Integer.parseInt(strlist[i]);
        }
        Calendar theday = Calendar.getInstance();
        theday.set(Calendar.YEAR, namelist[0]);
        theday.set(Calendar.MONTH,namelist[1]);
        theday.set(Calendar.MONTH,namelist[2]);
        int last = theday.getActualMaximum(Calendar.DATE);
        LineChart lineChart = findViewById(R.id.line_chart);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        // X軸の値
        ArrayList<String> xx = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = namelist[2]; i < last ; i++ ) {
            x.add(i);

            Integer ii = Integer.valueOf(i);
            String str = ii.toString();
            xx.add(str);
        }
        for (int i =1; i< namelist[2]; i++){
            x.add(i);
            Integer ii = Integer.valueOf(i);
            String str = ii.toString();
            xx.add(str);
        }
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xx));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawLabels(true);
        // value
        ArrayList<Entry> value = new ArrayList<>();
        for(int i = 1; i<last; i++) {
            value.add(new Entry(x.get(i-1), 0));
        }
        LineDataSet valueDataSet = new LineDataSet(value, "sample");
        dataSets.add(valueDataSet);
        lineChart.setData(new LineData(valueDataSet));
    }
}


