// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.setting;

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

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mTermsConditionTV = Utils.findRequiredViewAsType(source, R.id.tv_term_condition, "field 'mTermsConditionTV'", TextView.class);
    target.mPrivacyPolicyTV = Utils.findRequiredViewAsType(source, R.id.tv_privacy_policy, "field 'mPrivacyPolicyTV'", TextView.class);
    target.mLegalityTV = Utils.findRequiredViewAsType(source, R.id.tv_legality, "field 'mLegalityTV'", TextView.class);
    target.mCancellationPolicyTV = Utils.findRequiredViewAsType(source, R.id.tv_cancellation_policy, "field 'mCancellationPolicyTV'", TextView.class);
    target.mContactUsTV = Utils.findRequiredViewAsType(source, R.id.tv_contact_us, "field 'mContactUsTV'", TextView.class);
    target.mAboutUsTV = Utils.findRequiredViewAsType(source, R.id.tv_about_us, "field 'mAboutUsTV'", TextView.class);
    target.mNotificationTV = Utils.findRequiredViewAsType(source, R.id.tv_notification, "field 'mNotificationTV'", TextView.class);
    target.mLogoutTV = Utils.findRequiredViewAsType(source, R.id.tv_logout, "field 'mLogoutTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mTermsConditionTV = null;
    target.mPrivacyPolicyTV = null;
    target.mLegalityTV = null;
    target.mCancellationPolicyTV = null;
    target.mContactUsTV = null;
    target.mAboutUsTV = null;
    target.mNotificationTV = null;
    target.mLogoutTV = null;
  }
}
