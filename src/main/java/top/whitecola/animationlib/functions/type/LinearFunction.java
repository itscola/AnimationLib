package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class LinearFunction extends AbstractAnimationFunction {



    @Override
    public float get(long pastTime) {
        return getElapsedTimeRate(pastTime);
    }
}
