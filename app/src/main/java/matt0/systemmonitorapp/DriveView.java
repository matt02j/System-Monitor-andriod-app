package matt0.systemmonitorapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class DriveView extends AppCompatActivity {
    TableLayout table;
    TableRow row ;
    TextView nameText ;
    TextView tempText ;
    TextView usageText ;
    TextView readText ;
    TextView writeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_view);
        table = findViewById(R.id.drive_table);
        table.setStretchAllColumns(true);for(int i=0;i<=MainActivity.data.numDrives;i++) {

            row = new TableRow(this);
            nameText = new TextView(this);
            tempText = new TextView(this);
            usageText = new TextView(this);
            readText = new TextView(this);
            writeText = new TextView(this);
        }
        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 10000);
    }

    public void update(){
        for(int i=0;i<=MainActivity.data.numDrives;i++){
            Drive drive=null;
            if(i!=0) {
                drive = (Drive) MainActivity.data.getComponent(MainActivity.data.numCPUs + i);
            }
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
