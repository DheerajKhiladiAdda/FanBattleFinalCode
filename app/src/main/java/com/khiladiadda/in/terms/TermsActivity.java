package com.khiladiadda.in.terms;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.utility.AppConstant;

import butterknife.BindView;

public class TermsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_terms;
    }

    @Override
    protected void initViews() {
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        String from = getIntent().getStringExtra(AppConstant.FROM);
        mWebview.getSettings().setLoadsImagesAutomatically(true);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebview.setWebViewClient(new WebViewClient());

        if (from.equalsIgnoreCase(AppConstant.TERMS)) {
            mActivityNameTV.setText(R.string.text_term_condition);
            mWebview.loadUrl(AppConstant.URL_HOME + "terms-and-conditions");
        } else if (from.equalsIgnoreCase(AppConstant.LEGALITY)) {
            mActivityNameTV.setText(R.string.text_legality);
            mWebview.loadUrl(AppConstant.URL_HOME + "legality");
        } else if (from.equalsIgnoreCase(AppConstant.PRIVACY)) {
            mActivityNameTV.setText(R.string.text_privacy_policy);
            mWebview.loadUrl(AppConstant.URL_HOME + "privacy-policy");
        } else if (from.equalsIgnoreCase(AppConstant.CANCELLATION)) {
            mActivityNameTV.setText(R.string.text_cancellation_policy);
            mWebview.loadUrl(AppConstant.URL_HOME + "cancellation-policy");
        } else if (from.equalsIgnoreCase(AppConstant.CONTACT)) {
            mActivityNameTV.setText(R.string.text_contact_us);
            mWebview.loadUrl(AppConstant.URL_HOME + "contact-us");
        } else if (from.equalsIgnoreCase(AppConstant.ABOUT)) {
            mActivityNameTV.setText(R.string.text_about_us);
            mWebview.loadUrl(AppConstant.URL_HOME + "about");
        }else if (from.equalsIgnoreCase(AppConstant.PATYMUPI)){
            mActivityNameTV.setText(R.string.paytm_upi);
            mWebview.loadUrl(AppConstant.URL_HOME + "payout-help");
        }
    }

    @Override
    protected void initVariables() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
        }
    }

}