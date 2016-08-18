package com.krazijames.lib.view.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jinwook.baek on 2016. 8. 18..
 */
public abstract class BaseRecyclerViewAdapter<E, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements ListAdapter<E> {
    private List<E> mDataSet = new ArrayList();

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public List<E> getDataSet() {
        return mDataSet;
    }

    @Override
    public void setDataSet(List<E> dataSet) {
        if (dataSet == null) {
            mDataSet = new ArrayList();
            return;
        }
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public void addItem(E item) {
        mDataSet.add(item);
        notifyItemInserted(mDataSet.indexOf(item));
    }

    @Override
    public void addItems(Collection<? extends E> items) {
        int firstIndex = mDataSet.size();
        mDataSet.addAll(items);
        notifyItemRangeInserted(firstIndex, items.size());
    }

    @Override
    public void insertItem(int position, E item) {
        mDataSet.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public void moveItem(int fromPosition, int toPosition) {
        mDataSet.add(toPosition, mDataSet.remove(fromPosition));
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void setItem(int position, E item) {
        mDataSet.set(position, item);
        notifyItemChanged(position);
    }

    @Override
    public E removeItem(int position) {
        E item = mDataSet.remove(position);
        notifyItemRemoved(position);
        return item;
    }

    @Override
    public void clearItems() {
        int itemCount = mDataSet.size();
        mDataSet.clear();
        notifyItemRangeRemoved(0, itemCount);
    }
}
