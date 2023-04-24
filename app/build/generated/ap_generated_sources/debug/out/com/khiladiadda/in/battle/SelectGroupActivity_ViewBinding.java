// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectGroupActivity_ViewBinding implements Unbinder {
  private SelectGroupActivity target;

  @UiThread
  public SelectGroupActivity_ViewBinding(SelectGroupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectGroupActivity_ViewBinding(SelectGroupActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mGroupRV = Utils.findRequiredViewAsType(source, R.id.rv_group, "field 'mGroupRV'", RecyclerView.class);
    target.mSelectComboTV = Utils.findRequiredViewAsType(source, R.id.tv_select_combo, "field 'mSelectComboTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectGroupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mGroupRV = null;
    target.mSelectComboTV = null;
  }
}
