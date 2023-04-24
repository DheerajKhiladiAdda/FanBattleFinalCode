// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ManualWithdrawActivity_ViewBinding implements Unbinder {
  private ManualWithdrawActivity target;

  @UiThread
  public ManualWithdrawActivity_ViewBinding(ManualWithdrawActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ManualWithdrawActivity_ViewBinding(ManualWithdrawActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWinningCashTV = Utils.findRequiredViewAsType(source, R.id.tv_wining_cash, "field 'mWinningCashTV'", TextView.class);
    target.mPaymentRG = Utils.findRequiredViewAsType(source, R.id.rg_payment, "field 'mPaymentRG'", RadioGroup.class);
    target.mPaymentAddressET = Utils.findRequiredViewAsType(source, R.id.et_payment_address, "field 'mPaymentAddressET'", TextView.class);
    target.mAmountET = Utils.findRequiredViewAsType(source, R.id.et_amount, "field 'mAmountET'", TextView.class);
    target.mSubmitBTN = Utils.findRequiredViewAsType(source, R.id.btn_submit, "field 'mSubmitBTN'", Button.class);
    target.mWithdrawRV = Utils.findRequiredViewAsType(source, R.id.rv_withdraw, "field 'mWithdrawRV'", RecyclerView.class);
    target.mTopLL = Utils.findRequiredViewAsType(source, R.id.ll_top, "field 'mTopLL'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ManualWithdrawActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mWinningCashTV = null;
    target.mPaymentRG = null;
    target.mPaymentAddressET = null;
    target.mAmountET = null;
    target.mSubmitBTN = null;
    target.mWithdrawRV = null;
    target.mTopLL = null;
  }
}
