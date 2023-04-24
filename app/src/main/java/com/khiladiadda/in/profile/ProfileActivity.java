package com.khiladiadda.in.profile;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.dialogs.interfaces.IOnVerifyEmailListener;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.forgotpassword.ForgotPasswordActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.ProfileDetails;
import com.khiladiadda.in.network.model.response.ProfileResponse;
import com.khiladiadda.in.network.model.response.ProfileTransactionResponse;
import com.khiladiadda.in.profile.interfaces.IProfilePresenter;
import com.khiladiadda.in.profile.interfaces.IProfileView;
import com.khiladiadda.in.profile.update.AadharActivity;
import com.khiladiadda.in.profile.update.PanActivity;
import com.khiladiadda.in.profile.update.UpdateProfileActivity;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.utility.PermissionUtils;

import butterknife.BindView;

public class ProfileActivity extends BaseActivity implements IProfileView {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.iv_profile)
    ImageView mProfileIV;
    @BindView(R.id.tv_name)
    TextView mNameTV;
    @BindView(R.id.tv_id)
    TextView mIdTV;
    @BindView(R.id.tv_email)
    TextView mEmailTV;
    @BindView(R.id.tv_mobile)
    TextView mMobileTV;
    @BindView(R.id.tv_update_mobile)
    TextView mUpdateMobileTV;
    @BindView(R.id.tv_country)
    TextView mCountryTV;
    @BindView(R.id.iv_edit)
    ImageView mEditIV;
    @BindView(R.id.tv_change_pwd)
    TextView mChangePwdTV;
    @BindView(R.id.tv_dob)
    TextView mDobTV;
    @BindView(R.id.tv_pan)
    TextView mPanTV;
    @BindView(R.id.tv_aadhar)
    TextView mAadharTV;
    @BindView(R.id.tv_change_dob)
    TextView mChangeDobTV;
    @BindView(R.id.tv_invite_code)
    TextView mInviteCodeTV;
    @BindView(R.id.tv_change_pan)
    TextView mChangePanTV;
    @BindView(R.id.tv_change_aadhar)
    TextView mChangeAadharTV;
    @BindView(R.id.tv_profile_percentage)
    TextView mProfilePercentTV;
    @BindView(R.id.pb_profile_progress)
    ProgressBar mProfileProgressPB;
    @BindView(R.id.tv_profile_complete_msg)
    TextView mProfilePercentMsgTV;
    @BindView(R.id.tv_share)
    TextView mShareInviteCodeTV;
    @BindView(R.id.tv_update_email)
    TextView mUpdateEmailTV;
    @BindView(R.id.tv_u_email)
    TextView mShowEmailTV;
    private IProfilePresenter mPresenter;
    private String mNewEmail;
    @Override
    protected int getContentView(){
        return R.layout.activity_profile;
    }
    @Override
    protected void initViews(){
        mActivityNameTV.setText(R.string.my_profile);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mUpdateMobileTV.setOnClickListener(this);
        mChangePwdTV.setOnClickListener(this);
        mChangeDobTV.setOnClickListener(this);
        mChangePanTV.setOnClickListener(this);
        mChangeAadharTV.setOnClickListener(this);
        mEditIV.setOnClickListener(this);
        mShareInviteCodeTV.setOnClickListener(this);
        mUpdateEmailTV.setOnClickListener(this);
    }

    @Override
    protected void initVariables() {
        mPresenter = new ProfilePresenter(this);
    }

    private void getProfile() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getProfile();
        } else {
            setProfileData();
            Snackbar.make(mBackIV, getString(R.string.error_internet), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
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
            case R.id.tv_change_pan:
                Intent pan = new Intent(this, PanActivity.class);
                startActivity(pan);
                break;
            case R.id.tv_change_aadhar:
                Intent aadhar = new Intent(this, AadharActivity.class);
                aadhar.putExtra(AppConstant.FROM, AppConstant.FROM_PAYU);
                startActivity(aadhar);
                break;
            case R.id.tv_update_mobile:
                Intent addMobileNumber = new Intent(this, ForgotPasswordActivity.class);
                addMobileNumber.putExtra(AppConstant.FROM, AppConstant.FROM_UPDATE_MOBILE);
                startActivity(addMobileNumber);
                finish();
                break;
            case R.id.iv_edit:
                if (!PermissionUtils.hasStoragePermission(this)) {
                    Snackbar.make(mPanTV, R.string.txt_allow_permission, Snackbar.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, UpdateProfileActivity.class));
                    finish();
                }
                break;
            case R.id.tv_share:
                AppUtilityMethods.shareInviteCode(this);
                break;
            case R.id.tv_update_email:
                new EmailDialog(this, onVerifyEmailAddressListener, 1, "", false);
                break;


        }
    }

    @Override
    public void onUpdatePasswordComplete(BaseResponse responseModel) {
        hideProgress();
        mAppPreference.setIsProfile(false);
        AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
    }

    @Override
    public void onUpdatePasswordFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onUpdateDOBComplete(ProfileResponse responseModel) {
        hideProgress();
        showMsg(responseModel.getMessage());
    }

    @Override
    public void onUpdateDOBFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onProfileComplete(ProfileTransactionResponse responseModel) {
        hideProgress();
        mAppPreference.setIsProfile(true);
        mAppPreference.setProfileData(responseModel.getResponse());
        setProfileData();
    }



    @Override
    public void onProfileFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onApplyVoucherComplete(BaseResponse responseModel) {

    }

    @Override
    public void onApplyVoucherFailure(ApiError error) {

    }

    @Override
    public void onSendOtpComplete(BaseResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            new EmailDialog(this, onVerifyEmailAddressListener, 2, mNewEmail, false);
        } else {
            AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
        }
    }

    @Override
    public void onSendOtpFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onVerifyEmailComplete(BaseResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
            getProfile();
        } else {
            new EmailDialog(this, onVerifyEmailAddressListener, 2, mNewEmail, true);
        }
    }

    @Override
    public void onVerifyEmailFailure(ApiError error) {
        hideProgress();
    }

    private void setProfileData() {
        ProfileDetails mProfileDetails = mAppPreference.getProfileData();
        mAppPreference.setEmail(mProfileDetails.getEmail());
        mAppPreference.setName(mProfileDetails.getName());
        mAppPreference.setUrl(mProfileDetails.getDp());
        mAppPreference.setInviteCode(mProfileDetails.getInvitecode());
        int mProgress = 0;
        mProgress = mProgress + 30;
        mMobileTV.setText(mAppPreference.getMobile());
        mUpdateMobileTV.setText(getString(R.string.text_verified));
        mUpdateMobileTV.setEnabled(false);
        mUpdateMobileTV.setTextColor(getResources().getColor(R.color.color_green));
        if (!TextUtils.isEmpty(mAppPreference.getEmail())) {
            mEmailTV.setText(mAppPreference.getEmail());
            mShowEmailTV.setText(mAppPreference.getEmail());
        }
        if (!TextUtils.isEmpty(mAppPreference.getName())) {
            mNameTV.setText(mAppPreference.getName());
            mProgress = mProgress + 10;
        }
        if (!TextUtils.isEmpty(mAppPreference.getUrl())){
            mProgress = mProgress + 20;
            Glide.with(this).load(mAppPreference.getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(mProfileIV);
        }
        if (!TextUtils.isEmpty(mAppPreference.getInviteCode())) {
            mInviteCodeTV.setText(mAppPreference.getInviteCode());
        }
        if (TextUtils.isEmpty(mProfileDetails.getUsername()) || mProfileDetails.getUsername().startsWith("8888888888")) {
            mIdTV.setText(getString(R.string.text_update_username));
        } else {
            mProgress = mProgress + 20;
            mIdTV.setText("Username: " + mProfileDetails.getUsername());
        }
        if (mProfileDetails.getAadharUpdated() == 4) {
            mChangeAadharTV.setText(getString(R.string.text_rejected));
            mChangeAadharTV.setTextColor(getResources().getColor(R.color.battle_red));
            mChangeAadharTV.setEnabled(true);
            mAadharTV.setText(mProfileDetails.getAadharDetails().getRejectReason());
        } else if (mProfileDetails.getAadharUpdated() == 3) {
            mChangeAadharTV.setText(getString(R.string.text_verified));
            mChangeAadharTV.setEnabled(false);
            mChangeAadharTV.setTextColor(getResources().getColor(R.color.color_green));
            mAadharTV.setText(R.string.password_hide);
            mChangeDobTV.setText(getString(R.string.text_verified));
            mChangeDobTV.setEnabled(false);
            mChangeDobTV.setTextColor(getResources().getColor(R.color.color_green));
            mCountryTV.setText(mProfileDetails.getAddress());
            mProgress = mProgress + 10;
        } else if (mProfileDetails.getAadharUpdated() == 2) {
            mChangeAadharTV.setText(getString(R.string.text_pending_approval));
            mChangeAadharTV.setEnabled(false);
            mChangeAadharTV.setTextColor(getResources().getColor(R.color.orange_dark));
            mAadharTV.setText("");
        }
//        mChangeAadharTV.setEnabled(true);
        if (mProfileDetails.isEmailVerified()) {
            mShowEmailTV.setText(mAppPreference.getEmail());
            mUpdateEmailTV.setText(R.string.text_verified);
            mUpdateEmailTV.setEnabled(false);
            mUpdateEmailTV.setTextColor(getResources().getColor(R.color.color_green));
            mProgress = mProgress + 10;
        } else {
            mUpdateEmailTV.setText(R.string.text_update_email);
            mUpdateEmailTV.setEnabled(true);
            mShowEmailTV.setText("");
            mUpdateEmailTV.setTextColor(getResources().getColor(R.color.battle_red));
        }
        mProfileProgressPB.setProgress(mProgress);
        mProfilePercentTV.setText(mProgress + "/100");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == AppConstant.RC_ASK_PERMISSIONS_STORAGE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.txt_storage_permission), Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, UpdateProfileActivity.class));
                finish();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMsg(String msg) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.popup);
        TextView tv_msg = dialog.findViewById(R.id.tv_msg);
        tv_msg.setText(msg);
        Button okBTN = dialog.findViewById(R.id.btn_ok);
        okBTN.setOnClickListener(view -> {
            dialog.dismiss();
            getProfile();
        });
        dialog.show();
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

    private final IOnVerifyEmailListener onVerifyEmailAddressListener = new IOnVerifyEmailListener() {
        @Override
        public void onSendOTP(String email) {
            mNewEmail = email;
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.doSendOTP(mNewEmail);
        }

        @Override
        public void onVerifyEmail(String email, String otp) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.doVerifyEmail(email, otp);
        }

        @Override
        public void onResendOTP(String email) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.doSendOTP(email);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        getProfile();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

}