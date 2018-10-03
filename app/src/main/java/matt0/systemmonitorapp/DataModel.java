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
                components.add(new Cpu());
            }
            for(int i=0;i< numDrives;i++){
                components.add(new Drive());
            }
        }

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
