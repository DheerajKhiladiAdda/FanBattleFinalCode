// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class RummyActivity_ViewBinding implements Unbinder {
  private RummyActivity target;

  @UiThread
  public RummyActivity_ViewBinding(RummyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RummyActivity_ViewBinding(RummyActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mPointsTV = Utils.findRequiredViewAsType(source, R.id.tv_points, "field 'mPointsTV'", TextView.class);
    target.mPoolTV = Utils.findRequiredViewAsType(source, R.id.tv_pool, "field 'mPoolTV'", TextView.class);
    target.mDealTV = Utils.findRequiredViewAsType(source, R.id.tv_deal, "field 'mDealTV'", TextView.class);
    target.mOneTV = Utils.findRequiredViewAsType(source, R.id.tv_one, "field 'mOneTV'", TextView.class);
    target.mTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_two, "field 'mTwoTV'", TextView.class);
    target.mThreeTV = Utils.findRequiredViewAsType(source, R.id.tv_three, "field 'mThreeTV'", TextView.class);
    target.mRummyRV = Utils.findRequiredViewAsType(source, R.id.rv_rummy, "field 'mRummyRV'", RecyclerView.class);
    target.mModeOptionLL = Utils.findRequiredViewAsType(source, R.id.ll_mode_option, "field 'mModeOptionLL'", LinearLayout.class);
    target.mHowToPlayTv = Utils.findRequiredViewAsType(source, R.id.tv_how_to_play, "field 'mHowToPlayTv'", TextView.class);
    target.mHistoryTv = Utils.findRequiredViewAsType(source, R.id.tv_history, "field 'mHistoryTv'", TextView.class);
    target.mBannerVP = Utils.findRequiredViewAsType(source, R.id.vp_advertisement, "field 'mBannerVP'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mPointsTV = null;
    target.mPoolTV = null;
    target.mDealTV = null;
    target.mOneTV = null;
    target.mTwoTV = null;
    target.mThreeTV = null;
    target.mRummyRV = null;
    target.mModeOptionLL = null;
    target.mHowToPlayTv = null;
    target.mHistoryTv = null;
    target.mBannerVP = null;
  }
}
