// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RummyAdapter$LudoContestHolder_ViewBinding implements Unbinder {
  private RummyAdapter.LudoContestHolder target;

  @UiThread
  public RummyAdapter$LudoContestHolder_ViewBinding(RummyAdapter.LudoContestHolder target,
      View source) {
    this.target = target;

    target.mEntryFeeTV = Utils.findRequiredViewAsType(source, R.id.tv_entry_fee, "field 'mEntryFeeTV'", TextView.class);
    target.mPlayerTV = Utils.findRequiredViewAsType(source, R.id.tv_players, "field 'mPlayerTV'", TextView.class);
    target.mPlayersMoreTv = Utils.findRequiredViewAsType(source, R.id.tv_players_more, "field 'mPlayersMoreTv'", TextView.class);
    target.mOnlineTV = Utils.findRequiredViewAsType(source, R.id.tv_online, "field 'mOnlineTV'", TextView.class);
    target.mWinningAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_wining_amount, "field 'mWinningAmountTV'", TextView.class);
    target.mBonusTV = Utils.findRequiredViewAsType(source, R.id.tv_bonus, "field 'mBonusTV'", TextView.class);
    target.mPointsTv = Utils.findRequiredViewAsType(source, R.id.tv_points, "field 'mPointsTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyAdapter.LudoContestHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEntryFeeTV = null;
    target.mPlayerTV = null;
    target.mPlayersMoreTv = null;
    target.mOnlineTV = null;
    target.mWinningAmountTV = null;
    target.mBonusTV = null;
    target.mPointsTv = null;
  }
}
