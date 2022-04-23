package com.techyourchance.mvc.screens.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by David Chhetri on 23,April,2022
 */
public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc
                            implements ObservableViewMvc<ListenerType>{

    private Set<ListenerType> mListeners = new HashSet<>();

    public void registerListener(ListenerType listener){
        mListeners.add(listener);
    }

    public void unregisterListener(ListenerType listener){
        mListeners.remove(listener);
    }

    public Set<ListenerType> getListeners(){
        return Collections.unmodifiableSet(mListeners);
    }



}
