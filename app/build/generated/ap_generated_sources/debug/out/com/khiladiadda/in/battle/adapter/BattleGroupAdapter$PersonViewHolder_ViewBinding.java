// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattleGroupAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private BattleGroupAdapter.PersonViewHolder target;

  @UiThread
  public BattleGroupAdapter$PersonViewHolder_ViewBinding(BattleGroupAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mGroupFL = Utils.findRequiredViewAsType(source, R.id.fl_group, "field 'mGroupFL'", FrameLayout.class);
    target.mGroupOneLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_1, "field 'mGroupOneLL'", LinearLayout.class);
    target.mGroupTwoLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_2, "field 'mGroupTwoLL'", LinearLayout.class);
    target.mGroupThreeLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_3, "field 'mGroupThreeLL'", LinearLayout.class);
    target.mGroupFourLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_4, "field 'mGroupFourLL'", LinearLayout.class);
    target.mInvestmentRL = Utils.findRequiredViewAsType(source, R.id.rl_investment, "field 'mInvestmentRL'", RelativeLayout.class);
    target.mInvestedAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_invested_amount, "field 'mInvestedAmountTV'", TextView.class);
    target.mEstimatedProfitTV = Utils.findRequiredViewAsType(source, R.id.tv_estimated_profit, "field 'mEstimatedProfitTV'", TextView.class);
    target.mParticipantTV = Utils.findRequiredViewAsType(source, R.id.tv_total_participant, "field 'mParticipantTV'", TextView.class);
    target.mSelectedbyTv = Utils.findRequiredViewAsType(source, R.id.tv_total_selected, "field 'mSelectedbyTv'", TextView.class);
    target.mChangeTV = Utils.findRequiredViewAsType(source, R.id.tv_cancel, "field 'mChangeTV'", TextView.class);
    target.mInvestTV = Utils.findRequiredViewAsType(source, R.id.tv_invest, "field 'mInvestTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleGroupAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mGroupFL = null;
    target.mGroupOneLL = null;
    target.mGroupTwoLL = null;
    target.mGroupThreeLL = null;
    target.mGroupFourLL = null;
    target.mInvestmentRL = null;
    target.mInvestedAmountTV = null;
    target.mEstimatedProfitTV = null;
    target.mParticipantTV = null;
    target.mSelectedbyTv = null;
    target.mChangeTV = null;
    target.mInvestTV = null;
  }
}
