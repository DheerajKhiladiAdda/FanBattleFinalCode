// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattlesUpcomingActivity_ViewBinding implements Unbinder {
  private BattlesUpcomingActivity target;

  @UiThread
  public BattlesUpcomingActivity_ViewBinding(BattlesUpcomingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BattlesUpcomingActivity_ViewBinding(BattlesUpcomingActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", CircleImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNoDataTV = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mNoDataTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mCalculateTV = Utils.findRequiredViewAsType(source, R.id.tv_calculate, "field 'mCalculateTV'", TextView.class);
    target.mBattleRV = Utils.findRequiredViewAsType(source, R.id.rv_battle, "field 'mBattleRV'", RecyclerView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
    target.mTimeTV = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTimeTV'", TextView.class);
    target.mAmountLL = Utils.findRequiredViewAsType(source, R.id.ll_amount, "field 'mAmountLL'", LinearLayout.class);
    target.mPointsTV = Utils.findRequiredViewAsType(source, R.id.tv_points, "field 'mPointsTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattlesUpcomingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mTeamOneIV = null;
    target.mTeamTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNoDataTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mCalculateTV = null;
    target.mBattleRV = null;
    target.mAmountTV = null;
    target.mTimeTV = null;
    target.mAmountLL = null;
    target.mPointsTV = null;
  }
}
