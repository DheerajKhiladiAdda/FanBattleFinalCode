// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.adpater;

import android.view.View;
import android.widget.LinearLayout;
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
import pl.droidsonroids.gif.GifImageView;

public class MyBattlesAdpater$PersonViewHolder_ViewBinding implements Unbinder {
  private MyBattlesAdpater.PersonViewHolder target;

  @UiThread
  public MyBattlesAdpater$PersonViewHolder_ViewBinding(MyBattlesAdpater.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mPlayerOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mPlayerOneIV'", CircleImageView.class);
    target.mPlayerOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mPlayerOneTV'", TextView.class);
    target.mPlayerTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mPlayerTwoIV'", CircleImageView.class);
    target.mPlayerTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mPlayerTwoTV'", TextView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_win, "field 'mAmountTV'", TextView.class);
    target.mIDTV = Utils.findRequiredViewAsType(source, R.id.tv_id, "field 'mIDTV'", TextView.class);
    target.mEntryFeesTV = Utils.findRequiredViewAsType(source, R.id.tv_entry, "field 'mEntryFeesTV'", TextView.class);
    target.mWaitingTV = Utils.findRequiredViewAsType(source, R.id.tv_waiting, "field 'mWaitingTV'", TextView.class);
    target.mGifIV = Utils.findRequiredViewAsType(source, R.id.gif_image, "field 'mGifIV'", GifImageView.class);
    target.main = Utils.findRequiredViewAsType(source, R.id.rl_main, "field 'main'", RelativeLayout.class);
    target.mwinLL = Utils.findRequiredViewAsType(source, R.id.ll_win, "field 'mwinLL'", LinearLayout.class);
    target.mTV = Utils.findRequiredViewAsType(source, R.id.tv_lineupout, "field 'mTV'", TextView.class);
    target.mWon = Utils.findRequiredViewAsType(source, R.id.tv_won, "field 'mWon'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyBattlesAdpater.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPlayerOneIV = null;
    target.mPlayerOneTV = null;
    target.mPlayerTwoIV = null;
    target.mPlayerTwoTV = null;
    target.mAmountTV = null;
    target.mIDTV = null;
    target.mEntryFeesTV = null;
    target.mWaitingTV = null;
    target.mGifIV = null;
    target.main = null;
    target.mwinLL = null;
    target.mTV = null;
    target.mWon = null;
  }
}
