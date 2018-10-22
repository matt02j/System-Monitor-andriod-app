package matt0.systemmonitorapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CpuView extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //int cpuNum = 1+ getIntent().getIntExtra("cpuNum",0);
        //Cpu cpu = (Cpu)MainActivity.data.getComponent(cpuNum);
        setContentView(R.layout.activity_cpu);

        TableLayout table = findViewById(R.id.cpu_table);
        table.setStretchAllColumns(true);
        for(int i=0;i<=MainActivity.data.numCPUs;i++){
            Cpu cpu =null ;
            if(i!=0) {
                cpu = (Cpu) MainActivity.data.getComponent(i);
            }
            TableRow row = new TableRow(this);
            TextView nameText = new TextView(this);
            TextView tempText = new TextView(this);
            TextView usageText =  new TextView(this);
            TextView freqText =  new TextView(this);
            if(i==0){
                nameText.setText("Name ");
                tempText.setText("temp-C");
                usageText.setText("Usage %");
                freqText.setText("Ghz");
                nameText.setTypeface(Typeface.DEFAULT_BOLD);
                nameText.setTextSize(16);
                tempText.setTypeface(Typeface.DEFAULT_BOLD);
                tempText.setTextSize(16);
                usageText.setTypeface(Typeface.DEFAULT_BOLD);
                usageText.setTextSize(16);
                freqText.setTypeface(Typeface.DEFAULT_BOLD);
                freqText.setTextSize(16);
            }
            else {
                nameText.setText(cpu.getName());
                tempText.setText(String.format("%.2f",cpu.getCurTemp()));
                usageText.setText(String.format("%.2f",cpu.getCurUsage()));
                freqText.setText(String.format("%.2f",cpu.getFrequency()));

                nameText.setTypeface(Typeface.DEFAULT_BOLD);
                nameText.setTextSize(20);
                tempText.setTypeface(Typeface.DEFAULT_BOLD);
                tempText.setTextSize(20);
                usageText.setTypeface(Typeface.DEFAULT_BOLD);
                usageText.setTextSize(20);
                freqText.setTypeface(Typeface.DEFAULT_BOLD);
                freqText.setTextSize(20);
            }
            nameText.setWidth(row.getWidth()/4);
            tempText.setWidth(row.getWidth()/4);
            usageText.setWidth(row.getWidth()/4);
            freqText.setWidth(row.getWidth()/4);
            row.addView(nameText);
            row.addView(tempText);
            row.addView(usageText);
            row.addView(freqText);
            table.addView(row);
        }
//
//        TextView nameText =  findViewById(R.id.cpu_name);
//        TextView tempText =  findViewById(R.id.cpu_temp);
//        TextView usageText =  findViewById(R.id.cpu_usage);
//        nameText.setText(cpu.getName());
//        tempText.setText( String.valueOf(cpu.getCurTemp()) + "C");
//        usageText.setText( String.valueOf(cpu.getCurUsage())+ "%");




    }
}
