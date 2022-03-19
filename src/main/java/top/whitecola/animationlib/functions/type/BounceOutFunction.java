package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;
import top.whitecola.animationlib.utils.AnimationFunctionUtils;

public class BounceOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {
        return AnimationFunctionUtils.getBounceOut(getElapsedTimeRate(pastTime));
    }
}
