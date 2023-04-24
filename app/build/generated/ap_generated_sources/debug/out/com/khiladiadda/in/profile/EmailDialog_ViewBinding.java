// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmailDialog_ViewBinding implements Unbinder {
  private EmailDialog target;

  @UiThread
  public EmailDialog_ViewBinding(EmailDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EmailDialog_ViewBinding(EmailDialog target, View source) {
    this.target = target;

    target.mEmailET = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'mEmailET'", EditText.class);
    target.mSendOtpBTN = Utils.findRequiredViewAsType(source, R.id.btn_send_otp, "field 'mSendOtpBTN'", Button.class);
    target.mOneET = Utils.findRequiredViewAsType(source, R.id.et_one, "field 'mOneET'", EditText.class);
    target.mTwoET = Utils.findRequiredViewAsType(source, R.id.et_two, "field 'mTwoET'", EditText.class);
    target.mThreeET = Utils.findRequiredViewAsType(source, R.id.et_three, "field 'mThreeET'", EditText.class);
    target.mFourET = Utils.findRequiredViewAsType(source, R.id.et_four, "field 'mFourET'", EditText.class);
    target.mFiveET = Utils.findRequiredViewAsType(source, R.id.et_five, "field 'mFiveET'", EditText.class);
    target.mSixET = Utils.findRequiredViewAsType(source, R.id.et_six, "field 'mSixET'", EditText.class);
    target.mResendTV = Utils.findRequiredViewAsType(source, R.id.tv_resend, "field 'mResendTV'", TextView.class);
    target.mVerifyBTN = Utils.findRequiredViewAsType(source, R.id.btn_verify, "field 'mVerifyBTN'", Button.class);
    target.mOTPLL = Utils.findRequiredViewAsType(source, R.id.ll_otp, "field 'mOTPLL'", LinearLayout.class);
    target.mCloseRL = Utils.findRequiredViewAsType(source, R.id.rl_close, "field 'mCloseRL'", RelativeLayout.class);
    target.mEmailLL = Utils.findRequiredViewAsType(source, R.id.ll_email, "field 'mEmailLL'", LinearLayout.class);
    target.mEmailTV = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'mEmailTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EmailDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEmailET = null;
    target.mSendOtpBTN = null;
    target.mOneET = null;
    target.mTwoET = null;
    target.mThreeET = null;
    target.mFourET = null;
    target.mFiveET = null;
    target.mSixET = null;
    target.mResendTV = null;
    target.mVerifyBTN = null;
    target.mOTPLL = null;
    target.mCloseRL = null;
    target.mEmailLL = null;
    target.mEmailTV = null;
  }
}
