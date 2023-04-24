// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllMatchesHTHActivity_ViewBinding implements Unbinder {
  private AllMatchesHTHActivity target;

  @UiThread
  public AllMatchesHTHActivity_ViewBinding(AllMatchesHTHActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AllMatchesHTHActivity_ViewBinding(AllMatchesHTHActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mLeagueTV = Utils.findRequiredViewAsType(source, R.id.tv_league, "field 'mLeagueTV'", TextView.class);
    target.mHomeTV = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'mHomeTV'", TextView.class);
    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
    target.mMatchRV = Utils.findRequiredViewAsType(source, R.id.rv_match, "field 'mMatchRV'", RecyclerView.class);
    target.mSwipeRefreshL = Utils.findRequiredViewAsType(source, R.id.swipeRefresh, "field 'mSwipeRefreshL'", SwipeRefreshLayout.class);
    target.mBannerVP = Utils.findRequiredViewAsType(source, R.id.vp_advertisement, "field 'mBannerVP'", ViewPager.class);
    target.mTitleNameFbTV = Utils.findRequiredViewAsType(source, R.id.tv_title_name, "field 'mTitleNameFbTV'", TextView.class);
    target.mTotalWalletBLTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_balance, "field 'mTotalWalletBLTV'", TextView.class);
    target.mWalletRV = Utils.findRequiredViewAsType(source, R.id.rl_wallet, "field 'mWalletRV'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AllMatchesHTHActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mNotificationIV = null;
    target.mLeagueTV = null;
    target.mHomeTV = null;
    target.mHelpTV = null;
    target.mMatchRV = null;
    target.mSwipeRefreshL = null;
    target.mBannerVP = null;
    target.mTitleNameFbTV = null;
    target.mTotalWalletBLTV = null;
    target.mWalletRV = null;
  }
}
