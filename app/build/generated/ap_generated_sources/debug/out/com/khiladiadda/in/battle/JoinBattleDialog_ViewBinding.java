// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

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

public class JoinBattleDialog_ViewBinding implements Unbinder {
  private JoinBattleDialog target;

  @UiThread
  public JoinBattleDialog_ViewBinding(JoinBattleDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public JoinBattleDialog_ViewBinding(JoinBattleDialog target, View source) {
    this.target = target;

    target.mBonusLL = Utils.findRequiredViewAsType(source, R.id.ll_bonus, "field 'mBonusLL'", LinearLayout.class);
    target.mBonusTV = Utils.findRequiredViewAsType(source, R.id.tv_bonus, "field 'mBonusTV'", TextView.class);
    target.mWalletBonusTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet_bonus, "field 'mWalletBonusTV'", TextView.class);
    target.mTotalWalletLL = Utils.findRequiredViewAsType(source, R.id.ll_total_wallet, "field 'mTotalWalletLL'", LinearLayout.class);
    target.mWalletLL = Utils.findRequiredViewAsType(source, R.id.ll_wallet, "field 'mWalletLL'", LinearLayout.class);
    target.mProfitLL = Utils.findRequiredViewAsType(source, R.id.ll_profit, "field 'mProfitLL'", LinearLayout.class);
    target.mRechargeTV = Utils.findRequiredViewAsType(source, R.id.tv_recharge, "field 'mRechargeTV'", TextView.class);
    target.mAmountET = Utils.findRequiredViewAsType(source, R.id.et_amount, "field 'mAmountET'", EditText.class);
    target.mTotalWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_entry, "field 'mTotalWalletTV'", TextView.class);
    target.mWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet, "field 'mWalletTV'", TextView.class);
    target.mDepositWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet_entry, "field 'mDepositWalletTV'", TextView.class);
    target.mEstimatedProfitTV = Utils.findRequiredViewAsType(source, R.id.tv_estimated_profit, "field 'mEstimatedProfitTV'", TextView.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mSendBTN = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mSendBTN'", Button.class);
    target.mEstimatedWinningTV = Utils.findRequiredViewAsType(source, R.id.tv_estimated_winning, "field 'mEstimatedWinningTV'", TextView.class);
    target.mHintTV = Utils.findRequiredViewAsType(source, R.id.tv_hint, "field 'mHintTV'", TextView.class);
    target.mHeadingTV = Utils.findRequiredViewAsType(source, R.id.tv_heading, "field 'mHeadingTV'", TextView.class);
    target.mMsgTV = Utils.findRequiredViewAsType(source, R.id.tv_msg, "field 'mMsgTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    JoinBattleDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBonusLL = null;
    target.mBonusTV = null;
    target.mWalletBonusTV = null;
    target.mTotalWalletLL = null;
    target.mWalletLL = null;
    target.mProfitLL = null;
    target.mRechargeTV = null;
    target.mAmountET = null;
    target.mTotalWalletTV = null;
    target.mWalletTV = null;
    target.mDepositWalletTV = null;
    target.mEstimatedProfitTV = null;
    target.mCancelBTN = null;
    target.mSendBTN = null;
    target.mEstimatedWinningTV = null;
    target.mHintTV = null;
    target.mHeadingTV = null;
    target.mMsgTV = null;
  }
}
