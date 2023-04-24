// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.participant;

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

public class ParticipantActivity_ViewBinding implements Unbinder {
  private ParticipantActivity target;

  @UiThread
  public ParticipantActivity_ViewBinding(ParticipantActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ParticipantActivity_ViewBinding(ParticipantActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mRV = Utils.findRequiredViewAsType(source, R.id.rv_participant, "field 'mRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ParticipantActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mNoDataTV = null;
    target.mRV = null;
  }
}
