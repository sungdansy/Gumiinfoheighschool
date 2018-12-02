package kr.kro.sosohanbox.gumiinformationschool;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VerticalSpace extends RecyclerView.ItemDecoration {

    int Space;

    public VerticalSpace(int Space) {
        this.Space = Space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = Space;
        outRect.bottom = Space;
        outRect.right = Space;
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = Space;
        }
    }
}
