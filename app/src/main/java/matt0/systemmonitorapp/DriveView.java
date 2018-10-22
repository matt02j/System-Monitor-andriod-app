package matt0.systemmonitorapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DriveView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_view);
        TableLayout table = findViewById(R.id.drive_table);
        table.setStretchAllColumns(true);
        for(int i=0;i<=MainActivity.data.numDrives;i++){
            Drive drive=null;
            if(i!=0) {
                drive = (Drive) MainActivity.data.getComponent(MainActivity.data.numCPUs + i);
            }
            TableRow row = new TableRow(this);
            TextView nameText = new TextView(this);
            TextView tempText = new TextView(this);
            TextView usageText =  new TextView(this);
            TextView readText =  new TextView(this);
            TextView writeText =  new TextView(this);
            if(i==0){

                nameText.setText("Name ");
                readText.setText("read-Mb/s");
                writeText.setText("write-Mb/s");
                tempText.setText("temp-C");
                usageText.setText("Usage %");
                nameText.setTypeface(Typeface.DEFAULT_BOLD);
                nameText.setTextSize(16);
                readText.setTypeface(Typeface.DEFAULT_BOLD);
                readText.setTextSize(16);
                writeText.setTypeface(Typeface.DEFAULT_BOLD);
                writeText.setTextSize(16);
                tempText.setTypeface(Typeface.DEFAULT_BOLD);
                tempText.setTextSize(16);
                usageText.setTypeface(Typeface.DEFAULT_BOLD);
                usageText.setTextSize(16);
            }
            else {
                nameText.setText(drive.getName());
                readText.setText(String.format("%.2f",drive.getReadSpeed()));
                writeText.setText(String.format("%.2f",drive.getWriteSpeed()));
                tempText.setText(String.format("%.2f",drive.getCurTemp()));
                usageText.setText(String.format("%.2f",drive.getCurUsage()));

                nameText.setTypeface(Typeface.DEFAULT_BOLD);
                nameText.setTextSize(20);
                readText.setTypeface(Typeface.DEFAULT_BOLD);
                readText.setTextSize(20);
                writeText.setTypeface(Typeface.DEFAULT_BOLD);
                writeText.setTextSize(20);
                tempText.setTypeface(Typeface.DEFAULT_BOLD);
                tempText.setTextSize(20);
                usageText.setTypeface(Typeface.DEFAULT_BOLD);
                usageText.setTextSize(20);
            }
            nameText.setWidth(row.getWidth()/5);
            tempText.setWidth(row.getWidth()/5);
            usageText.setWidth(row.getWidth()/5);
            readText.setWidth(row.getWidth()/5);
            writeText.setWidth(row.getWidth()/5);

            row.addView(nameText);
            row.addView(tempText);
            row.addView(usageText);
            row.addView(readText);
            row.addView(writeText);
            table.addView(row);
        }
    }
}
