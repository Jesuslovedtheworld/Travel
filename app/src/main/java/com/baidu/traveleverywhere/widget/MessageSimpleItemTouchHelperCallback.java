package com.baidu.traveleverywhere.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.FrameLayout;

import com.baidu.traveleverywhere.adapter.MessageInfoRlvAdapter;

public class MessageSimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private MessageItemTouchHelperAdapter itemTouchHelperAdapter;

    private boolean mSwipeEnable =true;
    //限制ImageView长度所能增加的最大值
    private double ICON_MAX_SIZE = 50;
    //ImageView的初始长宽
    private int fixedWidth = 150;
    private FrameLayout.LayoutParams params;
    public MessageSimpleItemTouchHelperCallback(MessageItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.itemTouchHelperAdapter = itemTouchHelperAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        itemTouchHelperAdapter.onItemMove(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        itemTouchHelperAdapter.onItemDelete(viewHolder.getAdapterPosition());
    }

    public void setmSwipeEnable(boolean mSwipeEnable) {
        this.mSwipeEnable = mSwipeEnable;
    }
    /* @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        //重复改变
        viewHolder.itemView.setScaleX(0);
        ((adapter.NormalItem) viewHolder).tv.setText("左滑删除");
        (FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ((MyAdapter.NormalItem) viewHolder).iv.getLayoutParams();
        params.width = 150;
        params.height = 150;
        ((adapter.NormalItem) viewHolder).iv.setLayoutParams(params);
        ((adapter.NormalItem) viewHolder).iv.setVisibility(View.INVISIBLE);

    }*/
}
