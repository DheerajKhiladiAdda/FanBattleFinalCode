// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerSelectionAdapter$EventHolder_ViewBinding implements Unbinder {
  private PlayerSelectionAdapter.EventHolder target;

  @UiThread
  public PlayerSelectionAdapter$EventHolder_ViewBinding(PlayerSelectionAdapter.EventHolder target,
      View source) {
    this.target = target;

    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", CircleImageView.class);
    target.mTeamNameTV = Utils.findRequiredViewAsType(source, R.id.tv_team_name, "field 'mTeamNameTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mPlayBTN = Utils.findRequiredViewAsType(source, R.id.btn_play, "field 'mPlayBTN'", Button.class);
    target.mStatusTV = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mStatusTV'", TextView.class);
    target.mLayoutRL = Utils.findRequiredViewAsType(source, R.id.rl_layout, "field 'mLayoutRL'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayerSelectionAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProfileIV = null;
    target.mTeamNameTV = null;
    target.mNameTV = null;
    target.mPlayBTN = null;
    target.mStatusTV = null;
    target.mLayoutRL = null;
  }
}
