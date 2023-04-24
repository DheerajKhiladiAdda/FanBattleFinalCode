// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.referhistory;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReferHelpActivity_ViewBinding implements Unbinder {
  private ReferHelpActivity target;

  @UiThread
  public ReferHelpActivity_ViewBinding(ReferHelpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReferHelpActivity_ViewBinding(ReferHelpActivity target, View source) {
    this.target = target;

    target.mNextTV = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'mNextTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReferHelpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNextTV = null;
  }
}
