package com.khiladiadda.in.login;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.khiladiadda.in.R;
import com.khiladiadda.in.dialogs.interfaces.IOnSocialLoginErrorListener;
import com.khiladiadda.in.utility.AppConstant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FBErrorDialog extends Dialog implements View.OnClickListener {

    private IOnSocialLoginErrorListener mOnSocialLoginErrorListener;
    @BindView(R.id.tv_hint) TextView mHintTV;
    @BindView(R.id.tv_google) TextView mGoogleBTN;
    @BindView(R.id.tv_mobile) TextView mMobileBTN;
    @BindView(R.id.tv_forgot_pwd) TextView mForgotPwddBTN;
    @BindView(R.id.btn_ok) Button mOkBTN;
    @BindView(R.id.tv_new_user) TextView mNewUserTV;
    @BindView(R.id.tv_return_user) TextView mReturnUserTV;
    private boolean mFrom;

    public FBErrorDialog(@NonNull Context context, boolean fromFb, IOnSocialLoginErrorListener onSocialLoginErrorListener) {
        super(context);
        this.mFrom = fromFb;
        this.mOnSocialLoginErrorListener = onSocialLoginErrorListener;
        init();
    }

    private void init() {
        initDialog();
        initViews();
        show();
    }

    private void initDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fb_error_dialog);
        getWindow().setBackgroundDrawableResource(R.color.colorTransparent);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void initViews() {
        ButterKnife.bind(this);
        mGoogleBTN.setOnClickListener(this);
        mMobileBTN.setOnClickListener(this);
        mForgotPwddBTN.setOnClickListener(this);
        mOkBTN.setOnClickListener(this);

        String s = AppConstant.TEXT_Click_Forgot_Password;
        SpannableString content = new SpannableString(s);
        content.setSpan(new UnderlineSpan(), 8, s.length(), 0);
        content.setSpan(new ForegroundColorSpan(mForgotPwddBTN.getContext().getResources().getColor(R.color.colorPrimary)), 8, s.length(), 0);// set color
        mForgotPwddBTN.setText(content);

        mNewUserTV.setTypeface(null, Typeface.BOLD);
        mReturnUserTV.setTypeface(null, Typeface.BOLD);

        if(!mFrom){
            mHintTV.setText(R.string.text_gmail_login_error);
            mGoogleBTN.setText(R.string.text_fb);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_google:
            case R.id.btn_ok:
            case R.id.tv_forgot_pwd:
                cancel();
                break;
            case R.id.tv_mobile:
                mOnSocialLoginErrorListener.onRegister();
                //                mOnSocialLoginErrorListener.onForgotPassword();
                cancel();
                break;
        }
    }

}