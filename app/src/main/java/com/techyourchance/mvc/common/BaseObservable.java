package com.techyourchance.mvc.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by David Chhetri on 24,April,2022
 */
public abstract class BaseObservable<LISTENER_CLASS> {

    private Set<LISTENER_CLASS> mListeners = Collections.newSetFromMap(
            new ConcurrentHashMap<LISTENER_CLASS, Boolean>(1)
    );

    public void registerListener(LISTENER_CLASS listener){
        mListeners.add(listener);
    }

    public void unregisterListener(LISTENER_CLASS listener){
        mListeners.remove(listener);
    }

    public Set<LISTENER_CLASS> getListeners(){
        return Collections.unmodifiableSet(mListeners);
    }


}

