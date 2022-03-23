package top.whitecola.animationlib;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class Animation {
    private float max,min, progressValue;
    private long time;
    private boolean isFirstUpdate = true;
    private boolean reverse;
    private AbstractAnimationFunction function;
    private long firstTime;
    

    public Animation setMax(float max) {
        this.max = max;
        return this;
    }

    public Animation setMin(float min) {
        this.progressValue = min;
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
        float value = this.function.get(pastTime);
        if(value >= 1 || value <0){
            value = 1;
        }
        setProgressValue(value * (max - min));
        return getProgressValue();
    }

    public float update(){
        if(isFirstUpdate){
            setFirstTime(System.currentTimeMillis());
            isFirstUpdate = false;
        }

        return update(System.currentTimeMillis() - firstTime);
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

    public boolean isFinish(){
        if(getProgressValue() >= (getMax()-getMin())){
            return true;
        }
        return false;
    }

    public Animation reset(){
        setProgressValue(getMin());
        this.isFirstUpdate = true;
        return this;
    }



//    public Animation setReverse(boolean reverse){
//        this.reverse = reverse;
//        return this;
//    }
//
//    public boolean isReverse() {
//        return reverse;
//    }

    private long getFirstTime(){
        return firstTime;
    }

    private void setFirstTime(long firstTime){
        this.firstTime = firstTime;
    }
}
