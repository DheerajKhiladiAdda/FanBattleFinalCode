// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.utility;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllHelpActivity_ViewBinding implements Unbinder {
  private AllHelpActivity target;

  @UiThread
  public AllHelpActivity_ViewBinding(AllHelpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AllHelpActivity_ViewBinding(AllHelpActivity target, View source) {
    this.target = target;

    target.mOkBTN = Utils.findRequiredViewAsType(source, R.id.btn_ok, "field 'mOkBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AllHelpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOkBTN = null;
  }
}
