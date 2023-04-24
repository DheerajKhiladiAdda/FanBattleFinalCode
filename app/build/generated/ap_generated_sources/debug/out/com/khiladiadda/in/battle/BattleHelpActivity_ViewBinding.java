// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattleHelpActivity_ViewBinding implements Unbinder {
  private BattleHelpActivity target;

  @UiThread
  public BattleHelpActivity_ViewBinding(BattleHelpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattleHelpActivity_ViewBinding(BattleHelpActivity target, View source) {
    this.target = target;

    target.mLuodHelpIV = Utils.findRequiredViewAsType(source, R.id.iv_ludo_help, "field 'mLuodHelpIV'", ImageView.class);
    target.mNextRL = Utils.findRequiredViewAsType(source, R.id.rl_next, "field 'mNextRL'", RelativeLayout.class);
    target.mPreviousRL = Utils.findRequiredViewAsType(source, R.id.rl_previous, "field 'mPreviousRL'", RelativeLayout.class);
    target.mNextIV = Utils.findRequiredViewAsType(source, R.id.iv_next, "field 'mNextIV'", ImageView.class);
    target.mNextBTN = Utils.findRequiredViewAsType(source, R.id.btn_next, "field 'mNextBTN'", TextView.class);
    target.mVideoBTN = Utils.findRequiredViewAsType(source, R.id.btn_view_video, "field 'mVideoBTN'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleHelpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLuodHelpIV = null;
    target.mNextRL = null;
    target.mPreviousRL = null;
    target.mNextIV = null;
    target.mNextBTN = null;
    target.mVideoBTN = null;
  }
}
