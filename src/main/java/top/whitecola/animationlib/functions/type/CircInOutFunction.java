package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class CircInOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {
        float t = getElapsedTimeRate(pastTime);
        if (t < 0.5f) {
            return (float) (-0.5f * (Math.sqrt(1f - 4f * t * t) - 1f));
        }
        return (float) (0.5f * (Math.sqrt(1f - 4f * (t - 1f) * (t - 1f)) + 1f));
    }
}
