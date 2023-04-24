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

public class AadharManualActivity_ViewBinding implements Unbinder {
  private AadharManualActivity target;

  @UiThread
  public AadharManualActivity_ViewBinding(AadharManualActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AadharManualActivity_ViewBinding(AadharManualActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mAdharFrontIV = Utils.findRequiredViewAsType(source, R.id.iv_aadhar_front, "field 'mAdharFrontIV'", ImageView.class);
    target.mAdharBackIV = Utils.findRequiredViewAsType(source, R.id.iv_aadhar_back, "field 'mAdharBackIV'", ImageView.class);
    target.mDobTV = Utils.findRequiredViewAsType(source, R.id.tv_dob, "field 'mDobTV'", TextView.class);
    target.mNameET = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'mNameET'", EditText.class);
    target.mAadharNumberET = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'mAadharNumberET'", EditText.class);
    target.mAddressET = Utils.findRequiredViewAsType(source, R.id.et_address, "field 'mAddressET'", EditText.class);
    target.mCityET = Utils.findRequiredViewAsType(source, R.id.et_city, "field 'mCityET'", EditText.class);
    target.mStateET = Utils.findRequiredViewAsType(source, R.id.et_state, "field 'mStateET'", EditText.class);
    target.mPincodeET = Utils.findRequiredViewAsType(source, R.id.et_pincode, "field 'mPincodeET'", EditText.class);
    target.mSendBtn = Utils.findRequiredViewAsType(source, R.id.btn_send, "field 'mSendBtn'", Button.class);
    target.mFrontTV = Utils.findRequiredViewAsType(source, R.id.tv_front, "field 'mFrontTV'", TextView.class);
    target.mBackTV = Utils.findRequiredViewAsType(source, R.id.tv_back, "field 'mBackTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AadharManualActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mAdharFrontIV = null;
    target.mAdharBackIV = null;
    target.mDobTV = null;
    target.mNameET = null;
    target.mAadharNumberET = null;
    target.mAddressET = null;
    target.mCityET = null;
    target.mStateET = null;
    target.mPincodeET = null;
    target.mSendBtn = null;
    target.mFrontTV = null;
    target.mBackTV = null;
  }
}
