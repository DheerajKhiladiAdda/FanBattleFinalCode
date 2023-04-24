// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectGroupAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private SelectGroupAdapter.PersonViewHolder target;

  @UiThread
  public SelectGroupAdapter$PersonViewHolder_ViewBinding(SelectGroupAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mGroupFL = Utils.findRequiredViewAsType(source, R.id.fl_group, "field 'mGroupFL'", FrameLayout.class);
    target.mGroupOneLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_1, "field 'mGroupOneLL'", LinearLayout.class);
    target.mGroupTwoLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_2, "field 'mGroupTwoLL'", LinearLayout.class);
    target.mGroupThreeLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_3, "field 'mGroupThreeLL'", LinearLayout.class);
    target.mGroupFourLL = Utils.findRequiredViewAsType(source, R.id.ll_item_group_4, "field 'mGroupFourLL'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectGroupAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mGroupFL = null;
    target.mGroupOneLL = null;
    target.mGroupTwoLL = null;
    target.mGroupThreeLL = null;
    target.mGroupFourLL = null;
  }
}
