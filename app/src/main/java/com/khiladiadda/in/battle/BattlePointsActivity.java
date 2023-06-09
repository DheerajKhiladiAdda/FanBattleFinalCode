package com.khiladiadda.in.battle;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.battle.interfaces.IBattlePresenter;
import com.khiladiadda.in.battle.interfaces.IBattleView;
import com.khiladiadda.in.battle.model.BannerResponse;
import com.khiladiadda.in.battle.model.BattleGroupResponse;
import com.khiladiadda.in.battle.model.BattleResponse;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.utility.NetworkStatus;

import butterknife.BindView;

public class BattlePointsActivity extends BaseActivity implements IBattleView {

    @BindView(R.id.iv_back) ImageView mBackIV;
    @BindView(R.id.tv_activity_name) TextView mActivityNameTV;
    @BindView(R.id.iv_notification) ImageView mNotificationIV;
    @BindView(R.id.iv_point) ImageView mPointIV;

    private IBattlePresenter mPresenter;

    @Override protected int getContentView() {
        return R.layout.activity_battle_points;
    }

    @Override protected void initViews() {
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mActivityNameTV.setText(getString(R.string.text_calculate_point_activity));
    }

    @Override protected void initVariables() {
        mPresenter = new BattlePresenter(this);
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getCalculationBanner();
        } else {
            Snackbar.make(mBackIV, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
            case R.id.tv_home:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
        }
    }

    @Override public void onGetBattleListComplete(BattleResponse responseModel) {

    }

    @Override public void onGetBattleListFailure(ApiError error) {

    }

    @Override public void onGetGroupListComplete(BattleGroupResponse responseModel) {

    }

    @Override public void onGetGroupListFailure(ApiError error) {

    }

    @Override public void onJoinComplete(BaseResponse responseModel) {

    }

    @Override public void onJoinFailure(ApiError error) {

    }

    @Override public void onGetCalculationBannerComplete(BannerResponse responseModel) {
        if (responseModel.getResponse().size() > 0) {
            if (!TextUtils.isEmpty(responseModel.getResponse().get(0).getImg())) {
                Glide.with(mPointIV).load(responseModel.getResponse().get(0).getImg()).placeholder(R.mipmap.ic_launcher).into(mPointIV);
            }
        }
        hideProgress();
    }

    @Override public void onGetCalculationBannerFailure(ApiError error) {

    }

    @Override public void onCancelComplete(BaseResponse responseModel) {

    }

    @Override public void onCancelFailure(ApiError error) {

    }

    @Override public void onJoinSubstituteComplete(BaseResponse responseModel) {

    }

    @Override public void onJoinSubstituteFailure(ApiError error) {

    }

    @Override protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

}