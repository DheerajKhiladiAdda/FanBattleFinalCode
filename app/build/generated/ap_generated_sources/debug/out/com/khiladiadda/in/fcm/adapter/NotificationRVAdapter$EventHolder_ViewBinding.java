// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fcm.adapter;

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

public class NotificationRVAdapter$EventHolder_ViewBinding implements Unbinder {
  private NotificationRVAdapter.EventHolder target;

  @UiThread
  public NotificationRVAdapter$EventHolder_ViewBinding(NotificationRVAdapter.EventHolder target,
      View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_notification_title, "field 'mNameTV'", TextView.class);
    target.mMessageTV = Utils.findRequiredViewAsType(source, R.id.tv_notification_message, "field 'mMessageTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_notification_date_time, "field 'mDateTV'", TextView.class);
    target.mCheckboxIV = Utils.findRequiredViewAsType(source, R.id.iv_checkbox, "field 'mCheckboxIV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationRVAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mMessageTV = null;
    target.mDateTV = null;
    target.mCheckboxIV = null;
  }
}
