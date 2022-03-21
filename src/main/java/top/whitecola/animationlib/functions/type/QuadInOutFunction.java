package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;
import top.whitecola.animationlib.utils.AnimationFunctionUtils;

public class QuadInOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {
        System.out.println(getElapsedTimeRate(pastTime)+"!!!!!");
        System.out.println(AnimationFunctionUtils.getPowInOut(getElapsedTimeRate(pastTime), 2));
        return AnimationFunctionUtils.getPowInOut(getElapsedTimeRate(pastTime), 2);
    }
}
