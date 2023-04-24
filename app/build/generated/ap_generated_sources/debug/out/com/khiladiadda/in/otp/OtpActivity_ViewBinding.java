// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.otp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OtpActivity_ViewBinding implements Unbinder {
  private OtpActivity target;

  @UiThread
  public OtpActivity_ViewBinding(OtpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OtpActivity_ViewBinding(OtpActivity target, View source) {
    this.target = target;

    target.mRegisterBTN = Utils.findRequiredViewAsType(source, R.id.btn_register, "field 'mRegisterBTN'", Button.class);
    target.mOneET = Utils.findRequiredViewAsType(source, R.id.et_one, "field 'mOneET'", EditText.class);
    target.mTwoET = Utils.findRequiredViewAsType(source, R.id.et_two, "field 'mTwoET'", EditText.class);
    target.mThreeET = Utils.findRequiredViewAsType(source, R.id.et_three, "field 'mThreeET'", EditText.class);
    target.mFourET = Utils.findRequiredViewAsType(source, R.id.et_four, "field 'mFourET'", EditText.class);
    target.mFiveET = Utils.findRequiredViewAsType(source, R.id.et_five, "field 'mFiveET'", EditText.class);
    target.mSixET = Utils.findRequiredViewAsType(source, R.id.et_six, "field 'mSixET'", EditText.class);
    target.mResendTV = Utils.findRequiredViewAsType(source, R.id.tv_resend, "field 'mResendTV'", TextView.class);
    target.mMobileTV = Utils.findRequiredViewAsType(source, R.id.tv_mobile, "field 'mMobileTV'", TextView.class);
    target.mNeedSupportLL = Utils.findRequiredViewAsType(source, R.id.ll_need_support, "field 'mNeedSupportLL'", LinearLayout.class);
    target.mChangeNumberTV = Utils.findRequiredViewAsType(source, R.id.tv_changenumber, "field 'mChangeNumberTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OtpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRegisterBTN = null;
    target.mOneET = null;
    target.mTwoET = null;
    target.mThreeET = null;
    target.mFourET = null;
    target.mFiveET = null;
    target.mSixET = null;
    target.mResendTV = null;
    target.mMobileTV = null;
    target.mNeedSupportLL = null;
    target.mChangeNumberTV = null;
  }
}
