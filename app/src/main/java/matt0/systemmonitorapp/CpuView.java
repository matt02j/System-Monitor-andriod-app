package matt0.systemmonitorapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CpuView extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int cpuNum = 1+ getIntent().getIntExtra("cpuNum",0);
        Cpu cpu = (Cpu)MainActivity.data.getComponent(cpuNum);
        setContentView(R.layout.activity_cpu);
        TextView nameText =  findViewById(R.id.cpu_name);
        TextView tempText =  findViewById(R.id.cpu_temp);
        TextView usageText =  findViewById(R.id.cpu_usage);
        nameText.setText(cpu.getName());
        tempText.setText( String.valueOf(cpu.getCurTemp()) + "C");
        usageText.setText( String.valueOf(cpu.getCurUsage())+ "%");




    }
}
