// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.login;

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

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.mEmailET = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'mEmailET'", EditText.class);
    target.mLoginBTN = Utils.findRequiredViewAsType(source, R.id.btn_login, "field 'mLoginBTN'", Button.class);
    target.mSignUpTV = Utils.findRequiredViewAsType(source, R.id.tv_signup, "field 'mSignUpTV'", TextView.class);
    target.mFacebookIV = Utils.findRequiredViewAsType(source, R.id.iv_fb, "field 'mFacebookIV'", TextView.class);
    target.mGoogleIV = Utils.findRequiredViewAsType(source, R.id.iv_google, "field 'mGoogleIV'", TextView.class);
    target.mNeedSupportLL = Utils.findRequiredViewAsType(source, R.id.ll_need_support, "field 'mNeedSupportLL'", LinearLayout.class);
    target.mLoginViaTV = Utils.findRequiredViewAsType(source, R.id.tv_login_via, "field 'mLoginViaTV'", TextView.class);
    target.mTermCB = Utils.findRequiredViewAsType(source, R.id.cb_terms, "field 'mTermCB'", CheckBox.class);
    target.mTermTV = Utils.findRequiredViewAsType(source, R.id.tv_terms, "field 'mTermTV'", TextView.class);
    target.mResponsibleGamingCB = Utils.findRequiredViewAsType(source, R.id.cb_resp_gaming, "field 'mResponsibleGamingCB'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEmailET = null;
    target.mLoginBTN = null;
    target.mSignUpTV = null;
    target.mFacebookIV = null;
    target.mGoogleIV = null;
    target.mNeedSupportLL = null;
    target.mLoginViaTV = null;
    target.mTermCB = null;
    target.mTermTV = null;
    target.mResponsibleGamingCB = null;
  }
}
