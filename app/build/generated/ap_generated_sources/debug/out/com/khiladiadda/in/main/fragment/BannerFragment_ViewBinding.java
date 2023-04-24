// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.main.fragment;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BannerFragment_ViewBinding implements Unbinder {
  private BannerFragment target;

  @UiThread
  public BannerFragment_ViewBinding(BannerFragment target, View source) {
    this.target = target;

    target.mAdvertisementIV = Utils.findRequiredViewAsType(source, R.id.iv_advertisement, "field 'mAdvertisementIV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BannerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAdvertisementIV = null;
  }
}
