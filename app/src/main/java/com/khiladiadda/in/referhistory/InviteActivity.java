package com.khiladiadda.in.referhistory;

import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.help.HelpActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.utility.AppUtilityMethods;

import butterknife.BindView;

public class InviteActivity extends BaseActivity {

    @BindView(R.id.iv_back) ImageView mBackIV;
    @BindView(R.id.tv_activity_name) TextView mActivityNameTV;
    @BindView(R.id.iv_notification) ImageView mNotificationIV;
    @BindView(R.id.tv_home) TextView mHomeTV;
    @BindView(R.id.tv_help) TextView mHelpTV;
    @BindView(R.id.tv_invite_code) TextView mInviteCodeTV;
    @BindView(R.id.btn_whatsapp) Button mWhatsAppBTN;
    @BindView(R.id.btn_option) Button mOptionBTN;
    @BindView(R.id.tv_view) TextView mViewTV;
    @BindView(R.id.tv_refer_coins) TextView mReferCoinsTV;

    @Override protected int getContentView() {
        return R.layout.activity_invite;
    }

    @Override protected void initViews() {
        mViewTV.setOnClickListener(this);
        mActivityNameTV.setText(R.string.text_invite_friends);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mHomeTV.setOnClickListener(this);
        mHelpTV.setOnClickListener(this);
        mWhatsAppBTN.setOnClickListener(this);
        mOptionBTN.setOnClickListener(this);
    }

    @Override protected void initVariables() {
        mInviteCodeTV.setText(mAppPreference.getInviteCode());
        SpannableString ss1 = new SpannableString(mReferCoinsTV.getText().toString().trim());
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 24, ss1.length(), 0);
        ss1.setSpan(new RelativeSizeSpan(2f), 24, ss1.length(), 0); // set size
        ss1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 24, ss1.length(), 0);// set color
        mReferCoinsTV.setText(ss1);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                if (mAppPreference.getIsDeepLinking()) {
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    finish();
                }
                break;
            case R.id.tv_home:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_help:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.tv_view:
                startActivity(new Intent(this, ReferActivity.class));
                break;
            case R.id.btn_whatsapp:
                AppUtilityMethods.inviteOnWhatsApp(this, mOptionBTN);
                break;
            case R.id.btn_option:
                AppUtilityMethods.shareInviteCode(this);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mAppPreference.getIsDeepLinking()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            super.onBackPressed();
        }
    }

}