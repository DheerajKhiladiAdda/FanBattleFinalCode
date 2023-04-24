// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.scratchcard.adapter;

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

public class ScratchCardAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ScratchCardAdapter.ViewHolder target;

  @UiThread
  public ScratchCardAdapter$ViewHolder_ViewBinding(ScratchCardAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mUnScratchIV = Utils.findRequiredViewAsType(source, R.id.iv_unscratch, "field 'mUnScratchIV'", ImageView.class);
    target.mScratchedIV = Utils.findRequiredViewAsType(source, R.id.iv_scracthed, "field 'mScratchedIV'", ImageView.class);
    target.mAmountTV = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'mAmountTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScratchCardAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUnScratchIV = null;
    target.mScratchedIV = null;
    target.mAmountTV = null;
  }
}
