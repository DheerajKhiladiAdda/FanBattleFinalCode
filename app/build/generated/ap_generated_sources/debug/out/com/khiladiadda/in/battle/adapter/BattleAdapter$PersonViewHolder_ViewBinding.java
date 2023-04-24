// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattleAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private BattleAdapter.PersonViewHolder target;

  @UiThread
  public BattleAdapter$PersonViewHolder_ViewBinding(BattleAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mLayoutRL = Utils.findRequiredViewAsType(source, R.id.layout_1, "field 'mLayoutRL'", RelativeLayout.class);
    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mGroupTV = Utils.findRequiredViewAsType(source, R.id.tv_group, "field 'mGroupTV'", TextView.class);
    target.mParticipantTV = Utils.findRequiredViewAsType(source, R.id.tv_participant, "field 'mParticipantTV'", TextView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
    target.mPlayBTN = Utils.findRequiredViewAsType(source, R.id.btn_play, "field 'mPlayBTN'", Button.class);
    target.mProgressPB = Utils.findRequiredViewAsType(source, R.id.pb_profile_progress, "field 'mProgressPB'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLayoutRL = null;
    target.mProfileIV = null;
    target.mNameTV = null;
    target.mGroupTV = null;
    target.mParticipantTV = null;
    target.mAmountTV = null;
    target.mPlayBTN = null;
    target.mProgressPB = null;
  }
}
