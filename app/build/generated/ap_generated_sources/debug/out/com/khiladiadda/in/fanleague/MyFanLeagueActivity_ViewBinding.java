// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fanleague;

import android.view.View;
import android.widget.Button;
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

public class MyFanLeagueActivity_ViewBinding implements Unbinder {
  private MyFanLeagueActivity target;

  @UiThread
  public MyFanLeagueActivity_ViewBinding(MyFanLeagueActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyFanLeagueActivity_ViewBinding(MyFanLeagueActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mLiveBTN = Utils.findRequiredViewAsType(source, R.id.btn_live, "field 'mLiveBTN'", Button.class);
    target.mPastBTN = Utils.findRequiredViewAsType(source, R.id.btn_past, "field 'mPastBTN'", Button.class);
    target.mUpcomingBTN = Utils.findRequiredViewAsType(source, R.id.btn_upcoming, "field 'mUpcomingBTN'", Button.class);
    target.mMyMatchRV = Utils.findRequiredViewAsType(source, R.id.rv_my_match, "field 'mMyMatchRV'", RecyclerView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyFanLeagueActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mLiveBTN = null;
    target.mPastBTN = null;
    target.mUpcomingBTN = null;
    target.mMyMatchRV = null;
    target.mNoDataTV = null;
  }
}
