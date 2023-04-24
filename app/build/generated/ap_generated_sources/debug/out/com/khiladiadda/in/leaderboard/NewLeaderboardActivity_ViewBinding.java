// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.leaderboard;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.khiladiadda.in.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewLeaderboardActivity_ViewBinding implements Unbinder {
  private NewLeaderboardActivity target;

  @UiThread
  public NewLeaderboardActivity_ViewBinding(NewLeaderboardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewLeaderboardActivity_ViewBinding(NewLeaderboardActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mClashxBTN = Utils.findRequiredViewAsType(source, R.id.btn_clashx, "field 'mClashxBTN'", Button.class);
    target.mLeaderBoardRV = Utils.findRequiredViewAsType(source, R.id.rv_leaderboard, "field 'mLeaderBoardRV'", RecyclerView.class);
    target.mLudoLeaderBoardRV = Utils.findRequiredViewAsType(source, R.id.rv_ludo_leaderboard, "field 'mLudoLeaderBoardRV'", RecyclerView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mTitleToolbarTV = Utils.findRequiredViewAsType(source, R.id.tv_profile_name_single, "field 'mTitleToolbarTV'", AppCompatTextView.class);
    target.mTitleTV = Utils.findRequiredViewAsType(source, R.id.tv_leaderboard, "field 'mTitleTV'", TextView.class);
    target.mCollapsingToolbar = Utils.findRequiredViewAsType(source, R.id.collapsing_toolbar, "field 'mCollapsingToolbar'", CollapsingToolbarLayout.class);
    target.mAppBarLayout = Utils.findRequiredViewAsType(source, R.id.app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
    target.mGoldWinnerIV = Utils.findRequiredViewAsType(source, R.id.gold_winner, "field 'mGoldWinnerIV'", CircularImageView.class);
    target.mGoldCrownIV = Utils.findRequiredViewAsType(source, R.id.gold_crown, "field 'mGoldCrownIV'", ImageView.class);
    target.mGoldWinerNameTV = Utils.findRequiredViewAsType(source, R.id.text_gold_winner_name, "field 'mGoldWinerNameTV'", TextView.class);
    target.mGoldCoinsTV = Utils.findRequiredViewAsType(source, R.id.gold_winner_coins, "field 'mGoldCoinsTV'", TextView.class);
    target.mSliverWinerIV = Utils.findRequiredViewAsType(source, R.id.sliver_winner, "field 'mSliverWinerIV'", CircularImageView.class);
    target.mSilverCrownIV = Utils.findRequiredViewAsType(source, R.id.silver_crown, "field 'mSilverCrownIV'", ImageView.class);
    target.mSilverWinerNameTV = Utils.findRequiredViewAsType(source, R.id.text_silver_winner_name, "field 'mSilverWinerNameTV'", TextView.class);
    target.mSilverWinerCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_sliver_winner_coins, "field 'mSilverWinerCoinsTV'", TextView.class);
    target.mBronzeWinnerIV = Utils.findRequiredViewAsType(source, R.id.bronze_winner, "field 'mBronzeWinnerIV'", CircularImageView.class);
    target.mBronzeCrownIV = Utils.findRequiredViewAsType(source, R.id.bronze_crown, "field 'mBronzeCrownIV'", ImageView.class);
    target.mBrownWinnerNameTV = Utils.findRequiredViewAsType(source, R.id.brown_winner_name, "field 'mBrownWinnerNameTV'", TextView.class);
    target.mBrownWinnerCoinsTV = Utils.findRequiredViewAsType(source, R.id.brown_winner_coins, "field 'mBrownWinnerCoinsTV'", TextView.class);
    target.mFanBattleBTN = Utils.findRequiredViewAsType(source, R.id.btn_fan_battle, "field 'mFanBattleBTN'", Button.class);
    target.mFanBattledRV = Utils.findRequiredViewAsType(source, R.id.rv_fanbattle_leaderboard, "field 'mFanBattledRV'", RecyclerView.class);
    target.mLeaderBoradRL = Utils.findRequiredViewAsType(source, R.id.leaderboard, "field 'mLeaderBoradRL'", RelativeLayout.class);
    target.mToolbarBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back_toolbar, "field 'mToolbarBackIV'", ImageView.class);
    target.mALLMonthSW = Utils.findRequiredViewAsType(source, R.id.sm_leaderboard, "field 'mALLMonthSW'", SwitchMaterial.class);
    target.mBottomLL = Utils.findRequiredViewAsType(source, R.id.ll_bottom, "field 'mBottomLL'", LinearLayout.class);
    target.mHTHRV = Utils.findRequiredViewAsType(source, R.id.rv_hth_leaderboard, "field 'mHTHRV'", RecyclerView.class);
    target.mLudoAddaRV = Utils.findRequiredViewAsType(source, R.id.rv_ludoadda_leaderboard, "field 'mLudoAddaRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewLeaderboardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mClashxBTN = null;
    target.mLeaderBoardRV = null;
    target.mLudoLeaderBoardRV = null;
    target.mNoDataTV = null;
    target.mTitleToolbarTV = null;
    target.mTitleTV = null;
    target.mCollapsingToolbar = null;
    target.mAppBarLayout = null;
    target.mGoldWinnerIV = null;
    target.mGoldCrownIV = null;
    target.mGoldWinerNameTV = null;
    target.mGoldCoinsTV = null;
    target.mSliverWinerIV = null;
    target.mSilverCrownIV = null;
    target.mSilverWinerNameTV = null;
    target.mSilverWinerCoinsTV = null;
    target.mBronzeWinnerIV = null;
    target.mBronzeCrownIV = null;
    target.mBrownWinnerNameTV = null;
    target.mBrownWinnerCoinsTV = null;
    target.mFanBattleBTN = null;
    target.mFanBattledRV = null;
    target.mLeaderBoradRL = null;
    target.mToolbarBackIV = null;
    target.mALLMonthSW = null;
    target.mBottomLL = null;
    target.mHTHRV = null;
    target.mLudoAddaRV = null;
  }
}
