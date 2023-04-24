// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fcm;

import android.view.View;
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

public class NotificationActivity_ViewBinding implements Unbinder {
  private NotificationActivity target;

  @UiThread
  public NotificationActivity_ViewBinding(NotificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationActivity_ViewBinding(NotificationActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mDeleteIV = Utils.findRequiredViewAsType(source, R.id.iv_delete, "field 'mDeleteIV'", ImageView.class);
    target.mCheckAllCB = Utils.findRequiredViewAsType(source, R.id.iv_checkbox, "field 'mCheckAllCB'", ImageView.class);
    target.mNotificationRV = Utils.findRequiredViewAsType(source, R.id.rv_notification, "field 'mNotificationRV'", RecyclerView.class);
    target.mNotifyTV = Utils.findRequiredViewAsType(source, R.id.tv_issue, "field 'mNotifyTV'", TextView.class);
    target.mLeagueNotifcationTV = Utils.findRequiredViewAsType(source, R.id.tv_league_notification, "field 'mLeagueNotifcationTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mDeleteIV = null;
    target.mCheckAllCB = null;
    target.mNotificationRV = null;
    target.mNotifyTV = null;
    target.mLeagueNotifcationTV = null;
  }
}
