// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

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

public class BattleActivity_ViewBinding implements Unbinder {
  private BattleActivity target;

  @UiThread
  public BattleActivity_ViewBinding(BattleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattleActivity_ViewBinding(BattleActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWalletBalanceTV = Utils.findRequiredViewAsType(source, R.id.tv_total_wallet_balance, "field 'mWalletBalanceTV'", TextView.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", ImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", ImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mHowPlayTV = Utils.findRequiredViewAsType(source, R.id.tv_how_play, "field 'mHowPlayTV'", TextView.class);
    target.mCalculateTV = Utils.findRequiredViewAsType(source, R.id.tv_calculate, "field 'mCalculateTV'", TextView.class);
    target.mPrizePoolTV = Utils.findRequiredViewAsType(source, R.id.tv_set, "field 'mPrizePoolTV'", TextView.class);
    target.mBattleRV = Utils.findRequiredViewAsType(source, R.id.rv_battle, "field 'mBattleRV'", RecyclerView.class);
    target.mBattleCategoryRV = Utils.findRequiredViewAsType(source, R.id.rv_battle_category, "field 'mBattleCategoryRV'", RecyclerView.class);
    target.mAcitivtyName = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mAcitivtyName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mNotificationIV = null;
    target.mWalletBalanceTV = null;
    target.mTeamOneIV = null;
    target.mTeamTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mHowPlayTV = null;
    target.mCalculateTV = null;
    target.mPrizePoolTV = null;
    target.mBattleRV = null;
    target.mBattleCategoryRV = null;
    target.mAcitivtyName = null;
  }
}
