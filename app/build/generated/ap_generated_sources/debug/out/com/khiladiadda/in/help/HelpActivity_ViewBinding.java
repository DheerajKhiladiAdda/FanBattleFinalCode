// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.help;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelpActivity_ViewBinding implements Unbinder {
  private HelpActivity target;

  @UiThread
  public HelpActivity_ViewBinding(HelpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HelpActivity_ViewBinding(HelpActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mFanBattleIV = Utils.findRequiredViewAsType(source, R.id.iv_fanbattle, "field 'mFanBattleIV'", ImageView.class);
    target.mDepositCV = Utils.findRequiredViewAsType(source, R.id.cv_deposit, "field 'mDepositCV'", ImageView.class);
    target.mWithdrawCV = Utils.findRequiredViewAsType(source, R.id.cv_withdraw, "field 'mWithdrawCV'", ImageView.class);
    target.mKycCV = Utils.findRequiredViewAsType(source, R.id.cv_kyc, "field 'mKycCV'", ImageView.class);
    target.mHTHIV = Utils.findRequiredViewAsType(source, R.id.iv_hthhelp, "field 'mHTHIV'", ImageView.class);
    target.mOtherCV = Utils.findRequiredViewAsType(source, R.id.cv_other, "field 'mOtherCV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HelpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mFanBattleIV = null;
    target.mDepositCV = null;
    target.mWithdrawCV = null;
    target.mKycCV = null;
    target.mHTHIV = null;
    target.mOtherCV = null;
  }
}
