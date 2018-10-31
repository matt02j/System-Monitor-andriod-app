package matt0.systemmonitorapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

//TODO update every 3 seconds or so
    public static DataModel data;
    Button cpuButton, ramButton,driveButton;
    int nc,nd;
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark,getTheme()));
        setSupportActionBar(toolbar);

        Timer timer = new Timer();

        data = new DataModel();
        data.updateData();
        fillTempData();
        nc = data.getNumCPUs();
        nd = data.getNumDrives();
        //int numButtons = nc + nd +1;
        //buttons = new Button[numButtons];
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        cpuButton = (Button) findViewById(R.id.button6);
        cpuButton.setText(nc + " CPUs - " + String.format("%.2f", data.getCpuAverageUsage()) + " %");
        cpuButton.setTag("CPU");
        cpuButton.setHapticFeedbackEnabled(true);
        ramButton = (Button) findViewById(R.id.button7);
        ramButton.setText(data.getTotRam() + "Mb RAM");
        ramButton.setTag("Ram");
        driveButton = (Button) findViewById(R.id.button8);
        driveButton.setTag("DRIVE");
        driveButton.setText(nd + " Drives - " + String.format("%.2f", data.getDriveAverageUsage()) + " %");

        cpuButton.setOnClickListener(this);
        ramButton.setOnClickListener(this);
        driveButton.setOnClickListener(this);
        cpuButton.setBackgroundColor(getResources().getColor(R.color.lightGreen,getTheme()));
        cpuButton.setTextColor(getResources().getColor(R.color.colorPrimary,getTheme()));
        ramButton.setBackgroundColor(getResources().getColor(R.color.lightGreen,getTheme()));
        ramButton.setTextColor(getResources().getColor(R.color.colorPrimary,getTheme()));
        driveButton.setBackgroundColor(getResources().getColor(R.color.lightGreen,getTheme()));
        driveButton.setTextColor(getResources().getColor(R.color.colorPrimary,getTheme()));

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }

            private void update() {
                for(Component x : data.getComponents()){
                    x.setCurTemp(Math.random()*80);
                    x.setCurUsage(Math.random()*100);
                    if(x.getClass() == Cpu.class){
                        ((Cpu)x).setFrequency(Math.random()*4);
                    }
                }
                cpuButton.setText(nc + " CPUs - " + String.format("%.2f", data.getCpuAverageUsage()) + " %");
                driveButton.setText(nd + " Drives - " + String.format("%.2f", data.getDriveAverageUsage()) + " %");
            }
        }, 100, 10000);
/* //this dynamically created buttons :( sad face
        for(int i=0;i<numButtons;i++){
            buttons[i]=new Button(this);
            //buttons[i].setText(data.getComponent(i).getName());
            if(i==0){
                buttons[i].setText("Ram Usage");
                buttons[i].setTag("RAM");
            }
            else if(i<=data.getNumCPUs()){
                buttons[i].setText("Cpu "+(i-1));
                buttons[i].setTag("CPU");
            }
            else{
                buttons[i].setText("Drive " + (i-data.getNumCPUs()));
                buttons[i].setTag("DRIVE");

            }
            linearLayout.addView(buttons[i],params);
            buttons[i].setOnClickListener(this);
        }

/*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/
    }


    private void fillTempData() {
        data.addComponent(new Cpu("MYCPU",40,10,2.8,10),data.numCPUs+1);
        data.numCPUs++;
        data.addComponent(new Cpu("MYCPU2",42,12,3.7,10),data.numCPUs+1);
        data.numCPUs++;
        data.addComponent(new Drive("MYDRIVE",40,10,600,800,10),data.numCPUs+data.numDrives+1);
        data.numDrives++;
    }
/*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
*/
    @Override
    public void onClick(View v) {
        Intent myIntent;
        switch((String)v.getTag()){
            case "RAM":

                break;
            case "CPU":
               // cpuButton.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
                myIntent = new Intent(MainActivity.this, CpuView.class);
                startActivity(myIntent);
                break;
            case "DRIVE":
                myIntent = new Intent(MainActivity.this, DriveView.class);
                startActivity(myIntent);
                break;
        }
    }
}
