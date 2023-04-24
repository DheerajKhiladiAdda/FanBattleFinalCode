// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile.update;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PanActivity_ViewBinding implements Unbinder {
  private PanActivity target;

  @UiThread
  public PanActivity_ViewBinding(PanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PanActivity_ViewBinding(PanActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mPanIV = Utils.findRequiredViewAsType(source, R.id.iv_pan, "field 'mPanIV'", ImageView.class);
    target.mNameET = Utils.findRequiredViewAsType(source, R.id.et_pan_name, "field 'mNameET'", EditText.class);
    target.mNumberET = Utils.findRequiredViewAsType(source, R.id.et_pan_number, "field 'mNumberET'", EditText.class);
    target.mSendBtn = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mSendBtn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mPanIV = null;
    target.mNameET = null;
    target.mNumberET = null;
    target.mSendBtn = null;
  }
}
