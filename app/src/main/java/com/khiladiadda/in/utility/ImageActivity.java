package com.khiladiadda.in.utility;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;

import butterknife.BindView;

public class ImageActivity extends BaseActivity {

    @BindView(R.id.iv_image)
    TouchImageView mImageIV;
    @BindView(R.id.ib_exit)
    ImageButton mExitIB;
    private String mFrom;
    Handler handler = new Handler();

    @Override
    protected int getContentView() {
        return R.layout.activity_image;
    }

    @Override
    protected void initViews() {
        mExitIB.setOnClickListener(this);
        mFrom = getIntent().getStringExtra(AppConstant.FROM);
//        if (mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_BGMI) || mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_TDM)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            mImageIV.setBackground(getResources().getDrawable(R.drawable.pubg_c)); //pubg_c replace with pubg
//        }
//        else if (mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_FREEFIRE) || mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_FF_CLASH) || mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_FF_MAX)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            mImageIV.setBackground(getResources().getDrawable(R.drawable.ff_c));
//        }
//        else if (mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_PUBG_GLOBAL) || mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_PREMIUM_ESPORTS)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            mImageIV.setBackground(getResources().getDrawable(R.drawable.pubg_c));
//        } else if (mFrom.equalsIgnoreCase(AppConstant.FROM_VIEW_LUDO)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        }
//        else if (mFrom.equalsIgnoreCase(AppConstant.LUDO_BUDDY)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            mAppPreference.setBoolean(AppConstant.LUDO_BUDDY, true);
//            mImageIV.setBackground(getResources().getDrawable(R.drawable.buddy));
//        }

        if (mFrom.equalsIgnoreCase(AppConstant.HELPSECTION)) {
            mExitIB.setVisibility(View.GONE);
            handler.postDelayed(runnable, 4000);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            mImageIV.setBackground(getResources().getDrawable(R.drawable.support_help));
        }
    }

    @Override
    protected void initVariables() {
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_exit) {
            onBackPressed();

        }
    }

    @Override
    public void onBackPressed() {
        if (!mFrom.equalsIgnoreCase(AppConstant.HELPSECTION)) {
            super.onBackPressed();
        }
    }

    Runnable runnable = this::openNextScreen;

    private void openNextScreen() {
        setResult(RESULT_OK);
        finish();
    }

}