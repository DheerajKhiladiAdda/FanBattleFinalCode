// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WithdrawVerificationDialog_ViewBinding implements Unbinder {
  private WithdrawVerificationDialog target;

  @UiThread
  public WithdrawVerificationDialog_ViewBinding(WithdrawVerificationDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WithdrawVerificationDialog_ViewBinding(WithdrawVerificationDialog target, View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mBankTV = Utils.findRequiredViewAsType(source, R.id.tv_bank, "field 'mBankTV'", TextView.class);
    target.mIfscTV = Utils.findRequiredViewAsType(source, R.id.tv_ifsc, "field 'mIfscTV'", TextView.class);
    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
    target.mVerificationCB = Utils.findRequiredViewAsType(source, R.id.cb_verification, "field 'mVerificationCB'", CheckBox.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mProceedBTN = Utils.findRequiredViewAsType(source, R.id.btn_proceed, "field 'mProceedBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WithdrawVerificationDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mBankTV = null;
    target.mIfscTV = null;
    target.mHelpTV = null;
    target.mVerificationCB = null;
    target.mCancelBTN = null;
    target.mProceedBTN = null;
  }
}
