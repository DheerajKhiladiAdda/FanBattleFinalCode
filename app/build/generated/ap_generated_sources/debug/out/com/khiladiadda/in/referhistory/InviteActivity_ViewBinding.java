// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.referhistory;

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

public class InviteActivity_ViewBinding implements Unbinder {
  private InviteActivity target;

  @UiThread
  public InviteActivity_ViewBinding(InviteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InviteActivity_ViewBinding(InviteActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mHomeTV = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'mHomeTV'", TextView.class);
    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
    target.mInviteCodeTV = Utils.findRequiredViewAsType(source, R.id.tv_invite_code, "field 'mInviteCodeTV'", TextView.class);
    target.mWhatsAppBTN = Utils.findRequiredViewAsType(source, R.id.btn_whatsapp, "field 'mWhatsAppBTN'", Button.class);
    target.mOptionBTN = Utils.findRequiredViewAsType(source, R.id.btn_option, "field 'mOptionBTN'", Button.class);
    target.mViewTV = Utils.findRequiredViewAsType(source, R.id.tv_view, "field 'mViewTV'", TextView.class);
    target.mReferCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_refer_coins, "field 'mReferCoinsTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InviteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mHomeTV = null;
    target.mHelpTV = null;
    target.mInviteCodeTV = null;
    target.mWhatsAppBTN = null;
    target.mOptionBTN = null;
    target.mViewTV = null;
    target.mReferCoinsTV = null;
  }
}
