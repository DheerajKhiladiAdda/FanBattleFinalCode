// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins.adapter;

import android.view.View;
import android.widget.ImageButton;
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

public class NewBeneficiaryAdapter$ViewHolder_ViewBinding implements Unbinder {
  private NewBeneficiaryAdapter.ViewHolder target;

  @UiThread
  public NewBeneficiaryAdapter$ViewHolder_ViewBinding(NewBeneficiaryAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mModeTV = Utils.findRequiredViewAsType(source, R.id.tv_mode, "field 'mModeTV'", ImageView.class);
    target.mNumberTV = Utils.findRequiredViewAsType(source, R.id.tv_number, "field 'mNumberTV'", TextView.class);
    target.mDeleteIV = Utils.findRequiredViewAsType(source, R.id.iv_delete, "field 'mDeleteIV'", ImageButton.class);
    target.layout = Utils.findRequiredViewAsType(source, R.id.rl_layout, "field 'layout'", RelativeLayout.class);
    target.mStatusTV = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mStatusTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewBeneficiaryAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mModeTV = null;
    target.mNumberTV = null;
    target.mDeleteIV = null;
    target.layout = null;
    target.mStatusTV = null;
  }
}
