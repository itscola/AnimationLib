package top.whitecola.animationlib;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class Animation {
    private float max,min, progressValue,time;
    private boolean isFirstUpdate;
    private boolean reverse;
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

    public Animation setTime(float time) {
        this.time = time;
        return this;
    }

    public Animation setFunction(AbstractAnimationFunction type){
        return this;
    }

    public float update(long pastTime){
        float value = this.function.get( pastTime/time );
        return value==-1?progressValue:value;
    }

    public float getProgressValue() {
        return progressValue;
    }

    public Animation setReverse(boolean reverse) {
        this.reverse = reverse;
        return this;
    }

}
