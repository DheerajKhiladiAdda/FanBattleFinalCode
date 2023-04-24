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

public class PaymentHistoryActivity_ViewBinding implements Unbinder {
  private PaymentHistoryActivity target;

  @UiThread
  public PaymentHistoryActivity_ViewBinding(PaymentHistoryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PaymentHistoryActivity_ViewBinding(PaymentHistoryActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWinningCashTV = Utils.findRequiredViewAsType(source, R.id.tv_wining_cash, "field 'mWinningCashTV'", TextView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mTransactionRV = Utils.findRequiredViewAsType(source, R.id.rv_transaction, "field 'mTransactionRV'", RecyclerView.class);
    target.mFromDateTV = Utils.findRequiredViewAsType(source, R.id.tv_from_date, "field 'mFromDateTV'", TextView.class);
    target.mToDateTV = Utils.findRequiredViewAsType(source, R.id.tv_to_date, "field 'mToDateTV'", TextView.class);
    target.mSuccessBTN = Utils.findRequiredViewAsType(source, R.id.btn_success, "field 'mSuccessBTN'", Button.class);
    target.mPendingBTN = Utils.findRequiredViewAsType(source, R.id.btn_pending, "field 'mPendingBTN'", Button.class);
    target.mFailedBTN = Utils.findRequiredViewAsType(source, R.id.btn_failed, "field 'mFailedBTN'", Button.class);
    target.mDoneBTN = Utils.findRequiredViewAsType(source, R.id.btn_done, "field 'mDoneBTN'", Button.class);
    target.mAllBTN = Utils.findRequiredViewAsType(source, R.id.btn_all, "field 'mAllBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentHistoryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mWinningCashTV = null;
    target.mNoDataTV = null;
    target.mTransactionRV = null;
    target.mFromDateTV = null;
    target.mToDateTV = null;
    target.mSuccessBTN = null;
    target.mPendingBTN = null;
    target.mFailedBTN = null;
    target.mDoneBTN = null;
    target.mAllBTN = null;
  }
}
