// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle;

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

public class CreateBattleDialog_ViewBinding implements Unbinder {
  private CreateBattleDialog target;

  @UiThread
  public CreateBattleDialog_ViewBinding(CreateBattleDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateBattleDialog_ViewBinding(CreateBattleDialog target, View source) {
    this.target = target;

    target.mAmountET = Utils.findRequiredViewAsType(source, R.id.et_amount, "field 'mAmountET'", EditText.class);
    target.mFiftyTV = Utils.findRequiredViewAsType(source, R.id.tv_fifty, "field 'mFiftyTV'", TextView.class);
    target.mHundredTV = Utils.findRequiredViewAsType(source, R.id.tv_hundred, "field 'mHundredTV'", TextView.class);
    target.mTwoHundredTV = Utils.findRequiredViewAsType(source, R.id.tv_two_hundred, "field 'mTwoHundredTV'", TextView.class);
    target.mFiveHundredTV = Utils.findRequiredViewAsType(source, R.id.tv_five_hundred, "field 'mFiveHundredTV'", TextView.class);
    target.mEntryFeeTV = Utils.findRequiredViewAsType(source, R.id.tv_entry_fee, "field 'mEntryFeeTV'", TextView.class);
    target.mTotalWalletBalanceTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_balance, "field 'mTotalWalletBalanceTV'", TextView.class);
    target.mWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet, "field 'mWalletTV'", TextView.class);
    target.mDepositWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet_entry, "field 'mDepositWalletTV'", TextView.class);
    target.mEstimatedProfitTV = Utils.findRequiredViewAsType(source, R.id.tv_estimated_winning, "field 'mEstimatedProfitTV'", TextView.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mSendBTN = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mSendBTN'", Button.class);
    target.mRechargeTV = Utils.findRequiredViewAsType(source, R.id.tv_recharge, "field 'mRechargeTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CreateBattleDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAmountET = null;
    target.mFiftyTV = null;
    target.mHundredTV = null;
    target.mTwoHundredTV = null;
    target.mFiveHundredTV = null;
    target.mEntryFeeTV = null;
    target.mTotalWalletBalanceTV = null;
    target.mWalletTV = null;
    target.mDepositWalletTV = null;
    target.mEstimatedProfitTV = null;
    target.mCancelBTN = null;
    target.mSendBTN = null;
    target.mRechargeTV = null;
  }
}
