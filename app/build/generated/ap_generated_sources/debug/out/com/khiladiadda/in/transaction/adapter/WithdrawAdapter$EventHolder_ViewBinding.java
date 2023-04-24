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

public class WithdrawAdapter$EventHolder_ViewBinding implements Unbinder {
  private WithdrawAdapter.EventHolder target;

  @UiThread
  public WithdrawAdapter$EventHolder_ViewBinding(WithdrawAdapter.EventHolder target, View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mModeTV = Utils.findRequiredViewAsType(source, R.id.tv_mode, "field 'mModeTV'", TextView.class);
    target.mAddressTV = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'mAddressTV'", TextView.class);
    target.mCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_coins, "field 'mCoinsTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WithdrawAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mModeTV = null;
    target.mAddressTV = null;
    target.mCoinsTV = null;
  }
}
