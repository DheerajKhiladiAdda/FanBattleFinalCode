// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.leaderboard.past.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PastLeaderBoardRVAdapter$EventHolder_ViewBinding implements Unbinder {
  private PastLeaderBoardRVAdapter.EventHolder target;

  @UiThread
  public PastLeaderBoardRVAdapter$EventHolder_ViewBinding(
      PastLeaderBoardRVAdapter.EventHolder target, View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mRankTV = Utils.findRequiredViewAsType(source, R.id.tv_rank, "field 'mRankTV'", TextView.class);
    target.mWinTV = Utils.findRequiredViewAsType(source, R.id.tv_win, "field 'mWinTV'", TextView.class);
    target.mTeamMateRV = Utils.findRequiredViewAsType(source, R.id.rv_team_mate, "field 'mTeamMateRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PastLeaderBoardRVAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mRankTV = null;
    target.mWinTV = null;
    target.mTeamMateRV = null;
  }
}
