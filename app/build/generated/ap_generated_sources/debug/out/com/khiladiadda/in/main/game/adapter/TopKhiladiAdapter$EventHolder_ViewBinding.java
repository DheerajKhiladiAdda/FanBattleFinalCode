// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.main.game.adapter;

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

public class TopKhiladiAdapter$EventHolder_ViewBinding implements Unbinder {
  private TopKhiladiAdapter.EventHolder target;

  @UiThread
  public TopKhiladiAdapter$EventHolder_ViewBinding(TopKhiladiAdapter.EventHolder target,
      View source) {
    this.target = target;

    target.mImageIV = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'mImageIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mPrizeTV = Utils.findRequiredViewAsType(source, R.id.tv_total_won, "field 'mPrizeTV'", TextView.class);
    target.mModeTV = Utils.findRequiredViewAsType(source, R.id.tv_mode, "field 'mModeTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TopKhiladiAdapter.EventHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImageIV = null;
    target.mNameTV = null;
    target.mPrizeTV = null;
    target.mModeTV = null;
  }
}
