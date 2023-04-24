// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.utility;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavouriteActivity_ViewBinding implements Unbinder {
  private FavouriteActivity target;

  @UiThread
  public FavouriteActivity_ViewBinding(FavouriteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FavouriteActivity_ViewBinding(FavouriteActivity target, View source) {
    this.target = target;

    target.mFreeFireIV = Utils.findRequiredViewAsType(source, R.id.iv_freefire, "field 'mFreeFireIV'", ImageView.class);
    target.mBgmiIV = Utils.findRequiredViewAsType(source, R.id.iv_bgmi, "field 'mBgmiIV'", ImageView.class);
    target.mTdmIV = Utils.findRequiredViewAsType(source, R.id.iv_tdm, "field 'mTdmIV'", ImageView.class);
    target.mHthIV = Utils.findRequiredViewAsType(source, R.id.iv_hth, "field 'mHthIV'", ImageView.class);
    target.mLudoIV = Utils.findRequiredViewAsType(source, R.id.iv_ludo, "field 'mLudoIV'", ImageView.class);
    target.mFBIV = Utils.findRequiredViewAsType(source, R.id.iv_fanbattle, "field 'mFBIV'", ImageView.class);
    target.mQuizIV = Utils.findRequiredViewAsType(source, R.id.iv_quiz, "field 'mQuizIV'", ImageView.class);
    target.mFFCSIV = Utils.findRequiredViewAsType(source, R.id.iv_clsq, "field 'mFFCSIV'", ImageView.class);
    target.mFFMaxIV = Utils.findRequiredViewAsType(source, R.id.iv_ff_max, "field 'mFFMaxIV'", ImageView.class);
    target.mLudoAddaIV = Utils.findRequiredViewAsType(source, R.id.iv_ludoadda, "field 'mLudoAddaIV'", ImageView.class);
    target.mPGIV = Utils.findRequiredViewAsType(source, R.id.iv_pubg_gobal, "field 'mPGIV'", ImageView.class);
    target.mEPIV = Utils.findRequiredViewAsType(source, R.id.iv_premium_esports, "field 'mEPIV'", ImageView.class);
    target.mCloseIV = Utils.findRequiredViewAsType(source, R.id.iv_close, "field 'mCloseIV'", ImageView.class);
    target.mConfirmBTN = Utils.findRequiredViewAsType(source, R.id.btn_confirm, "field 'mConfirmBTN'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavouriteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFreeFireIV = null;
    target.mBgmiIV = null;
    target.mTdmIV = null;
    target.mHthIV = null;
    target.mLudoIV = null;
    target.mFBIV = null;
    target.mQuizIV = null;
    target.mFFCSIV = null;
    target.mFFMaxIV = null;
    target.mLudoAddaIV = null;
    target.mPGIV = null;
    target.mEPIV = null;
    target.mCloseIV = null;
    target.mConfirmBTN = null;
  }
}
