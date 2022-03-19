package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;
import top.whitecola.animationlib.utils.AnimationFunctionUtils;

public class BounceInOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {
        float elapsedTimeRate = getElapsedTimeRate(pastTime);
        if (elapsedTimeRate < 0.5f) {
            return AnimationFunctionUtils.getBounceIn((elapsedTimeRate * 2f) * 0.5f);
        }
        return elapsedTimeRate;
    }

}
