// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fcm;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationHelpActivity_ViewBinding implements Unbinder {
  private NotificationHelpActivity target;

  @UiThread
  public NotificationHelpActivity_ViewBinding(NotificationHelpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationHelpActivity_ViewBinding(NotificationHelpActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotifyBTN = Utils.findRequiredViewAsType(source, R.id.btn_notify, "field 'mNotifyBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationHelpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotifyBTN = null;
  }
}
