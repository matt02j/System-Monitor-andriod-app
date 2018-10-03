package matt0.systemmonitorapp;

public class Cpu extends Component {
    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    private double frequency; // in Ghz

    public Cpu(){
        super();
        frequency = 0;
    }
    public Cpu(String name, double curTemp, double curUsage, double frequency, int historySize){
        super(name,curTemp,curUsage,historySize);
        this.frequency = frequency;
    }


}
