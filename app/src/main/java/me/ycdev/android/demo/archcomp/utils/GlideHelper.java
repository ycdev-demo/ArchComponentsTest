package me.ycdev.android.demo.archcomp.utils;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static me.ycdev.android.demo.archcomp.utils.GlideHelper.CornerType.ALL;
import static me.ycdev.android.demo.archcomp.utils.GlideHelper.CornerType.BOTTOM;
import static me.ycdev.android.demo.archcomp.utils.GlideHelper.CornerType.TOP;

public class GlideHelper {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {ALL, TOP, BOTTOM})
    public @interface CornerType {
        int ALL = 1;
        int TOP = 2;
        int BOTTOM = 3;
    }

    public static RoundedCornersTransformation createBitmapRoundedCorners(
            @NonNull Context context, int radius) {
        return new RoundedCornersTransformation(radius, 0);
    }

    public static RoundedCornersTransformation createBitmapRoundedCorners(
            @NonNull Context context, int radius, @CornerType int cornerType) {
        if (cornerType == ALL) {
            return new RoundedCornersTransformation(radius, 0);
        } else if (cornerType == TOP) {
            return new RoundedCornersTransformation(radius, 0,
                    RoundedCornersTransformation.CornerType.TOP);
        } else if (cornerType == BOTTOM) {
            return new RoundedCornersTransformation(radius, 0,
                    RoundedCornersTransformation.CornerType.BOTTOM);
        } else {
            throw new RuntimeException("not supported cornerType: " + cornerType);
        }
    }
}
