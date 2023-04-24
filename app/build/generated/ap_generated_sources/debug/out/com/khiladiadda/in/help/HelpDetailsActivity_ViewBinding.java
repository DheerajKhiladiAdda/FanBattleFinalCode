// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.help;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelpDetailsActivity_ViewBinding implements Unbinder {
  private HelpDetailsActivity target;

  @UiThread
  public HelpDetailsActivity_ViewBinding(HelpDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HelpDetailsActivity_ViewBinding(HelpDetailsActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mHelpRV = Utils.findRequiredViewAsType(source, R.id.rv_help, "field 'mHelpRV'", RecyclerView.class);
    target.mEmailBTN = Utils.findRequiredViewAsType(source, R.id.btn_email, "field 'mEmailBTN'", Button.class);
    target.mWhatsAppLL = Utils.findRequiredViewAsType(source, R.id.ll_whatsapp, "field 'mWhatsAppLL'", LinearLayout.class);
    target.mVideoBTN = Utils.findRequiredViewAsType(source, R.id.btn_view_video, "field 'mVideoBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HelpDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mHelpRV = null;
    target.mEmailBTN = null;
    target.mWhatsAppLL = null;
    target.mVideoBTN = null;
  }
}
