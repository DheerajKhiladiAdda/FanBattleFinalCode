// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.fanleague.adapter;

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

public class MyFanLeagueAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private MyFanLeagueAdapter.PersonViewHolder target;

  @UiThread
  public MyFanLeagueAdapter$PersonViewHolder_ViewBinding(MyFanLeagueAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mOneIV'", ImageView.class);
    target.mTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTwoIV'", ImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_score, "field 'mScoreTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyFanLeagueAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOneIV = null;
    target.mTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mScoreTV = null;
  }
}
