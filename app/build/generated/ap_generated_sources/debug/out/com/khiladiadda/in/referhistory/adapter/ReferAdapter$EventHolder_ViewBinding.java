// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.referhistory.adapter;

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

public class ReferAdapter$EventHolder_ViewBinding implements Unbinder {
  private ReferAdapter.EventHolder target;

  @UiThread
  public ReferAdapter$EventHolder_ViewBinding(ReferAdapter.EventHolder target, View source) {
    this.target = target;

    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mUsernameTV = Utils.findRequiredViewAsType(source, R.id.tv_user_name, "field 'mUsernameTV'", TextView.class);
    target.mGameUsernameTV = Utils.findRequiredViewAsType(source, R.id.tv_game_username, "field 'mGameUsernameTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReferAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProfileIV = null;
    target.mNameTV = null;
    target.mUsernameTV = null;
    target.mGameUsernameTV = null;
  }
}
