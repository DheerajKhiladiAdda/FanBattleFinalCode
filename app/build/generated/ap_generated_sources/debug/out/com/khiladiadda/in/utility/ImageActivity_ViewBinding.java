// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.utility;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImageActivity_ViewBinding implements Unbinder {
  private ImageActivity target;

  @UiThread
  public ImageActivity_ViewBinding(ImageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImageActivity_ViewBinding(ImageActivity target, View source) {
    this.target = target;

    target.mImageIV = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'mImageIV'", TouchImageView.class);
    target.mExitIB = Utils.findRequiredViewAsType(source, R.id.ib_exit, "field 'mExitIB'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ImageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImageIV = null;
    target.mExitIB = null;
  }
}
