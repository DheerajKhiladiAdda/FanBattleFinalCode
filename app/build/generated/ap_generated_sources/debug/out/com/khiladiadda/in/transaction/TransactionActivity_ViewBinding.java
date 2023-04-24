// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.transaction;

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

public class TransactionActivity_ViewBinding implements Unbinder {
  private TransactionActivity target;

  @UiThread
  public TransactionActivity_ViewBinding(TransactionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TransactionActivity_ViewBinding(TransactionActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWinningCashTV = Utils.findRequiredViewAsType(source, R.id.tv_wining_cash, "field 'mWinningCashTV'", TextView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mTransactionRV = Utils.findRequiredViewAsType(source, R.id.rv_transaction, "field 'mTransactionRV'", RecyclerView.class);
    target.mWithdrawRV = Utils.findRequiredViewAsType(source, R.id.rv_withdraw, "field 'mWithdrawRV'", RecyclerView.class);
    target.mViewManualHistoryBTN = Utils.findRequiredViewAsType(source, R.id.btn_view_manual_history, "field 'mViewManualHistoryBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TransactionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mWinningCashTV = null;
    target.mNoDataTV = null;
    target.mTransactionRV = null;
    target.mWithdrawRV = null;
    target.mViewManualHistoryBTN = null;
  }
}
