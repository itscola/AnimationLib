package top.whitecola.animationlib;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

import java.math.BigDecimal;

public strictfp class Animation {


//
//    {
//        new Throwable().printStackTrace();
//
//    }


    private volatile float max,min, progressValue;
    private long time;
    private boolean isFirstUpdate = true;
    private boolean reverse;
    private AbstractAnimationFunction function;
    private long firstTime;
    private volatile boolean lock;


    public Animation setReverse(boolean reverse) {
        if(!lock) {
            this.reverse = reverse;
//            setFirstTime(System.currentTimeMillis() - (((long)getTotalTime()) - Math.min(((long)getTotalTime()), System.currentTimeMillis()-getFirstTime())));
//            setFirstTime(System.currentTimeMillis()-getFirstTime());
//            setFirstTime((long) (System.currentTimeMillis() - (getTotalTime() - Math.min(getTotalTime(), System.currentTimeMillis()-getFirstTime()))));
//            setTotalTime((long) (getTotalTime()*2));
        }
        return this;
    }

    public boolean isReverse() {
        return reverse;
    }

    public strictfp Animation setMax(float max) {
        if(!lock) {
            this.max = max;
        }
        return this;
    }

    public strictfp Animation setMin(float min) {
        if(!lock) {
            this.progressValue = min;
            this.min = min;
        }
        return this;
    }

    public Animation setTotalTime(long time) {
        if(!lock) {
            this.time = time;
            if (function != null) {
                function.setTotalTime(time);
            }
        }
        return this;
    }


    public Animation setFunction(AbstractAnimationFunction function){
        if(!lock) {
            function.setTotalTime(time);
            this.function = function;
        }
        return this;
    }

    public float update(long pastTime){
        float value = this.function.get(pastTime);
        if(value >= 1 || value <0){
            return max;
        }
        if(isFinish()){
            return getMax();
        }
//        System.out.println(value+"*"+getMax()+"-"+getMin()+"     "+this.hashCode());
//
//        System.out.println((value * getMax()+"     "+this.hashCode()));

        if(!isReverse()){
            return value * (getMax()-getMin())+ getMin();
        }else {
            return max - (value * (getMax()-getMin())+ getMin());

        }
    }

    public float update(){
        if(isFirstUpdate){
            firstTime = System.currentTimeMillis();
            isFirstUpdate = false;
        }

        if(isFinish()){
           return getMax();
        }


        setProgressValue(update(System.currentTimeMillis() - getFirstTime()));


        return getProgressValue();
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
//        if(getProgressValue() >= (getMax())){
//            return true;
//        }

        if(System.currentTimeMillis()-firstTime>=time){
            return true;
        }
        return false;
    }


    /**
     * if noReverse is true , the time go forward.
     * if noReverse is false, the time go backward.
     * @param noReverse
     * @return
     */
    public boolean isFinish(boolean noReverse){
        if(isFinish()&&(this.isReverse()==!noReverse)){
            return true;
        }
        return false;
    }




    public Animation reset(){
        if(!lock) {
//            setProgressValue(getMin());
            this.isFirstUpdate = true;
        }
        return this;
    }


    public Animation setLock(boolean lock){
        lock = lock;
        return this;
    }

    public boolean getLock(){
        return lock;
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


    public void setFirstTime(long firstTime) {
        this.firstTime = firstTime;
    }

    private float absoluteAdd(float a, float b){
        BigDecimal a1 = new BigDecimal(a+"");
        return a1.add(new BigDecimal(b+"")).floatValue();
    }

}
