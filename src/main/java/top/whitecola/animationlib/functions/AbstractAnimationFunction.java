package top.whitecola.animationlib.functions;

public class AbstractAnimationFunction implements IAnimationFunction {
    private long totalTime;

    @Override
    public float get(long pastTime) {
        return -1;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public float getElapsedTimeRate(float pastTime){
        return pastTime/totalTime;
    }

}
