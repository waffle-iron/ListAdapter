package com.krazijames.lib.view.adapter;

import java.util.Collection;
import java.util.List;

/**
 * Created by jinwook.baek on 2016. 8. 18..
 */
public interface ListAdapter<E> {
    List<E> getDataSet();
    void setDataSet(List<E> dataSet);

    void addItem(E item);
    void addItems(Collection<? extends E> items);
    void insertItem(int position, E item);
    void moveItem(int fromPosition, int toPosition);
    void setItem(int position, E item);
    E removeItem(int position);
    void clearItems();
}
