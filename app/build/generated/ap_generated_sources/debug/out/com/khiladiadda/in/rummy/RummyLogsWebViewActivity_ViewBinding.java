// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RummyLogsWebViewActivity_ViewBinding implements Unbinder {
  private RummyLogsWebViewActivity target;

  @UiThread
  public RummyLogsWebViewActivity_ViewBinding(RummyLogsWebViewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RummyLogsWebViewActivity_ViewBinding(RummyLogsWebViewActivity target, View source) {
    this.target = target;

    target.mLogsMv = Utils.findRequiredViewAsType(source, R.id.wv_logs, "field 'mLogsMv'", WebView.class);
    target.mCloseIv = Utils.findRequiredViewAsType(source, R.id.iv_close, "field 'mCloseIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyLogsWebViewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLogsMv = null;
    target.mCloseIv = null;
  }
}
