// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WithdrawReVerifyDialog_ViewBinding implements Unbinder {
  private WithdrawReVerifyDialog target;

  @UiThread
  public WithdrawReVerifyDialog_ViewBinding(WithdrawReVerifyDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WithdrawReVerifyDialog_ViewBinding(WithdrawReVerifyDialog target, View source) {
    this.target = target;

    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
    target.mReVerifyAadharBTN = Utils.findRequiredViewAsType(source, R.id.btn_reverify_aadhar, "field 'mReVerifyAadharBTN'", Button.class);
    target.mReVerifyBeneficiaryBTN = Utils.findRequiredViewAsType(source, R.id.btn_reverify_beneficiary, "field 'mReVerifyBeneficiaryBTN'", Button.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mBankNameTV = Utils.findRequiredViewAsType(source, R.id.tv_bank_name, "field 'mBankNameTV'", TextView.class);
    target.mAadharNameTV = Utils.findRequiredViewAsType(source, R.id.tv_aadhar_name, "field 'mAadharNameTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WithdrawReVerifyDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHelpTV = null;
    target.mReVerifyAadharBTN = null;
    target.mReVerifyBeneficiaryBTN = null;
    target.mCancelBTN = null;
    target.mBankNameTV = null;
    target.mAadharNameTV = null;
  }
}
