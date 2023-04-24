// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllBattlesAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private AllBattlesAdapter.PersonViewHolder target;

  @UiThread
  public AllBattlesAdapter$PersonViewHolder_ViewBinding(AllBattlesAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mPlayerOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mPlayerOneIV'", ImageView.class);
    target.mPlayerOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mPlayerOneTV'", TextView.class);
    target.mPlayerTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mPlayerTwoIV'", ImageView.class);
    target.mPlayerTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mPlayerTwoTV'", TextView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_win, "field 'mAmountTV'", TextView.class);
    target.mVsTV = Utils.findRequiredViewAsType(source, R.id.vs, "field 'mVsTV'", TextView.class);
    target.mIDTV = Utils.findRequiredViewAsType(source, R.id.tv_id, "field 'mIDTV'", TextView.class);
    target.mEntryFeesTV = Utils.findRequiredViewAsType(source, R.id.tv_entry, "field 'mEntryFeesTV'", TextView.class);
    target.mOneLL = Utils.findRequiredViewAsType(source, R.id.ll_one, "field 'mOneLL'", LinearLayout.class);
    target.mAcceptTV = Utils.findRequiredViewAsType(source, R.id.tv_accept, "field 'mAcceptTV'", TextView.class);
    target.mCancelTV = Utils.findRequiredViewAsType(source, R.id.tv_cancel, "field 'mCancelTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AllBattlesAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPlayerOneIV = null;
    target.mPlayerOneTV = null;
    target.mPlayerTwoIV = null;
    target.mPlayerTwoTV = null;
    target.mAmountTV = null;
    target.mVsTV = null;
    target.mIDTV = null;
    target.mEntryFeesTV = null;
    target.mOneLL = null;
    target.mAcceptTV = null;
    target.mCancelTV = null;
  }
}
