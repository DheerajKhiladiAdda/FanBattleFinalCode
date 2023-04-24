// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile;

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

public class StatActivity_ViewBinding implements Unbinder {
  private StatActivity target;

  @UiThread
  public StatActivity_ViewBinding(StatActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StatActivity_ViewBinding(StatActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mVoucherBTN = Utils.findRequiredViewAsType(source, R.id.btn_voucher, "field 'mVoucherBTN'", Button.class);
    target.mCXContestTV = Utils.findRequiredViewAsType(source, R.id.tv_cx_contest, "field 'mCXContestTV'", TextView.class);
    target.mCXWinsTV = Utils.findRequiredViewAsType(source, R.id.tv_cx_wins, "field 'mCXWinsTV'", TextView.class);
    target.mCXLosesTV = Utils.findRequiredViewAsType(source, R.id.tv_cx_loses, "field 'mCXLosesTV'", TextView.class);
    target.mFBContestTV = Utils.findRequiredViewAsType(source, R.id.tv_fb_contest, "field 'mFBContestTV'", TextView.class);
    target.mFBWinsTV = Utils.findRequiredViewAsType(source, R.id.tv_fb_wins, "field 'mFBWinsTV'", TextView.class);
    target.mFbLosesTV = Utils.findRequiredViewAsType(source, R.id.tv_fb_loses, "field 'mFbLosesTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StatActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mVoucherBTN = null;
    target.mCXContestTV = null;
    target.mCXWinsTV = null;
    target.mCXLosesTV = null;
    target.mFBContestTV = null;
    target.mFBWinsTV = null;
    target.mFbLosesTV = null;
  }
}
