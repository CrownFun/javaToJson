package pl.filewicz.foosball;

public class Result {

    private int hostPoints;
    private int visitorPoints;

    public Result(int hostPoints, int visitorPoints) {
        this.hostPoints = hostPoints;
        this.visitorPoints = visitorPoints;
    }

    public int getHostPoints() {
        return hostPoints;
    }

    public void setHostPoints(int hostPoints) {
        this.hostPoints = hostPoints;
    }

    public int getVisitorPoints() {
        return visitorPoints;
    }

    public void setVisitorPoints(int visitorPoints) {
        this.visitorPoints = visitorPoints;
    }

    @Override
    public String toString() {
        return hostPoints + " : "+visitorPoints;
    }
}
