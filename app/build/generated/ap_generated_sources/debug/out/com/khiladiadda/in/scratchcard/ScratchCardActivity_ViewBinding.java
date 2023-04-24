// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.scratchcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScratchCardActivity_ViewBinding implements Unbinder {
  private ScratchCardActivity target;

  @UiThread
  public ScratchCardActivity_ViewBinding(ScratchCardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScratchCardActivity_ViewBinding(ScratchCardActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mScratchCardRV = Utils.findRequiredViewAsType(source, R.id.rv_scratch_card, "field 'mScratchCardRV'", RecyclerView.class);
    target.mAmountEarnedTV = Utils.findRequiredViewAsType(source, R.id.tv_amount_earned, "field 'mAmountEarnedTV'", TextView.class);
    target.mFanBattleCardRL = Utils.findRequiredViewAsType(source, R.id.rl_fanbattle, "field 'mFanBattleCardRL'", RelativeLayout.class);
    target.mHTHRL = Utils.findRequiredViewAsType(source, R.id.rl_hth, "field 'mHTHRL'", RelativeLayout.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.txt_nodata, "field 'mNoDataTV'", TextView.class);
    target.mGamecountTV = Utils.findRequiredViewAsType(source, R.id.tv_categories, "field 'mGamecountTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScratchCardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mScratchCardRV = null;
    target.mAmountEarnedTV = null;
    target.mFanBattleCardRL = null;
    target.mHTHRL = null;
    target.mNoDataTV = null;
    target.mGamecountTV = null;
  }
}
