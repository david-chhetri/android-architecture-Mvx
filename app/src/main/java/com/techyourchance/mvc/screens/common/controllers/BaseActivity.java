package com.techyourchance.mvc.screens.common.controllers;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.mvc.CustomApplication;
import com.techyourchance.mvc.common.dependencyinjection.CompositionRoot;
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {
    private ControllerCompositionRoot mControllerCompositionRoot;

    public ControllerCompositionRoot getCompositionRoot(){
        if(mControllerCompositionRoot == null){
            mControllerCompositionRoot = new ControllerCompositionRoot((
                    (CustomApplication)getApplication()).getCompositionRoot(), this);
        }
        return mControllerCompositionRoot;
    }

}
