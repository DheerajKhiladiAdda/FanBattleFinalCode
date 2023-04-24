// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyFanLeagueActivityHTH_ViewBinding implements Unbinder {
  private MyFanLeagueActivityHTH target;

  @UiThread
  public MyFanLeagueActivityHTH_ViewBinding(MyFanLeagueActivityHTH target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyFanLeagueActivityHTH_ViewBinding(MyFanLeagueActivityHTH target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mLiveBTN = Utils.findRequiredViewAsType(source, R.id.btn_live, "field 'mLiveBTN'", Button.class);
    target.mPastBTN = Utils.findRequiredViewAsType(source, R.id.btn_past, "field 'mPastBTN'", Button.class);
    target.mUpcomingBTN = Utils.findRequiredViewAsType(source, R.id.btn_upcoming, "field 'mUpcomingBTN'", Button.class);
    target.mMyMatchRV = Utils.findRequiredViewAsType(source, R.id.rv_match, "field 'mMyMatchRV'", RecyclerView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mBannerVP = Utils.findRequiredViewAsType(source, R.id.vp_advertisement, "field 'mBannerVP'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyFanLeagueActivityHTH target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mLiveBTN = null;
    target.mPastBTN = null;
    target.mUpcomingBTN = null;
    target.mMyMatchRV = null;
    target.mNoDataTV = null;
    target.mBannerVP = null;
  }
}
