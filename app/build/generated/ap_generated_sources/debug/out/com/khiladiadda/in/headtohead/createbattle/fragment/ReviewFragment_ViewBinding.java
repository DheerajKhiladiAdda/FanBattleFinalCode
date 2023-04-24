// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReviewFragment_ViewBinding implements Unbinder {
  private ReviewFragment target;

  @UiThread
  public ReviewFragment_ViewBinding(ReviewFragment target, View source) {
    this.target = target;

    target.mReviewRV = Utils.findRequiredViewAsType(source, R.id.rv_review, "field 'mReviewRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReviewFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mReviewRV = null;
  }
}
