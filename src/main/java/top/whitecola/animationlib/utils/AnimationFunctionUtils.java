package top.whitecola.animationlib.utils;
//some function code from MasayukiSuda/EasingInterpolator repository

public class AnimationFunctionUtils {
    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param pow             pow The exponent to use (ex. 3 would return a cubic ease).
     * @return easedValue
     */
    public static float getPowIn(float elapsedTimeRate, double pow) {
        return (float) Math.pow(elapsedTimeRate, pow);
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param pow             pow The exponent to use (ex. 3 would return a cubic ease).
     * @return easedValue
     */
    public static float getPowOut(float elapsedTimeRate, double pow) {
        return (float) ((float) 1 - Math.pow(1 - elapsedTimeRate, pow));
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param pow             pow The exponent to use (ex. 3 would return a cubic ease).
     * @return easedValue
     */
    public static float getPowInOut(float elapsedTimeRate, double pow) {
        if ((elapsedTimeRate *= 2) < 1) {
            return (float) (0.5 * Math.pow(elapsedTimeRate, pow));
        }

        return (float) (1 - 0.5 * Math.abs(Math.pow(2 - elapsedTimeRate, pow)));
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param amount          amount The strength of the ease.
     * @return easedValue
     */
    public static float getBackInOut(float elapsedTimeRate, float amount) {
        amount *= 1.525;
        if ((elapsedTimeRate *= 2) < 1) {
            return (float) (0.5 * (elapsedTimeRate * elapsedTimeRate * ((amount + 1) * elapsedTimeRate - amount)));
        }
        return (float) (0.5 * ((elapsedTimeRate -= 2) * elapsedTimeRate * ((amount + 1) * elapsedTimeRate + amount) + 2));
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @return easedValue
     */
    public static float getBounceIn(float elapsedTimeRate) {
        return 1f - getBounceOut(1f - elapsedTimeRate);
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @return easedValue
     */
    public static float getBounceOut(float elapsedTimeRate) {
        if (elapsedTimeRate < 1 / 2.75) {
            return (float) (7.5625 * elapsedTimeRate * elapsedTimeRate);
        } else if (elapsedTimeRate < 2 / 2.75) {
            return (float) (7.5625 * (elapsedTimeRate -= 1.5 / 2.75) * elapsedTimeRate + 0.75);
        } else if (elapsedTimeRate < 2.5 / 2.75) {
            return (float) (7.5625 * (elapsedTimeRate -= 2.25 / 2.75) * elapsedTimeRate + 0.9375);
        } else {
            return (float) (7.5625 * (elapsedTimeRate -= 2.625 / 2.75) * elapsedTimeRate + 0.984375);
        }
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param amplitude       Amplitude of easing
     * @param period          Animation of period
     * @return easedValue
     */
    public static float getElasticIn(float elapsedTimeRate, double amplitude, double period) {
        if (elapsedTimeRate == 0 || elapsedTimeRate == 1) return elapsedTimeRate;
        double pi2 = Math.PI * 2;
        double s = period / pi2 * Math.asin(1 / amplitude);
        return (float) -(amplitude * Math.pow(2f, 10f * (elapsedTimeRate -= 1f)) * Math.sin((elapsedTimeRate - s) * pi2 / period));
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param amplitude       Amplitude of easing
     * @param period          Animation of period
     * @return easedValue
     */
    public static float getElasticOut(float elapsedTimeRate, double amplitude, double period) {
        if (elapsedTimeRate == 0 || elapsedTimeRate == 1) return elapsedTimeRate;

        double pi2 = Math.PI * 2;
        double s = period / pi2 * Math.asin(1 / amplitude);
        return (float) (amplitude * Math.pow(2, -10 * elapsedTimeRate) * Math.sin((elapsedTimeRate - s) * pi2 / period) + 1);
    }

    /**
     * @param elapsedTimeRate Elapsed time / Total time
     * @param amplitude       Amplitude of easing
     * @param period          Animation of period
     * @return easedValue
     */
    public static float getElasticInOut(float elapsedTimeRate, double amplitude, double period) {
        double pi2 = Math.PI * 2;

        double s = period / pi2 * Math.asin(1 / amplitude);
        if ((elapsedTimeRate *= 2) < 1) {
            return (float) (-0.5f * (amplitude * Math.pow(2, 10 * (elapsedTimeRate -= 1f)) * Math.sin((elapsedTimeRate - s) * pi2 / period)));
        }
        return (float) (amplitude * Math.pow(2, -10 * (elapsedTimeRate -= 1)) * Math.sin((elapsedTimeRate - s) * pi2 / period) * 0.5 + 1);

    }


}
