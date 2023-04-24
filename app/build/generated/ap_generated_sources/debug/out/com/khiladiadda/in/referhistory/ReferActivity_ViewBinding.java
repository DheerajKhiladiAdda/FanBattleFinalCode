// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.referhistory;

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

public class ReferActivity_ViewBinding implements Unbinder {
  private ReferActivity target;

  @UiThread
  public ReferActivity_ViewBinding(ReferActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReferActivity_ViewBinding(ReferActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mShareBTN = Utils.findRequiredViewAsType(source, R.id.btn_share, "field 'mShareBTN'", Button.class);
    target.mReferRV = Utils.findRequiredViewAsType(source, R.id.rv_refer, "field 'mReferRV'", RecyclerView.class);
    target.mEarnTV = Utils.findRequiredViewAsType(source, R.id.tv_earn, "field 'mEarnTV'", TextView.class);
    target.mFriendsTV = Utils.findRequiredViewAsType(source, R.id.tv_total_friends, "field 'mFriendsTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReferActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mShareBTN = null;
    target.mReferRV = null;
    target.mEarnTV = null;
    target.mFriendsTV = null;
  }
}
