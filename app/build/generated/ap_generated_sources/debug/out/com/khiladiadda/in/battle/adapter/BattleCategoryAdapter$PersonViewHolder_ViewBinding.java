// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle.adapter;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BattleCategoryAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private BattleCategoryAdapter.PersonViewHolder target;

  @UiThread
  public BattleCategoryAdapter$PersonViewHolder_ViewBinding(
      BattleCategoryAdapter.PersonViewHolder target, View source) {
    this.target = target;

    target.mFilterNameBTN = Utils.findRequiredViewAsType(source, R.id.btn_category, "field 'mFilterNameBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BattleCategoryAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFilterNameBTN = null;
  }
}
