// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattlePointsActivity_ViewBinding implements Unbinder {
  private BattlePointsActivity target;

  @UiThread
  public BattlePointsActivity_ViewBinding(BattlePointsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattlePointsActivity_ViewBinding(BattlePointsActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mPointIV = Utils.findRequiredViewAsType(source, R.id.iv_point, "field 'mPointIV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattlePointsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mPointIV = null;
  }
}
