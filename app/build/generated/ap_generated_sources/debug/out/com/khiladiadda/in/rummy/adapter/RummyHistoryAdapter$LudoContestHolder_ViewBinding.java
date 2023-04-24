// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.rummy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.card.MaterialCardView;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RummyHistoryAdapter$LudoContestHolder_ViewBinding implements Unbinder {
  private RummyHistoryAdapter.LudoContestHolder target;

  @UiThread
  public RummyHistoryAdapter$LudoContestHolder_ViewBinding(
      RummyHistoryAdapter.LudoContestHolder target, View source) {
    this.target = target;

    target.mHistoryMcv = Utils.findRequiredViewAsType(source, R.id.mcv_history, "field 'mHistoryMcv'", MaterialCardView.class);
    target.mWiningAmountTv = Utils.findRequiredViewAsType(source, R.id.tv_wining_amount, "field 'mWiningAmountTv'", TextView.class);
    target.mDetailsCl = Utils.findRequiredViewAsType(source, R.id.cl_details, "field 'mDetailsCl'", ConstraintLayout.class);
    target.mDateTv = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mDateTv'", TextView.class);
    target.mTransactionId = Utils.findRequiredViewAsType(source, R.id.tv_transaction_id, "field 'mTransactionId'", TextView.class);
    target.mWinningPriceTv = Utils.findRequiredViewAsType(source, R.id.tv_winningprice, "field 'mWinningPriceTv'", TextView.class);
    target.mPriceTv = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'mPriceTv'", TextView.class);
    target.mArrowIv = Utils.findRequiredViewAsType(source, R.id.iv_arrow, "field 'mArrowIv'", ImageView.class);
    target.mRummyCode = Utils.findRequiredViewAsType(source, R.id.tv_rummy_code, "field 'mRummyCode'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RummyHistoryAdapter.LudoContestHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHistoryMcv = null;
    target.mWiningAmountTv = null;
    target.mDetailsCl = null;
    target.mDateTv = null;
    target.mTransactionId = null;
    target.mWinningPriceTv = null;
    target.mPriceTv = null;
    target.mArrowIv = null;
    target.mRummyCode = null;
  }
}
