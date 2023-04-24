// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerFragment_ViewBinding implements Unbinder {
  private PlayerFragment target;

  @UiThread
  public PlayerFragment_ViewBinding(PlayerFragment target, View source) {
    this.target = target;

    target.mPlayerRV = Utils.findRequiredViewAsType(source, R.id.rv_batsman, "field 'mPlayerRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPlayerRV = null;
  }
}
