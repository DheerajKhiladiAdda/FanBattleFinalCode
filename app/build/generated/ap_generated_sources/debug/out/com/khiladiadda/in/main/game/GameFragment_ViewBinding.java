// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.main.game;

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

public class GameFragment_ViewBinding implements Unbinder {
  private GameFragment target;

  @UiThread
  public GameFragment_ViewBinding(GameFragment target, View source) {
    this.target = target;

    target.mHTHIV = Utils.findRequiredViewAsType(source, R.id.iv_clashx, "field 'mHTHIV'", ImageView.class);
    target.mFanbattleIV = Utils.findRequiredViewAsType(source, R.id.iv_fanbattle, "field 'mFanbattleIV'", ImageView.class);
    target.mGiftTV = Utils.findRequiredViewAsType(source, R.id.tv_gift, "field 'mGiftTV'", TextView.class);
    target.mWalletTV = Utils.findRequiredViewAsType(source, R.id.tv_wallet, "field 'mWalletTV'", TextView.class);
    target.mWinnerTV = Utils.findRequiredViewAsType(source, R.id.tv_winner, "field 'mWinnerTV'", TextView.class);
    target.mHelpTV = Utils.findRequiredViewAsType(source, R.id.tv_help, "field 'mHelpTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GameFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHTHIV = null;
    target.mFanbattleIV = null;
    target.mGiftTV = null;
    target.mWalletTV = null;
    target.mWinnerTV = null;
    target.mHelpTV = null;
  }
}
