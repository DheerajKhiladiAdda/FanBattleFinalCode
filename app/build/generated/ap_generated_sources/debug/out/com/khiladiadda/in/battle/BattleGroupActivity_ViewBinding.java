// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattleGroupActivity_ViewBinding implements Unbinder {
  private BattleGroupActivity target;

  @UiThread
  public BattleGroupActivity_ViewBinding(BattleGroupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattleGroupActivity_ViewBinding(BattleGroupActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mGroupRV = Utils.findRequiredViewAsType(source, R.id.rv_group, "field 'mGroupRV'", RecyclerView.class);
    target.mQuestionTV = Utils.findRequiredViewAsType(source, R.id.tv_question, "field 'mQuestionTV'", TextView.class);
    target.mPrizeTV = Utils.findRequiredViewAsType(source, R.id.tv_prize, "field 'mPrizeTV'", TextView.class);
    target.mParticipantTV = Utils.findRequiredViewAsType(source, R.id.tv_participant, "field 'mParticipantTV'", TextView.class);
    target.mSelectComboTV = Utils.findRequiredViewAsType(source, R.id.tv_select_combo, "field 'mSelectComboTV'", TextView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mLiveBattleTV = Utils.findRequiredViewAsType(source, R.id.tv_live_battle, "field 'mLiveBattleTV'", TextView.class);
    target.mHowPlayTV = Utils.findRequiredViewAsType(source, R.id.tv_how_play, "field 'mHowPlayTV'", TextView.class);
    target.mCalculateTV = Utils.findRequiredViewAsType(source, R.id.tv_calculate, "field 'mCalculateTV'", TextView.class);
    target.mSwipeRefreshL = Utils.findRequiredViewAsType(source, R.id.swipeRefresh, "field 'mSwipeRefreshL'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleGroupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mGroupRV = null;
    target.mQuestionTV = null;
    target.mPrizeTV = null;
    target.mParticipantTV = null;
    target.mSelectComboTV = null;
    target.mActivityNameTV = null;
    target.mLiveBattleTV = null;
    target.mHowPlayTV = null;
    target.mCalculateTV = null;
    target.mSwipeRefreshL = null;
  }
}
