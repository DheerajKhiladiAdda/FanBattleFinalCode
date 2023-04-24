// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy;

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

public class RummyHistoryActivity_ViewBinding implements Unbinder {
  private RummyHistoryActivity target;

  @UiThread
  public RummyHistoryActivity_ViewBinding(RummyHistoryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RummyHistoryActivity_ViewBinding(RummyHistoryActivity target, View source) {
    this.target = target;

    target.mHistoryIv = Utils.findRequiredViewAsType(source, R.id.tv_history, "field 'mHistoryIv'", TextView.class);
    target.mRummyHistoryRv = Utils.findRequiredViewAsType(source, R.id.rv_rummy_history, "field 'mRummyHistoryRv'", RecyclerView.class);
    target.mBackIv = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIv'", ImageView.class);
    target.mErrorTv = Utils.findRequiredViewAsType(source, R.id.tv_error, "field 'mErrorTv'", TextView.class);
    target.mActivityName = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyHistoryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHistoryIv = null;
    target.mRummyHistoryRv = null;
    target.mBackIv = null;
    target.mErrorTv = null;
    target.mActivityName = null;
  }
}
