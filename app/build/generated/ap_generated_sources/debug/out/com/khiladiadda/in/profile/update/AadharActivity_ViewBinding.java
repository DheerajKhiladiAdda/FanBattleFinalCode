// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile.update;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AadharActivity_ViewBinding implements Unbinder {
  private AadharActivity target;

  @UiThread
  public AadharActivity_ViewBinding(AadharActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AadharActivity_ViewBinding(AadharActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mAadharHintTV = Utils.findRequiredViewAsType(source, R.id.tv_aadhar_hint, "field 'mAadharHintTV'", TextView.class);
    target.mCaptchaIV = Utils.findRequiredViewAsType(source, R.id.iv_captcha, "field 'mCaptchaIV'", ImageView.class);
    target.mCaptchaET = Utils.findRequiredViewAsType(source, R.id.et_captcha, "field 'mCaptchaET'", EditText.class);
    target.mAadharNumberET = Utils.findRequiredViewAsType(source, R.id.et_aadhaar_number, "field 'mAadharNumberET'", EditText.class);
    target.mUpdateAadharBTN = Utils.findRequiredViewAsType(source, R.id.btn_update_aadhar, "field 'mUpdateAadharBTN'", Button.class);
    target.mOtpHintTV = Utils.findRequiredViewAsType(source, R.id.tv_otp_hint, "field 'mOtpHintTV'", TextView.class);
    target.mOneET = Utils.findRequiredViewAsType(source, R.id.et_one, "field 'mOneET'", EditText.class);
    target.mTwoET = Utils.findRequiredViewAsType(source, R.id.et_two, "field 'mTwoET'", EditText.class);
    target.mThreeET = Utils.findRequiredViewAsType(source, R.id.et_three, "field 'mThreeET'", EditText.class);
    target.mFourET = Utils.findRequiredViewAsType(source, R.id.et_four, "field 'mFourET'", EditText.class);
    target.mFiveET = Utils.findRequiredViewAsType(source, R.id.et_five, "field 'mFiveET'", EditText.class);
    target.mSixET = Utils.findRequiredViewAsType(source, R.id.et_six, "field 'mSixET'", EditText.class);
    target.mOtpLL = Utils.findRequiredViewAsType(source, R.id.ll_otp, "field 'mOtpLL'", LinearLayout.class);
    target.mConfirmOtpBTN = Utils.findRequiredViewAsType(source, R.id.btn_confirm_otp, "field 'mConfirmOtpBTN'", Button.class);
    target.mProfileLL = Utils.findRequiredViewAsType(source, R.id.ll_profile, "field 'mProfileLL'", LinearLayout.class);
    target.mManualHintTV = Utils.findRequiredViewAsType(source, R.id.tv_manual_hint, "field 'mManualHintTV'", TextView.class);
    target.mAdharManualBTN = Utils.findRequiredViewAsType(source, R.id.btn_aadhar_manual, "field 'mAdharManualBTN'", Button.class);
    target.mResendTV = Utils.findRequiredViewAsType(source, R.id.tv_resend, "field 'mResendTV'", TextView.class);
    target.mQuizTimerTV = Utils.findRequiredViewAsType(source, R.id.tv_quiz_timer, "field 'mQuizTimerTV'", TextView.class);
    target.mNewCaptchaTV = Utils.findRequiredViewAsType(source, R.id.tv_new_captcha, "field 'mNewCaptchaTV'", TextView.class);
    target.mQueryBTN = Utils.findRequiredViewAsType(source, R.id.btn_query, "field 'mQueryBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AadharActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mAadharHintTV = null;
    target.mCaptchaIV = null;
    target.mCaptchaET = null;
    target.mAadharNumberET = null;
    target.mUpdateAadharBTN = null;
    target.mOtpHintTV = null;
    target.mOneET = null;
    target.mTwoET = null;
    target.mThreeET = null;
    target.mFourET = null;
    target.mFiveET = null;
    target.mSixET = null;
    target.mOtpLL = null;
    target.mConfirmOtpBTN = null;
    target.mProfileLL = null;
    target.mManualHintTV = null;
    target.mAdharManualBTN = null;
    target.mResendTV = null;
    target.mQuizTimerTV = null;
    target.mNewCaptchaTV = null;
    target.mQueryBTN = null;
  }
}
