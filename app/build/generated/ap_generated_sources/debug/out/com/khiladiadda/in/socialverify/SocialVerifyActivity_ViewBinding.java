// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.socialverify;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SocialVerifyActivity_ViewBinding implements Unbinder {
  private SocialVerifyActivity target;

  @UiThread
  public SocialVerifyActivity_ViewBinding(SocialVerifyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SocialVerifyActivity_ViewBinding(SocialVerifyActivity target, View source) {
    this.target = target;

    target.mMobileET = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'mMobileET'", EditText.class);
    target.mInviteCodeET = Utils.findRequiredViewAsType(source, R.id.et_reference_code, "field 'mInviteCodeET'", EditText.class);
    target.mSendOtpBTN = Utils.findRequiredViewAsType(source, R.id.btn_send_otp, "field 'mSendOtpBTN'", Button.class);
    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
    target.mOneET = Utils.findRequiredViewAsType(source, R.id.et_one, "field 'mOneET'", EditText.class);
    target.mTwoET = Utils.findRequiredViewAsType(source, R.id.et_two, "field 'mTwoET'", EditText.class);
    target.mThreeET = Utils.findRequiredViewAsType(source, R.id.et_three, "field 'mThreeET'", EditText.class);
    target.mFourET = Utils.findRequiredViewAsType(source, R.id.et_four, "field 'mFourET'", EditText.class);
    target.mFiveET = Utils.findRequiredViewAsType(source, R.id.et_five, "field 'mFiveET'", EditText.class);
    target.mSixET = Utils.findRequiredViewAsType(source, R.id.et_six, "field 'mSixET'", EditText.class);
    target.mResendOTPTV = Utils.findRequiredViewAsType(source, R.id.tv_resend_otp, "field 'mResendOTPTV'", TextView.class);
    target.mConfirmOTPBTN = Utils.findRequiredViewAsType(source, R.id.btn_confirm_otp, "field 'mConfirmOTPBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SocialVerifyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMobileET = null;
    target.mInviteCodeET = null;
    target.mSendOtpBTN = null;
    target.mHelpTV = null;
    target.mOneET = null;
    target.mTwoET = null;
    target.mThreeET = null;
    target.mFourET = null;
    target.mFiveET = null;
    target.mSixET = null;
    target.mResendOTPTV = null;
    target.mConfirmOTPBTN = null;
  }
}
