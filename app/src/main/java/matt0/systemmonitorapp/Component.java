package matt0.systemmonitorapp;

public abstract class Component {

    private double curTemp;
    private double temps[];
    private double curUsage;
    private double usages[];
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Component(){
        this("NA",0,0,10);
    }

    public Component(String name, double curTemp, double curUsage, int historySize){
        this.curTemp = curTemp;
        this.curUsage = curUsage;
        temps = new double[historySize];
        usages = new double[historySize];
        this.name = name;
    }

    public void addTemp(double temp){
        //TODO decide how to implement this
    }
    public void addUsage(double usage){
        //TODO
    }

    public double getCurTemp() {
        return curTemp;
    }

    public void setCurTemp(double curTemp) {
        this.curTemp = curTemp;
    }

    public double[] getTemps() {
        return temps;
    }

    public void setTemps(double[] temps) {
        this.temps = temps;
    }

    public double getCurUsage() {
        return curUsage;
    }

    public void setCurUsage(double curUsage) {
        this.curUsage = curUsage;
    }

    public double[] getUsages() {
        return usages;
    }

    public void setUsages(double[] usages) {
        this.usages = usages;
    }


}
