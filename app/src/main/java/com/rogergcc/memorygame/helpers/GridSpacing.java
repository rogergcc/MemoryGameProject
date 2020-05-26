package com.rogergcc.memorygame.helpers;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by rogergcc on 7/05/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
public class GridSpacing extends RecyclerView.ItemDecoration {
    private final int spacing;

    public GridSpacing(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing;
        outRect.top = spacing;
    }
}