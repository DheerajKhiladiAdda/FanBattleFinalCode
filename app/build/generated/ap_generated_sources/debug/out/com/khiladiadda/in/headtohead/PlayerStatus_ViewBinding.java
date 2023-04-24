// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerStatus_ViewBinding implements Unbinder {
  private PlayerStatus target;

  @UiThread
  public PlayerStatus_ViewBinding(PlayerStatus target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PlayerStatus_ViewBinding(PlayerStatus target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mPointsRV = Utils.findRequiredViewAsType(source, R.id.rv_player_points, "field 'mPointsRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayerStatus target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mPointsRV = null;
  }
}
