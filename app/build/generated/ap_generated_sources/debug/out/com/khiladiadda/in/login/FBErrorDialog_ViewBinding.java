// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.login;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FBErrorDialog_ViewBinding implements Unbinder {
  private FBErrorDialog target;

  @UiThread
  public FBErrorDialog_ViewBinding(FBErrorDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FBErrorDialog_ViewBinding(FBErrorDialog target, View source) {
    this.target = target;

    target.mHintTV = Utils.findRequiredViewAsType(source, R.id.tv_hint, "field 'mHintTV'", TextView.class);
    target.mGoogleBTN = Utils.findRequiredViewAsType(source, R.id.tv_google, "field 'mGoogleBTN'", TextView.class);
    target.mMobileBTN = Utils.findRequiredViewAsType(source, R.id.tv_mobile, "field 'mMobileBTN'", TextView.class);
    target.mForgotPwddBTN = Utils.findRequiredViewAsType(source, R.id.tv_forgot_pwd, "field 'mForgotPwddBTN'", TextView.class);
    target.mOkBTN = Utils.findRequiredViewAsType(source, R.id.btn_ok, "field 'mOkBTN'", Button.class);
    target.mNewUserTV = Utils.findRequiredViewAsType(source, R.id.tv_new_user, "field 'mNewUserTV'", TextView.class);
    target.mReturnUserTV = Utils.findRequiredViewAsType(source, R.id.tv_return_user, "field 'mReturnUserTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FBErrorDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHintTV = null;
    target.mGoogleBTN = null;
    target.mMobileBTN = null;
    target.mForgotPwddBTN = null;
    target.mOkBTN = null;
    target.mNewUserTV = null;
    target.mReturnUserTV = null;
  }
}
