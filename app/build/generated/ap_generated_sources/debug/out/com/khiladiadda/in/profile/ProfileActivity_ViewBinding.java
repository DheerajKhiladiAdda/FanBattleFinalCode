// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mIdTV = Utils.findRequiredViewAsType(source, R.id.tv_id, "field 'mIdTV'", TextView.class);
    target.mEmailTV = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'mEmailTV'", TextView.class);
    target.mMobileTV = Utils.findRequiredViewAsType(source, R.id.tv_mobile, "field 'mMobileTV'", TextView.class);
    target.mUpdateMobileTV = Utils.findRequiredViewAsType(source, R.id.tv_update_mobile, "field 'mUpdateMobileTV'", TextView.class);
    target.mCountryTV = Utils.findRequiredViewAsType(source, R.id.tv_country, "field 'mCountryTV'", TextView.class);
    target.mEditIV = Utils.findRequiredViewAsType(source, R.id.iv_edit, "field 'mEditIV'", ImageView.class);
    target.mChangePwdTV = Utils.findRequiredViewAsType(source, R.id.tv_change_pwd, "field 'mChangePwdTV'", TextView.class);
    target.mDobTV = Utils.findRequiredViewAsType(source, R.id.tv_dob, "field 'mDobTV'", TextView.class);
    target.mPanTV = Utils.findRequiredViewAsType(source, R.id.tv_pan, "field 'mPanTV'", TextView.class);
    target.mAadharTV = Utils.findRequiredViewAsType(source, R.id.tv_aadhar, "field 'mAadharTV'", TextView.class);
    target.mChangeDobTV = Utils.findRequiredViewAsType(source, R.id.tv_change_dob, "field 'mChangeDobTV'", TextView.class);
    target.mInviteCodeTV = Utils.findRequiredViewAsType(source, R.id.tv_invite_code, "field 'mInviteCodeTV'", TextView.class);
    target.mChangePanTV = Utils.findRequiredViewAsType(source, R.id.tv_change_pan, "field 'mChangePanTV'", TextView.class);
    target.mChangeAadharTV = Utils.findRequiredViewAsType(source, R.id.tv_change_aadhar, "field 'mChangeAadharTV'", TextView.class);
    target.mProfilePercentTV = Utils.findRequiredViewAsType(source, R.id.tv_profile_percentage, "field 'mProfilePercentTV'", TextView.class);
    target.mProfileProgressPB = Utils.findRequiredViewAsType(source, R.id.pb_profile_progress, "field 'mProfileProgressPB'", ProgressBar.class);
    target.mProfilePercentMsgTV = Utils.findRequiredViewAsType(source, R.id.tv_profile_complete_msg, "field 'mProfilePercentMsgTV'", TextView.class);
    target.mShareInviteCodeTV = Utils.findRequiredViewAsType(source, R.id.tv_share, "field 'mShareInviteCodeTV'", TextView.class);
    target.mUpdateEmailTV = Utils.findRequiredViewAsType(source, R.id.tv_update_email, "field 'mUpdateEmailTV'", TextView.class);
    target.mShowEmailTV = Utils.findRequiredViewAsType(source, R.id.tv_u_email, "field 'mShowEmailTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mProfileIV = null;
    target.mNameTV = null;
    target.mIdTV = null;
    target.mEmailTV = null;
    target.mMobileTV = null;
    target.mUpdateMobileTV = null;
    target.mCountryTV = null;
    target.mEditIV = null;
    target.mChangePwdTV = null;
    target.mDobTV = null;
    target.mPanTV = null;
    target.mAadharTV = null;
    target.mChangeDobTV = null;
    target.mInviteCodeTV = null;
    target.mChangePanTV = null;
    target.mChangeAadharTV = null;
    target.mProfilePercentTV = null;
    target.mProfileProgressPB = null;
    target.mProfilePercentMsgTV = null;
    target.mShareInviteCodeTV = null;
    target.mUpdateEmailTV = null;
    target.mShowEmailTV = null;
  }
}
