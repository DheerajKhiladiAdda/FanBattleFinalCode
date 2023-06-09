package com.khiladiadda.in.setting;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.fcm.NotificationHelpActivity;
import com.khiladiadda.in.help.HelpActivity;
import com.khiladiadda.in.terms.TermsActivity;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;

import butterknife.BindView;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back) ImageView mBackIV;
    @BindView(R.id.tv_activity_name) TextView mActivityNameTV;
    @BindView(R.id.iv_notification) ImageView mNotificationIV;
    @BindView(R.id.tv_term_condition) TextView mTermsConditionTV;
    @BindView(R.id.tv_privacy_policy) TextView mPrivacyPolicyTV;
    @BindView(R.id.tv_legality) TextView mLegalityTV;
    @BindView(R.id.tv_cancellation_policy) TextView mCancellationPolicyTV;
    @BindView(R.id.tv_contact_us) TextView mContactUsTV;
    @BindView(R.id.tv_about_us) TextView mAboutUsTV;
    @BindView(R.id.tv_notification) TextView mNotificationTV;
    @BindView(R.id.tv_logout) TextView mLogoutTV;

    @Override protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override protected void initViews() {
        mActivityNameTV.setText(R.string.action_settings);
    }

    @Override protected void initVariables() {
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mTermsConditionTV.setOnClickListener(this);
        mLegalityTV.setOnClickListener(this);
        mPrivacyPolicyTV.setOnClickListener(this);
        mCancellationPolicyTV.setOnClickListener(this);
        mAboutUsTV.setOnClickListener(this);
        mContactUsTV.setOnClickListener(this);
        mNotificationTV.setOnClickListener(this);
        mLogoutTV.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        Intent terms = new Intent(this, TermsActivity.class);
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_term_condition:
                terms.putExtra(AppConstant.FROM, AppConstant.TERMS);
                startActivity(terms);
                break;
            case R.id.tv_legality:
                terms.putExtra(AppConstant.FROM, AppConstant.LEGALITY);
                startActivity(terms);
                break;
            case R.id.tv_privacy_policy:
                terms.putExtra(AppConstant.FROM, AppConstant.PRIVACY);
                startActivity(terms);
                break;
            case R.id.tv_cancellation_policy:
                terms.putExtra(AppConstant.FROM, AppConstant.CANCELLATION);
                startActivity(terms);
                break;
            case R.id.tv_about_us:
                terms.putExtra(AppConstant.FROM, AppConstant.ABOUT);
                startActivity(terms);
                break;
            case R.id.tv_contact_us:
                //                terms.putExtra(AppConstant.FROM, AppConstant.CONTACT);
                //                startActivity(terms);
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.tv_notification:
                startActivity(new Intent(this, NotificationHelpActivity.class));
                break;
            case R.id.tv_logout:
                AppUtilityMethods.showLogout(this, AppConstant.FROM_LOGOUT, "");
                break;
        }
    }

}