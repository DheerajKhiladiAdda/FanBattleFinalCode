// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.leaderboard.past;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PastLeaderboardActivity_ViewBinding implements Unbinder {
  private PastLeaderboardActivity target;

  @UiThread
  public PastLeaderboardActivity_ViewBinding(PastLeaderboardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PastLeaderboardActivity_ViewBinding(PastLeaderboardActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mLeaderBoardRV = Utils.findRequiredViewAsType(source, R.id.rv_leaderboard, "field 'mLeaderBoardRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PastLeaderboardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mLeaderBoardRV = null;
  }
}
