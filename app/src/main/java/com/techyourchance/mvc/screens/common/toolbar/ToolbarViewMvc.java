package com.techyourchance.mvc.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {

    public interface NavigateUpClickListener{
        void onNavigateUpClicked();
    }

    public interface HamburgerClickListener{
        void onHamburgerClicked();
    }

    private NavigateUpClickListener mNavigateUpClickListener;
    private HamburgerClickListener mHamburgerClickListener;
    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnHamburger = findViewById(R.id.btn_hamburger);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNavigateUpClickListener.onNavigateUpClicked();
            }
        });

        mBtnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHamburgerClickListener.onHamburgerClicked();
            }
        });
    }



    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener){
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);

    }

    public void enableHamburgerBtnAndListen(HamburgerClickListener hamburgerClickListener){
        mHamburgerClickListener = hamburgerClickListener;
        mBtnHamburger.setVisibility(View.VISIBLE);
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }
}
