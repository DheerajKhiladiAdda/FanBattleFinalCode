package com.khiladiadda.in.help;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.help.interfaces.IHelpPresenter;
import com.khiladiadda.in.help.interfaces.IHelpView;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.FaqCategoryResponse;
import com.khiladiadda.in.network.model.response.HelpResponse;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.NetworkStatus;

import butterknife.BindView;

public class HelpActivity extends BaseActivity implements IHelpView {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.iv_fanbattle)
    ImageView mFanBattleIV;
    @BindView(R.id.cv_deposit)
    ImageView mDepositCV;
    @BindView(R.id.cv_withdraw)
    ImageView mWithdrawCV;
    @BindView(R.id.cv_kyc)
    ImageView mKycCV;
    @BindView(R.id.iv_hthhelp)
    ImageView mHTHIV;
    @BindView(R.id.cv_other)
    ImageView mOtherCV;

    private IHelpPresenter mPresenter;
    private boolean mSupportVia;
    private String mFrom;

    @Override
    protected int getContentView() {
        return R.layout.activity_help;
    }

    @Override
    protected void initViews() {
        mActivityNameTV.setText(R.string.text_help);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mDepositCV.setOnClickListener(this);
        mWithdrawCV.setOnClickListener(this);
        mKycCV.setOnClickListener(this);
        mFanBattleIV.setOnClickListener(this);
        mHTHIV.setOnClickListener(this);
        mOtherCV.setOnClickListener(this);

    }

    @Override
    protected void initVariables() {
        mPresenter = new HelpPresenter(this);
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getFaqCategory();
        } else {
            Snackbar.make(mActivityNameTV, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.iv_back:
                if (mAppPreference.getIsDeepLinking()) {
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    finish();
                }
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.iv_fanbattle:  //fb
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(4));
                startActivity(i);
                break;
            case R.id.iv_hthhelp:
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(5));
                startActivity(i);
                break;
            case R.id.cv_kyc:
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(3));
                startActivity(i);
                break;
            case R.id.cv_other:
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(2));
                startActivity(i);
                break;
            case R.id.cv_withdraw:
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(1));
                startActivity(i);
                break;
            case R.id.cv_deposit:
                i = new Intent(this, HelpDetailsActivity.class);
                i.putExtra(AppConstant.DATA, mAppPreference.getFaqCategoryData().getResponse().get(0));
                startActivity(i);
                break;


        }
    }

    @Override
    public void onGetCategoryComplete(FaqCategoryResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            mSupportVia = responseModel.getSupportVia() != 0;
            mAppPreference.setFAQCategoryData(responseModel);
        }
    }

    @Override
    public void onGetCategoryFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onHelpComplete(HelpResponse responseModel) {
    }

    @Override
    public void onHelpFailure(ApiError error) {
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (mAppPreference.getIsDeepLinking()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            finish();
        }
    }


}