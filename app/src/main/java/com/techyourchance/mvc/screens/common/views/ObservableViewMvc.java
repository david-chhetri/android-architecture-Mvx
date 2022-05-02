package com.techyourchance.mvc.screens.common.views;

/**
 * Created by David Chhetri on 23,April,2022
 */
public interface ObservableViewMvc<ListenerType> extends ViewMvc{

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
