// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.wallet;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TransferSilverCoinsDialog_ViewBinding implements Unbinder {
  private TransferSilverCoinsDialog target;

  @UiThread
  public TransferSilverCoinsDialog_ViewBinding(TransferSilverCoinsDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TransferSilverCoinsDialog_ViewBinding(TransferSilverCoinsDialog target, View source) {
    this.target = target;

    target.mSilverCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_silver_coin, "field 'mSilverCoinsTV'", TextView.class);
    target.mDepositBTN = Utils.findRequiredViewAsType(source, R.id.btn_deposit_wallet, "field 'mDepositBTN'", Button.class);
    target.mBonusBTN = Utils.findRequiredViewAsType(source, R.id.btn_bonus_wallet, "field 'mBonusBTN'", Button.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mTransferBTN = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mTransferBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TransferSilverCoinsDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSilverCoinsTV = null;
    target.mDepositBTN = null;
    target.mBonusBTN = null;
    target.mCancelBTN = null;
    target.mTransferBTN = null;
  }
}
