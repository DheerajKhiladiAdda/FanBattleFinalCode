// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.wallet;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebPaymentActivity_ViewBinding implements Unbinder {
  private WebPaymentActivity target;

  @UiThread
  public WebPaymentActivity_ViewBinding(WebPaymentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebPaymentActivity_ViewBinding(WebPaymentActivity target, View source) {
    this.target = target;

    target.mWebView = Utils.findRequiredViewAsType(source, R.id.paymentWebView, "field 'mWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebPaymentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWebView = null;
  }
}
