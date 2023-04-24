// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins;

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

public class WithdrawOTPDialog_ViewBinding implements Unbinder {
  private WithdrawOTPDialog target;

  @UiThread
  public WithdrawOTPDialog_ViewBinding(WithdrawOTPDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WithdrawOTPDialog_ViewBinding(WithdrawOTPDialog target, View source) {
    this.target = target;

    target.mSendBTN = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mSendBTN'", Button.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mOneET = Utils.findRequiredViewAsType(source, R.id.et_one, "field 'mOneET'", EditText.class);
    target.mTwoET = Utils.findRequiredViewAsType(source, R.id.et_two, "field 'mTwoET'", EditText.class);
    target.mThreeET = Utils.findRequiredViewAsType(source, R.id.et_three, "field 'mThreeET'", EditText.class);
    target.mFourET = Utils.findRequiredViewAsType(source, R.id.et_four, "field 'mFourET'", EditText.class);
    target.mFiveET = Utils.findRequiredViewAsType(source, R.id.et_five, "field 'mFiveET'", EditText.class);
    target.mSixET = Utils.findRequiredViewAsType(source, R.id.et_six, "field 'mSixET'", EditText.class);
    target.mResendTV = Utils.findRequiredViewAsType(source, R.id.tv_resend, "field 'mResendTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WithdrawOTPDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSendBTN = null;
    target.mCancelBTN = null;
    target.mOneET = null;
    target.mTwoET = null;
    target.mThreeET = null;
    target.mFourET = null;
    target.mFiveET = null;
    target.mSixET = null;
    target.mResendTV = null;
  }
}
