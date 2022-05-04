package com.techyourchance.mvc.screens.common.navdrawer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;

/**
 * Created by David Chhetri on 03,May,2022
 */
public abstract class BaseNavDrawerViewMvc<ListenerType>
        extends BaseObservableViewMvc<ListenerType> implements NavDrawerViewMvc{

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;


    public BaseNavDrawerViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        super.setRootView(inflater.inflate(R.layout.layout_drawer,parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                if(item.getItemId() == R.id.drawer_menu_questions_list ){
                    onDrawerItemClicked(DrawerItems.QUESTION_LIST);
                }
                return false;
            }
        });

    }
    @Override
    public void openDrawer(){
        mDrawerLayout.openDrawer(Gravity.START);
    }

    protected abstract void onDrawerItemClicked(DrawerItems item);

    @Override
    public void setRootView(View view) {
        mDrawerLayout.addView(view);

    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

}

