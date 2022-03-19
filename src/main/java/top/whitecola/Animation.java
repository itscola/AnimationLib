package top.whitecola;

public class Animation {
    private float max,min,progress,time;
    private boolean isFirstUpdate;
    private boolean reverse;
    private AnimationFunction function;


    public Animation(){

    }

    public Animation setMax(float max) {
        this.max = max;
        return this;
    }

    public Animation setMin(float min) {
        this.min = min;
        return this;
    }

    public Animation setTime(float time) {
        this.time = time;
        return this;
    }

    public Animation setFunction(FunctionType type){
        return this;
    }

    public float update(){

        return progress;
    }

    public float getProgress() {
        return progress;
    }

    public Animation setReverse(boolean reverse) {
        this.reverse = reverse;
        return this;
    }
}
