// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectedPlayers_ViewBinding implements Unbinder {
  private SelectedPlayers target;

  @UiThread
  public SelectedPlayers_ViewBinding(SelectedPlayers target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectedPlayers_ViewBinding(SelectedPlayers target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", CircleImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mTPlayerOneEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player1edit, "field 'mTPlayerOneEditIV'", CircleImageView.class);
    target.mTPlayerTwoEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player2edit, "field 'mTPlayerTwoEditIV'", CircleImageView.class);
    target.mTPlayerThreeEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player3edit, "field 'mTPlayerThreeEditIV'", CircleImageView.class);
    target.mTPlayerFourEditIV = Utils.findRequiredViewAsType(source, R.id.iv_player4edit, "field 'mTPlayerFourEditIV'", CircleImageView.class);
    target.mTPlayerOneEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player1edit, "field 'mTPlayerOneEditTV'", TextView.class);
    target.mTPlayerTwoEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player2edit, "field 'mTPlayerTwoEditTV'", TextView.class);
    target.mTPlayerThreeEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player3edit, "field 'mTPlayerThreeEditTV'", TextView.class);
    target.mTPlayerFourEditTV = Utils.findRequiredViewAsType(source, R.id.tv_player4edit, "field 'mTPlayerFourEditTV'", TextView.class);
    target.mTPlayerOneIV = Utils.findRequiredViewAsType(source, R.id.iv_player1, "field 'mTPlayerOneIV'", CircleImageView.class);
    target.mTPlayerTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_player2, "field 'mTPlayerTwoIV'", CircleImageView.class);
    target.mTPlayerThreeIV = Utils.findRequiredViewAsType(source, R.id.iv_player3, "field 'mTPlayerThreeIV'", CircleImageView.class);
    target.mTPlayerFourIV = Utils.findRequiredViewAsType(source, R.id.iv_player4, "field 'mTPlayerFourIV'", CircleImageView.class);
    target.mTPlayerOneTV = Utils.findRequiredViewAsType(source, R.id.tv_player1, "field 'mTPlayerOneTV'", TextView.class);
    target.mTPlayerTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_player2, "field 'mTPlayerTwoTV'", TextView.class);
    target.mTPlayerThreeTV = Utils.findRequiredViewAsType(source, R.id.tv_player3, "field 'mTPlayerThreeTV'", TextView.class);
    target.mTPlayerFourTV = Utils.findRequiredViewAsType(source, R.id.tv_player4, "field 'mTPlayerFourTV'", TextView.class);
    target.mEditBTN = Utils.findRequiredViewAsType(source, R.id.btn_edit, "field 'mEditBTN'", AppCompatButton.class);
    target.mOppTV = Utils.findRequiredViewAsType(source, R.id.tv_text_nameopp, "field 'mOppTV'", TextView.class);
    target.mOPPIV = Utils.findRequiredViewAsType(source, R.id.iv_team_imageopp, "field 'mOPPIV'", ImageView.class);
    target.mTeamCapIV = Utils.findRequiredViewAsType(source, R.id.iv_team_imagemy, "field 'mTeamCapIV'", ImageView.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", AppCompatButton.class);
    target.mMainRL = Utils.findRequiredViewAsType(source, R.id.rl_main, "field 'mMainRL'", RelativeLayout.class);
    target.mChangeLL = Utils.findRequiredViewAsType(source, R.id.ll_change, "field 'mChangeLL'", LinearLayout.class);
    target.mSomePlayersTV = Utils.findRequiredViewAsType(source, R.id.tv_some_player, "field 'mSomePlayersTV'", TextView.class);
    target.mAcceptBTN = Utils.findRequiredViewAsType(source, R.id.btn_accept, "field 'mAcceptBTN'", AppCompatButton.class);
    target.mEdaitbleCV = Utils.findRequiredViewAsType(source, R.id.editable, "field 'mEdaitbleCV'", CardView.class);
    target.mContestId = Utils.findRequiredViewAsType(source, R.id.tv_battleid, "field 'mContestId'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectedPlayers target = this.target;
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
    target.mEditBTN = null;
    target.mOppTV = null;
    target.mOPPIV = null;
    target.mTeamCapIV = null;
    target.mCancelBTN = null;
    target.mMainRL = null;
    target.mChangeLL = null;
    target.mSomePlayersTV = null;
    target.mAcceptBTN = null;
    target.mEdaitbleCV = null;
    target.mContestId = null;
  }
}
