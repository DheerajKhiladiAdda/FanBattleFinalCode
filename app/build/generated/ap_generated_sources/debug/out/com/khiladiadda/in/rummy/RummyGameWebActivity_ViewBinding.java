// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RummyGameWebActivity_ViewBinding implements Unbinder {
  private RummyGameWebActivity target;

  @UiThread
  public RummyGameWebActivity_ViewBinding(RummyGameWebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RummyGameWebActivity_ViewBinding(RummyGameWebActivity target, View source) {
    this.target = target;

    target.webViewGame = Utils.findRequiredViewAsType(source, R.id.web_view, "field 'webViewGame'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyGameWebActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webViewGame = null;
  }
}
