// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.transaction.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PaymentAdapter$EventHolder_ViewBinding implements Unbinder {
  private PaymentAdapter.EventHolder target;

  @UiThread
  public PaymentAdapter$EventHolder_ViewBinding(PaymentAdapter.EventHolder target, View source) {
    this.target = target;

    target.mTypeTV = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'mTypeTV'", TextView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
    target.mWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet, "field 'mWalletTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mMessageTV = Utils.findRequiredViewAsType(source, R.id.tv_message, "field 'mMessageTV'", TextView.class);
    target.mStatusTV = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mStatusTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTypeTV = null;
    target.mAmountTV = null;
    target.mWalletTV = null;
    target.mDateTV = null;
    target.mMessageTV = null;
    target.mStatusTV = null;
  }
}
