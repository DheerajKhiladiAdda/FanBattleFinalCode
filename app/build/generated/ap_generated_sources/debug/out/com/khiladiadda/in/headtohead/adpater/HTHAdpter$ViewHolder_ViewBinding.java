// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.adpater;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HTHAdpter$ViewHolder_ViewBinding implements Unbinder {
  private HTHAdpter.ViewHolder target;

  @UiThread
  public HTHAdpter$ViewHolder_ViewBinding(HTHAdpter.ViewHolder target, View source) {
    this.target = target;

    target.mOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mOneIV'", CircleImageView.class);
    target.mTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mDateTV = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTV'", TextView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mTimeLeftTV = Utils.findRequiredViewAsType(source, R.id.tv_time_left, "field 'mTimeLeftTV'", TextView.class);
    target.mTimeTV = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTimeTV'", TextView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
    target.mLineOutTV = Utils.findRequiredViewAsType(source, R.id.tv_lineupout, "field 'mLineOutTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HTHAdpter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOneIV = null;
    target.mTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mDateTV = null;
    target.mNameTV = null;
    target.mTimeLeftTV = null;
    target.mTimeTV = null;
    target.mAmountTV = null;
    target.mLineOutTV = null;
  }
}
