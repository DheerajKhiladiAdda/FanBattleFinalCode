// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;
import pl.droidsonroids.gif.GifImageView;

public class BattlesScoreActivity_ViewBinding implements Unbinder {
  private BattlesScoreActivity target;

  @UiThread
  public BattlesScoreActivity_ViewBinding(BattlesScoreActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattlesScoreActivity_ViewBinding(BattlesScoreActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", CircleImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mTPlayerOneEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player1edit, "field 'mTPlayerOneEditIV'", ImageView.class);
    target.mTPlayerTwoEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player2edit, "field 'mTPlayerTwoEditIV'", ImageView.class);
    target.mTPlayerThreeEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player3edit, "field 'mTPlayerThreeEditIV'", ImageView.class);
    target.mTPlayerFourEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player4edit, "field 'mTPlayerFourEditIV'", ImageView.class);
    target.mTPlayerOneEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player1edit, "field 'mTPlayerOneEditTV'", TextView.class);
    target.mTPlayerTwoEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player2edit, "field 'mTPlayerTwoEditTV'", TextView.class);
    target.mTPlayerThreeEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player3edit, "field 'mTPlayerThreeEditTV'", TextView.class);
    target.mTPlayerFourEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player4edit, "field 'mTPlayerFourEditTV'", TextView.class);
    target.mTPlayerOneIV = Utils.findRequiredViewAsType(source, R.id.iv_player1, "field 'mTPlayerOneIV'", ImageView.class);
    target.mTPlayerTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_player2, "field 'mTPlayerTwoIV'", ImageView.class);
    target.mTPlayerThreeIV = Utils.findRequiredViewAsType(source, R.id.iv_player3, "field 'mTPlayerThreeIV'", ImageView.class);
    target.mTPlayerFourIV = Utils.findRequiredViewAsType(source, R.id.iv_player4, "field 'mTPlayerFourIV'", ImageView.class);
    target.mTPlayerOneTV = Utils.findRequiredViewAsType(source, R.id.tv_player1, "field 'mTPlayerOneTV'", TextView.class);
    target.mTPlayerTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_player2, "field 'mTPlayerTwoTV'", TextView.class);
    target.mTPlayerThreeTV = Utils.findRequiredViewAsType(source, R.id.tv_player3, "field 'mTPlayerThreeTV'", TextView.class);
    target.mTPlayerFourTV = Utils.findRequiredViewAsType(source, R.id.tv_player4, "field 'mTPlayerFourTV'", TextView.class);
    target.mPointsLosingTV = Utils.findRequiredViewAsType(source, R.id.tv_points_oppents, "field 'mPointsLosingTV'", TextView.class);
    target.mPointsWinningTV = Utils.findRequiredViewAsType(source, R.id.tv_points, "field 'mPointsWinningTV'", TextView.class);
    target.mWinningIV = Utils.findRequiredViewAsType(source, R.id.iv_team_imagemy, "field 'mWinningIV'", ImageView.class);
    target.mLosingIV = Utils.findRequiredViewAsType(source, R.id.iv_team_imageopp, "field 'mLosingIV'", ImageView.class);
    target.mGIFIV = Utils.findRequiredViewAsType(source, R.id.gif_image, "field 'mGIFIV'", GifImageView.class);
    target.mStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mStatus'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_text_name, "field 'mNameTV'", TextView.class);
    target.mOppNameTV = Utils.findRequiredViewAsType(source, R.id.tv_text_nameopp, "field 'mOppNameTV'", TextView.class);
    target.mOppentCV = Utils.findRequiredViewAsType(source, R.id.oppcard, "field 'mOppentCV'", CardView.class);
    target.mWinningCV = Utils.findRequiredViewAsType(source, R.id.cardwin, "field 'mWinningCV'", CardView.class);
    target.mContestId = Utils.findRequiredViewAsType(source, R.id.tv_battleid, "field 'mContestId'", TextView.class);
    target.mSwipeRefreshL = Utils.findRequiredViewAsType(source, R.id.swipeRefresh, "field 'mSwipeRefreshL'", SwipeRefreshLayout.class);
    target.mSubstituteTV = Utils.findRequiredViewAsType(source, R.id.tv_substitute_msg, "field 'mSubstituteTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattlesScoreActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mTeamOneIV = null;
    target.mTeamTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mTPlayerOneEditIV = null;
    target.mTPlayerTwoEditIV = null;
    target.mTPlayerThreeEditIV = null;
    target.mTPlayerFourEditIV = null;
    target.mTPlayerOneEditTV = null;
    target.mTPlayerTwoEditTV = null;
    target.mTPlayerThreeEditTV = null;
    target.mTPlayerFourEditTV = null;
    target.mTPlayerOneIV = null;
    target.mTPlayerTwoIV = null;
    target.mTPlayerThreeIV = null;
    target.mTPlayerFourIV = null;
    target.mTPlayerOneTV = null;
    target.mTPlayerTwoTV = null;
    target.mTPlayerThreeTV = null;
    target.mTPlayerFourTV = null;
    target.mPointsLosingTV = null;
    target.mPointsWinningTV = null;
    target.mWinningIV = null;
    target.mLosingIV = null;
    target.mGIFIV = null;
    target.mStatus = null;
    target.mNameTV = null;
    target.mOppNameTV = null;
    target.mOppentCV = null;
    target.mWinningCV = null;
    target.mContestId = null;
    target.mSwipeRefreshL = null;
    target.mSubstituteTV = null;
  }
}
