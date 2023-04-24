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

public class MyFanLeagueAdapterHTH$ViewHolder_ViewBinding implements Unbinder {
  private MyFanLeagueAdapterHTH.ViewHolder target;

  @UiThread
  public MyFanLeagueAdapterHTH$ViewHolder_ViewBinding(MyFanLeagueAdapterHTH.ViewHolder target,
      View source) {
    this.target = target;

    target.mPlayerOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mPlayerOneIV'", CircleImageView.class);
    target.mPlayerOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mPlayerOneTV'", TextView.class);
    target.mPlayerTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mPlayerTwoIV'", CircleImageView.class);
    target.mPlayerTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mPlayerTwoTV'", TextView.class);
    target.mLLAmount = Utils.findRequiredViewAsType(source, R.id.ll_amount, "field 'mLLAmount'", LinearLayout.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTimeLeftTV'", TextView.class);
    target.mLineOutTV = Utils.findRequiredViewAsType(source, R.id.tv_lineupout, "field 'mLineOutTV'", TextView.class);
    target.mLineupRL = Utils.findRequiredViewAsType(source, R.id.rl_lineup, "field 'mLineupRL'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyFanLeagueAdapterHTH.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPlayerOneIV = null;
    target.mPlayerOneTV = null;
    target.mPlayerTwoIV = null;
    target.mPlayerTwoTV = null;
    target.mLLAmount = null;
    target.mDateTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mLineOutTV = null;
    target.mLineupRL = null;
  }
}
