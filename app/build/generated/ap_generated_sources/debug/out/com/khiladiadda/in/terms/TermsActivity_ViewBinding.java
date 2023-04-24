// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.terms;

import android.view.View;
import android.webkit.WebView;
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

public class TermsActivity_ViewBinding implements Unbinder {
  private TermsActivity target;

  @UiThread
  public TermsActivity_ViewBinding(TermsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TermsActivity_ViewBinding(TermsActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWebview = Utils.findRequiredViewAsType(source, R.id.webview, "field 'mWebview'", WebView.class);
    target.mProgressbar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'mProgressbar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TermsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mWebview = null;
    target.mProgressbar = null;
  }
}
