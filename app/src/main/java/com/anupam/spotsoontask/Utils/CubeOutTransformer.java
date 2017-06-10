package com.anupam.spotsoontask.Utils;

import android.view.View;

/**
 * Created by Anupam on 09-06-17.
 */
public class CubeOutTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0f ? view.getWidth() : 0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(90f * position);
    }
    @Override
    public boolean isPagingEnabled() {
        return true;
    }

}
