// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.profile.update;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateProfileActivity_ViewBinding implements Unbinder {
  private UpdateProfileActivity target;

  @UiThread
  public UpdateProfileActivity_ViewBinding(UpdateProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateProfileActivity_ViewBinding(UpdateProfileActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mUploadBTN = Utils.findRequiredViewAsType(source, R.id.btn_upload, "field 'mUploadBTN'", Button.class);
    target.mUserNameET = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'mUserNameET'", TextView.class);
    target.mNameET = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'mNameET'", TextView.class);
    target.mEmailET = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'mEmailET'", TextView.class);
    target.mMobileET = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'mMobileET'", TextView.class);
    target.mGenderRG = Utils.findRequiredViewAsType(source, R.id.rg_gender, "field 'mGenderRG'", RadioGroup.class);
    target.mStateET = Utils.findRequiredViewAsType(source, R.id.et_state, "field 'mStateET'", TextView.class);
    target.mCountryET = Utils.findRequiredViewAsType(source, R.id.et_country, "field 'mCountryET'", TextView.class);
    target.mUpdateBTN = Utils.findRequiredViewAsType(source, R.id.btn_update, "field 'mUpdateBTN'", Button.class);
    target.mAddressTV = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'mAddressTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mStateTV = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'mStateTV'", TextView.class);
    target.mCountryTV = Utils.findRequiredViewAsType(source, R.id.tv_country, "field 'mCountryTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mProfileIV = null;
    target.mUploadBTN = null;
    target.mUserNameET = null;
    target.mNameET = null;
    target.mEmailET = null;
    target.mMobileET = null;
    target.mGenderRG = null;
    target.mStateET = null;
    target.mCountryET = null;
    target.mUpdateBTN = null;
    target.mAddressTV = null;
    target.mNameTV = null;
    target.mStateTV = null;
    target.mCountryTV = null;
  }
}
