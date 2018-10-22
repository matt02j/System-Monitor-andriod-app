package matt0.systemmonitorapp;

import java.util.ArrayList;

public class DataModel {
    int numCPUs, numDrives, totRam; // ram is in Mb
    private ArrayList<Component> components;

    public DataModel(){
     components = new ArrayList<Component>();
    }

    public void updateData(){
        //TODO get data from web
        totRam=1024*32; //this is temporary data
        numCPUs=4;
        numDrives=2;
        if(components.size()==0){
            components.add(new Ram());
            for(int i=0;i<numCPUs;i++){
                components.add(new Cpu("Cpu " +i,40,5,4,10));
            }
            for(int i=0;i< numDrives;i++){
                components.add(new Drive("Drive "+i,40,5,20,10,10));
            }
        }

    }

    public double getCpuAverageUsage(){
        double sum=0;
        for(int i=0;i<numCPUs;i++){
            sum+=components.get(i+1).getCurUsage();
        }
        return sum/numCPUs;
    }
    public double getDriveAverageUsage(){
        double sum=0;
        for(int i=0;i<numDrives;i++){
            sum+=components.get(numCPUs+i+1).getCurUsage();
        }
        return sum/numDrives;
    }


    public ArrayList<Component> getComponents() {
        return components;
    }

    public Component getComponent(int i){
        return components.get(i);
    }

    public void addComponent(Component comp){
        components.add(comp);
    }

    public void addComponent(Component comp, int i){
        components.add(i,comp);
    }
    public int getNumCPUs() {
        return numCPUs;
    }

    public int getNumDrives() {
        return numDrives;
    }
    public int getTotRam(){
        return totRam;
    }
}
