package matt0.systemmonitorapp;

public class Drive extends Component {

    private double readSpeed, writeSpeed;

    public Drive(){
        super();
        readSpeed = 0;
        writeSpeed = 0;
    }
    public Drive(String name, double curTemp, double curUsage, double readSpeed, double writeSpeed, int historySize){
        super(name,curTemp,curUsage,historySize);
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(double readSpeed) {
        this.readSpeed = readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(double writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

}
