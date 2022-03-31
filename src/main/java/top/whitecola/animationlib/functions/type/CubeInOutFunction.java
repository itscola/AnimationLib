package top.whitecola.animationlib.functions.type;

import top.whitecola.animationlib.functions.AbstractAnimationFunction;

public class CubeInOutFunction extends AbstractAnimationFunction {
    @Override
    public float get(long pastTime) {
        float elapsedTimeRate = getElapsedTimeRate(pastTime);

        if ((elapsedTimeRate *= 2f) < 1f) {
            return (float) (-0.5f * (Math.sqrt(1f - elapsedTimeRate * elapsedTimeRate) - 1f));
        }
        return (float) (0.5f * (Math.sqrt(1f - (elapsedTimeRate -= 2f) * elapsedTimeRate) + 1f));
    }
}
