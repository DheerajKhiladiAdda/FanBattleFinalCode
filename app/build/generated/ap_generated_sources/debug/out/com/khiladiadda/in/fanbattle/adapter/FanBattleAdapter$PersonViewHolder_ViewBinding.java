// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fanbattle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FanBattleAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private FanBattleAdapter.PersonViewHolder target;

  @UiThread
  public FanBattleAdapter$PersonViewHolder_ViewBinding(FanBattleAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mOneIV'", ImageView.class);
    target.mTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTwoIV'", ImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mDateTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mDateOnlyTV = Utils.findRequiredViewAsType(source, R.id.tv_date_new, "field 'mDateOnlyTV'", TextView.class);
    target.mWinUpToPrizeTV = Utils.findRequiredViewAsType(source, R.id.tv_win_up_to_prize, "field 'mWinUpToPrizeTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FanBattleAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOneIV = null;
    target.mTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mDateOnlyTV = null;
    target.mWinUpToPrizeTV = null;
  }
}
