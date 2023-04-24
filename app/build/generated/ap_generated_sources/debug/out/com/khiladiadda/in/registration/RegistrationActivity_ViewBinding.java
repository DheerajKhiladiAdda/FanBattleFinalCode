// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.registration;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegistrationActivity_ViewBinding implements Unbinder {
  private RegistrationActivity target;

  @UiThread
  public RegistrationActivity_ViewBinding(RegistrationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegistrationActivity_ViewBinding(RegistrationActivity target, View source) {
    this.target = target;

    target.mNameET = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'mNameET'", EditText.class);
    target.mMobileET = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'mMobileET'", EditText.class);
    target.mReferenceET = Utils.findRequiredViewAsType(source, R.id.et_reference_code, "field 'mReferenceET'", EditText.class);
    target.mTermCB = Utils.findRequiredViewAsType(source, R.id.cb_terms, "field 'mTermCB'", CheckBox.class);
    target.mNextBTN = Utils.findRequiredViewAsType(source, R.id.btn_next, "field 'mNextBTN'", Button.class);
    target.mTermTV = Utils.findRequiredViewAsType(source, R.id.tv_terms, "field 'mTermTV'", TextView.class);
    target.mNeedSupportLL = Utils.findRequiredViewAsType(source, R.id.ll_need_support, "field 'mNeedSupportLL'", LinearLayout.class);
    target.mExistingUserTV = Utils.findRequiredViewAsType(source, R.id.tv_user, "field 'mExistingUserTV'", TextView.class);
    target.mResponsibleGamingCB = Utils.findRequiredViewAsType(source, R.id.cb_resp_gaming, "field 'mResponsibleGamingCB'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegistrationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameET = null;
    target.mMobileET = null;
    target.mReferenceET = null;
    target.mTermCB = null;
    target.mNextBTN = null;
    target.mTermTV = null;
    target.mNeedSupportLL = null;
    target.mExistingUserTV = null;
    target.mResponsibleGamingCB = null;
  }
}
