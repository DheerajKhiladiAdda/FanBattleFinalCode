package com.khiladiadda.in.otp;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.appsflyer.AppsFlyerLib;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.login.LoginActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.LoginResponse;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;
import com.khiladiadda.in.otp.interfaces.IOtpPresenter;
import com.khiladiadda.in.otp.interfaces.IOtpView;
import com.khiladiadda.in.preference.AppSharedPreference;
import com.khiladiadda.in.registration.RegistrationActivity;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.utility.PermissionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class OtpActivity extends BaseActivity implements IOtpView, View.OnKeyListener {

    @BindView(R.id.btn_register)
    Button mRegisterBTN;
    @BindView(R.id.et_one)
    EditText mOneET;
    @BindView(R.id.et_two)
    EditText mTwoET;
    @BindView(R.id.et_three)
    EditText mThreeET;
    @BindView(R.id.et_four)
    EditText mFourET;
    @BindView(R.id.et_five)
    EditText mFiveET;
    @BindView(R.id.et_six)
    EditText mSixET;
    @BindView(R.id.tv_resend)
    TextView mResendTV;
    @BindView(R.id.tv_mobile)
    TextView mMobileTV;
    @BindView(R.id.ll_need_support)
    LinearLayout mNeedSupportLL;
    @BindView(R.id.tv_changenumber)
    TextView mChangeNumberTV;

    private boolean back;
    private IOtpPresenter mPresenter;
    private String mMobileNumber, mOtp;
    private List<EditText> mEditTexts;
    private int mFrom;

    @Override
    protected int getContentView() {
        return R.layout.activity_otp;
    }

    @Override
    protected void initViews() {
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        mEditTexts = Arrays.asList(mOneET, mTwoET, mThreeET, mFourET, mFiveET, mSixET);
        mFrom = getIntent().getIntExtra(AppConstant.FROM, 0);
        mMobileNumber = getIntent().getStringExtra(AppConstant.MobileNumber);
        mMobileTV.setText(mMobileNumber);
        SpannableString needsupportString = new SpannableString(mResendTV.getText().toString());
        needsupportString.setSpan(new UnderlineSpan(), 0, 10, 0);
        mResendTV.setText(needsupportString);
        SpannableString ChangeNumberString = new SpannableString(mChangeNumberTV.getText().toString());
        ChangeNumberString.setSpan(new UnderlineSpan(), 0, 13, 0);
        mChangeNumberTV.setText(ChangeNumberString);
        if (mFrom == AppConstant.FROM_LOGIN) {
            mRegisterBTN.setText(R.string.text_verify_login);
        }

    }

    @Override
    protected void initVariables() {
        mPresenter = new OtpPresenter(this);
        mRegisterBTN.setOnClickListener(this);
        mResendTV.setOnClickListener(this);
        mChangeNumberTV.setOnClickListener(this);
        mNeedSupportLL.setOnClickListener(this);
        for (int i = 0; i < mEditTexts.size(); i++) {
            EditText editText = mEditTexts.get(i);
            editText.addTextChangedListener(new OtpTextWatcher(i));
            editText.setOnKeyListener(this);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                mPresenter.validateData();
                break;
            case R.id.tv_resend:
                if (new NetworkStatus(this).isInternetOn()) {
                    showProgress(getString(R.string.txt_progress_authentication));
                    mPresenter.resendOtp(mMobileNumber);
                } else {
                    Snackbar.make(mRegisterBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_need_support:
                openWhatsappContact();
                break;
            case R.id.tv_changenumber:
                onBackPressed();
                break;
        }
    }

    @Override
    public String getOtp() {
        mOtp = mOneET.getText().toString().trim() + mTwoET.getText().toString().trim() + mThreeET.getText().toString().trim() + mFourET.getText().toString().trim() + mFiveET.getText().toString().trim() + mSixET.getText().toString().trim();
        return mOtp;
    }

    @Override
    public void onValidationComplete() {
        if (new NetworkStatus(this).isInternetOn()) {
            back = true;
            showProgress(getString(R.string.txt_progress_authentication));
            if (mFrom == AppConstant.FROM_REGISTRATION_OTP) {
                mPresenter.doVerifyOtp(mMobileNumber, mOtp);
            } else {
                mPresenter.doVerifyLoginOtp(getIntent().getStringExtra(AppConstant.MobileNumber), getIntent().getStringExtra(AppConstant.PAST), mOtp);
            }
        } else {
            Snackbar.make(mRegisterBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onValidationFailure(String errorMsg) {
        AppUtilityMethods.showMsg(this, errorMsg, false);
    }

    @Override
    public void onVerifyOtpComplete(OtpResponse responseModel) {
        if (responseModel.isStatus()) {
            mPresenter.getMasterData();
            mAppPreference.setSessionToken(responseModel.getJwt());
            mAppPreference.setIsLogin(true);
        } else {
            hideProgress();
            AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
            back = false;
        }
    }

    @Override
    public void onVerifyOtpFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onResendOtpComplete(OtpResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            Snackbar.make(mRegisterBTN, R.string.text_otp_send_successfully, Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(mRegisterBTN, responseModel.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResendOtpFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onVerifyLoginOtpComplete(LoginResponse responseModel) {
        if (responseModel.isStatus()) {
            mAppPreference.setSessionToken(responseModel.getJwt());
            mAppPreference.setIsLogin(true);
            mPresenter.getMasterData();
        } else {
            hideProgress();
            AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
            back = false;
        }
    }
    @Override
    public void onVerifyLoginOtpFailure(ApiError error) {
        hideProgress();
        AppUtilityMethods.showMsg(this, error.getMessage(), false);
        back = false;
    }
    @Override
    public void onMasterComplete(MasterResponse responseModel){
        AppUtilityMethods.saveMasterData(responseModel);
        appsFlyer("",""+AppSharedPreference.getInstance().getMasterData().getResponse().getProfile().getMobile(), getIntent().getIntExtra(AppConstant.FROM, 0));
        hideProgress();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onMasterFailure(ApiError error){
        hideProgress();
    }
    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        if (back) {

        } else {
            Intent i = new Intent(this, RegistrationActivity.class);
            if (mFrom == AppConstant.FROM_LOGIN) {
                i = new Intent(this, LoginActivity.class);
            }
            startActivity(i);
            finish();
            super.onBackPressed();
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            EditText editText = (EditText) v;
            int editTextIndex = mEditTexts.indexOf(editText);
            if (editTextIndex > 0 && editText.getText().toString().length() == 0) {
                mEditTexts.get(editTextIndex - 1).requestFocus();
                mEditTexts.get(editTextIndex - 1).setCursorVisible(true);
                return true;
            }
            return false;
        }
        return false;
    }

    private class OtpTextWatcher implements TextWatcher {

        private int mEditTextIndex;

        private OtpTextWatcher(int editTextIndex) {
            mEditTextIndex = editTextIndex;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mEditTextIndex < 5) {
                if (s.length() == 1) {
                    mEditTexts.get(mEditTextIndex).clearFocus();
                    mEditTexts.get(mEditTextIndex + 1).requestFocus();
                    mEditTexts.get(mEditTextIndex + 1).setCursorVisible(true);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == AppConstant.RC_ASK_PERMISSIONS_MSG) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.txt_read_sms_permission), Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void updateOtp(String message) {
        if (message.length() < 6) {
            return;
        }
        for (int i = 0; i < mEditTexts.size(); i++) {
            mEditTexts.get(i).setText(String.valueOf(message.charAt(i)));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    void openWhatsappContact() {
        String url = "https://wa.me/91" + mAppPreference.getSupportNumber() + "" + "?text=Hello%20I%20have%20a%20problem";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    private void appsFlyer(String socialName,String mMobileNumber,int mFrom) {
        Map<String, Object> eventParameters2=new HashMap<>();
        eventParameters2.put(AppConstant.LOGIN_NUMBER,mMobileNumber);
        //eventParameters2.put(AppConstant.LOGIN_METHOD,socialName );
        if (mFrom==(AppConstant.FROM_LOGIN)) {
            eventParameters2.put(AppConstant.LOGIN,"login");
            AppsFlyerLib.getInstance().logEvent(getApplicationContext(),AppConstant.LOGIN, eventParameters2);
        } else {
            eventParameters2.put(AppConstant.REGISTER,"Register");
            AppsFlyerLib.getInstance().logEvent(getApplicationContext(),AppConstant.REGISTER, eventParameters2);
        }

    }
}