// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerAdapter$EventHolder_ViewBinding implements Unbinder {
  private PlayerAdapter.EventHolder target;

  @UiThread
  public PlayerAdapter$EventHolder_ViewBinding(PlayerAdapter.EventHolder target, View source) {
    this.target = target;

    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mTeamNameTV = Utils.findRequiredViewAsType(source, R.id.tv_team_name, "field 'mTeamNameTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mPlayBTN = Utils.findRequiredViewAsType(source, R.id.btn_play, "field 'mPlayBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayerAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProfileIV = null;
    target.mTeamNameTV = null;
    target.mNameTV = null;
    target.mPlayBTN = null;
  }
}
