package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;
import top.whitecola.animationlib.utils.AnimationFunctionUtils;

public class CubicInOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {

        return AnimationFunctionUtils.getPowInOut(getElapsedTimeRate(pastTime), 3);
    }
}
