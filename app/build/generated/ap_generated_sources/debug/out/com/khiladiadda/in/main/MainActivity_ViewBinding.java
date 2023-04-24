// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.main;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.navigation.NavigationView;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mDrawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'mDrawer'", DrawerLayout.class);
    target.mNavigationView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'mNavigationView'", NavigationView.class);
    target.mBannerVP = Utils.findRequiredViewAsType(source, R.id.vp_advertisement, "field 'mBannerVP'", ViewPager.class);
    target.mMenuIV = Utils.findRequiredViewAsType(source, R.id.iv_menu, "field 'mMenuIV'", ImageView.class);
    target.mWalletRV = Utils.findRequiredViewAsType(source, R.id.rl_wallet, "field 'mWalletRV'", LinearLayout.class);
    target.mWalletBalanceTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_balance, "field 'mWalletBalanceTV'", TextView.class);
    target.frameLayout = Utils.findRequiredViewAsType(source, R.id.actionbadge, "field 'frameLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDrawer = null;
    target.mNavigationView = null;
    target.mBannerVP = null;
    target.mMenuIV = null;
    target.mWalletRV = null;
    target.mWalletBalanceTV = null;
    target.frameLayout = null;
  }
}
