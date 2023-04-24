// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BeneficiaryAdapter$EventHolder_ViewBinding implements Unbinder {
  private BeneficiaryAdapter.EventHolder target;

  @UiThread
  public BeneficiaryAdapter$EventHolder_ViewBinding(BeneficiaryAdapter.EventHolder target,
      View source) {
    this.target = target;

    target.mPaymentRL = Utils.findRequiredViewAsType(source, R.id.ll_payment, "field 'mPaymentRL'", RelativeLayout.class);
    target.mModeTV = Utils.findRequiredViewAsType(source, R.id.tv_mode, "field 'mModeTV'", TextView.class);
    target.mNumberTV = Utils.findRequiredViewAsType(source, R.id.tv_number, "field 'mNumberTV'", TextView.class);
    target.mDeleteIV = Utils.findRequiredViewAsType(source, R.id.iv_delete, "field 'mDeleteIV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BeneficiaryAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPaymentRL = null;
    target.mModeTV = null;
    target.mNumberTV = null;
    target.mDeleteIV = null;
  }
}
