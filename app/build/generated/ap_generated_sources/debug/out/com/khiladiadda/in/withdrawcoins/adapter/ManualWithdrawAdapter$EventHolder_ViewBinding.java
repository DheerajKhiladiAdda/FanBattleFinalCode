// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ManualWithdrawAdapter$EventHolder_ViewBinding implements Unbinder {
  private ManualWithdrawAdapter.EventHolder target;

  @UiThread
  public ManualWithdrawAdapter$EventHolder_ViewBinding(ManualWithdrawAdapter.EventHolder target,
      View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mModeTV = Utils.findRequiredViewAsType(source, R.id.tv_mode, "field 'mModeTV'", TextView.class);
    target.mAddressTV = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'mAddressTV'", TextView.class);
    target.mCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_coins, "field 'mCoinsTV'", TextView.class);
    target.mPendingTV = Utils.findRequiredViewAsType(source, R.id.tv_pending, "field 'mPendingTV'", TextView.class);
    target.mProcessingTV = Utils.findRequiredViewAsType(source, R.id.tv_processing, "field 'mProcessingTV'", TextView.class);
    target.mApproveTV = Utils.findRequiredViewAsType(source, R.id.tv_approve, "field 'mApproveTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ManualWithdrawAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mModeTV = null;
    target.mAddressTV = null;
    target.mCoinsTV = null;
    target.mPendingTV = null;
    target.mProcessingTV = null;
    target.mApproveTV = null;
  }
}
