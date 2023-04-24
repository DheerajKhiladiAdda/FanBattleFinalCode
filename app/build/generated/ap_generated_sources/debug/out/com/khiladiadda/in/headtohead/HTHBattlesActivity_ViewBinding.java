// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HTHBattlesActivity_ViewBinding implements Unbinder {
  private HTHBattlesActivity target;

  @UiThread
  public HTHBattlesActivity_ViewBinding(HTHBattlesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HTHBattlesActivity_ViewBinding(HTHBattlesActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWalletBalanceTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_balance, "field 'mWalletBalanceTV'", TextView.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", CircleImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mTimeTV = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTimeTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mHowPlayTV = Utils.findRequiredViewAsType(source, R.id.tv_how_play, "field 'mHowPlayTV'", TextView.class);
    target.mCalculateTV = Utils.findRequiredViewAsType(source, R.id.tv_calculate, "field 'mCalculateTV'", TextView.class);
    target.mBattleRV = Utils.findRequiredViewAsType(source, R.id.rv_battle, "field 'mBattleRV'", RecyclerView.class);
    target.mRefreshTV = Utils.findRequiredViewAsType(source, R.id.rl_refresh, "field 'mRefreshTV'", RelativeLayout.class);
    target.mCreateBattleRL = Utils.findRequiredViewAsType(source, R.id.rl_create_battle, "field 'mCreateBattleRL'", RelativeLayout.class);
    target.mCategoryBTN = Utils.findRequiredViewAsType(source, R.id.btn_category, "field 'mCategoryBTN'", TextView.class);
    target.mCategoryMyBattleBTN = Utils.findRequiredViewAsType(source, R.id.btn_category_mybattles, "field 'mCategoryMyBattleBTN'", TextView.class);
    target.mSortLL = Utils.findRequiredViewAsType(source, R.id.ll_sort, "field 'mSortLL'", LinearLayout.class);
    target.mHSortHSV = Utils.findRequiredViewAsType(source, R.id.hsv_sort, "field 'mHSortHSV'", HorizontalScrollView.class);
    target.mTrendingCV = Utils.findRequiredViewAsType(source, R.id.cv_trending, "field 'mTrendingCV'", CardView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
    target.mPointsTV = Utils.findRequiredViewAsType(source, R.id.tv_points, "field 'mPointsTV'", TextView.class);
    target.mNewestBattlesLL = Utils.findRequiredViewAsType(source, R.id.ll_newest, "field 'mNewestBattlesLL'", LinearLayout.class);
    target.mHighEarningBattlesLL = Utils.findRequiredViewAsType(source, R.id.ll_highearning, "field 'mHighEarningBattlesLL'", LinearLayout.class);
    target.mLowEaBattlesLL = Utils.findRequiredViewAsType(source, R.id.ll_lowearning, "field 'mLowEaBattlesLL'", LinearLayout.class);
    target.mMyBattleRV = Utils.findRequiredViewAsType(source, R.id.rv_mybattle, "field 'mMyBattleRV'", RecyclerView.class);
    target.mImageIV = Utils.findRequiredViewAsType(source, R.id.iv_click_image, "field 'mImageIV'", ImageView.class);
    target.mAmountLL = Utils.findRequiredViewAsType(source, R.id.ll_amount, "field 'mAmountLL'", LinearLayout.class);
    target.mNewestLL = Utils.findRequiredViewAsType(source, R.id.ll_inner_newest, "field 'mNewestLL'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HTHBattlesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mNameTV = null;
    target.mNotificationIV = null;
    target.mWalletBalanceTV = null;
    target.mTeamOneIV = null;
    target.mTeamTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNoDataTV = null;
    target.mTimeTV = null;
    target.mTimeLeftTV = null;
    target.mHowPlayTV = null;
    target.mCalculateTV = null;
    target.mBattleRV = null;
    target.mRefreshTV = null;
    target.mCreateBattleRL = null;
    target.mCategoryBTN = null;
    target.mCategoryMyBattleBTN = null;
    target.mSortLL = null;
    target.mHSortHSV = null;
    target.mTrendingCV = null;
    target.mAmountTV = null;
    target.mPointsTV = null;
    target.mNewestBattlesLL = null;
    target.mHighEarningBattlesLL = null;
    target.mLowEaBattlesLL = null;
    target.mMyBattleRV = null;
    target.mImageIV = null;
    target.mAmountLL = null;
    target.mNewestLL = null;
  }
}
