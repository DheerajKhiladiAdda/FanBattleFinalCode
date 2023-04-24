// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.leaderboard;

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

public class HTHLeadBoardAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HTHLeadBoardAdapter.ViewHolder target;

  @UiThread
  public HTHLeadBoardAdapter$ViewHolder_ViewBinding(HTHLeadBoardAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_score, "field 'mScoreTV'", TextView.class);
    target.mUsernameTV = Utils.findRequiredViewAsType(source, R.id.tv_username, "field 'mUsernameTV'", TextView.class);
    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mRankTV = Utils.findRequiredViewAsType(source, R.id.tv_rank, "field 'mRankTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HTHLeadBoardAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTV = null;
    target.mScoreTV = null;
    target.mUsernameTV = null;
    target.mProfileIV = null;
    target.mRankTV = null;
  }
}
