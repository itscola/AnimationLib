package top.whitecola.animationlib;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class Animation {
    private float max,min, progressValue;
    private long time;
    private boolean isFirstUpdate;
    private AbstractAnimationFunction function;


    public Animation(float defaultProgressValue){
        this.progressValue = defaultProgressValue;
    }

    public Animation setMax(float max) {
        this.max = max;
        return this;
    }

    public Animation setMin(float min) {
        this.min = min;
        return this;
    }

    public Animation setTotalTime(long time) {
        this.time = time;
        if(function!=null){
            function.setTotalTime(time);
        }
        return this;
    }

    public Animation setFunction(AbstractAnimationFunction function){
        function.setTotalTime(time);
        this.function = function;
        return this;
    }

    public float update(long pastTime){
        float value = this.function.get( pastTime/time);
        if(value!=-1)
            setProgressValue(value * (max - min));
        return progressValue;
    }

    public float getProgressValue() {
        return progressValue;
    }

    public float getTotalTime() {
        return time;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }

    public AbstractAnimationFunction getFunction() {
        return function;
    }

    private void setProgressValue(float progressValue) {
        this.progressValue = progressValue;
    }
}
