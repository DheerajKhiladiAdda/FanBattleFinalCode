// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.wallet;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WalletActivity_ViewBinding implements Unbinder {
  private WalletActivity target;

  @UiThread
  public WalletActivity_ViewBinding(WalletActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WalletActivity_ViewBinding(WalletActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mAddCoinsBTN = Utils.findRequiredViewAsType(source, R.id.btn_add_coins, "field 'mAddCoinsBTN'", Button.class);
    target.mWithdrawBTN = Utils.findRequiredViewAsType(source, R.id.btn_withdraw, "field 'mWithdrawBTN'", Button.class);
    target.mTotalCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_coins, "field 'mTotalCoinsTV'", TextView.class);
    target.mDepositTV = Utils.findRequiredViewAsType(source, R.id.tv_deposit, "field 'mDepositTV'", TextView.class);
    target.mWinningTV = Utils.findRequiredViewAsType(source, R.id.tv_winning, "field 'mWinningTV'", TextView.class);
    target.mBonusTV = Utils.findRequiredViewAsType(source, R.id.tv_bonus, "field 'mBonusTV'", TextView.class);
    target.mTransactionRV = Utils.findRequiredViewAsType(source, R.id.rv_transaction, "field 'mTransactionRV'", RecyclerView.class);
    target.mTransactionTV = Utils.findRequiredViewAsType(source, R.id.tv_recent_transaction, "field 'mTransactionTV'", TextView.class);
    target.mPaymentHistoryTV = Utils.findRequiredViewAsType(source, R.id.tv_payment_history, "field 'mPaymentHistoryTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WalletActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mAddCoinsBTN = null;
    target.mWithdrawBTN = null;
    target.mTotalCoinsTV = null;
    target.mDepositTV = null;
    target.mWinningTV = null;
    target.mBonusTV = null;
    target.mTransactionRV = null;
    target.mTransactionTV = null;
    target.mPaymentHistoryTV = null;
  }
}
