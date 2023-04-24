// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.wallet;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddWalletActivity_ViewBinding implements Unbinder {
  private AddWalletActivity target;

  @UiThread
  public AddWalletActivity_ViewBinding(AddWalletActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddWalletActivity_ViewBinding(AddWalletActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mAmountET = Utils.findRequiredViewAsType(source, R.id.et_amount, "field 'mAmountET'", EditText.class);
    target.mTotalCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_coins, "field 'mTotalCoinsTV'", TextView.class);
    target.mCouponCodeTV = Utils.findRequiredViewAsType(source, R.id.tv_coupon_code, "field 'mCouponCodeTV'", TextView.class);
    target.mCouponLL = Utils.findRequiredViewAsType(source, R.id.ll_coupon, "field 'mCouponLL'", LinearLayout.class);
    target.mCouponCodeET = Utils.findRequiredViewAsType(source, R.id.et_coupon_code, "field 'mCouponCodeET'", EditText.class);
    target.mConfirmCouponBTN = Utils.findRequiredViewAsType(source, R.id.btn_confirm_coupon, "field 'mConfirmCouponBTN'", TextView.class);
    target.mCouponAppliedTV = Utils.findRequiredViewAsType(source, R.id.tv_coupon_applied, "field 'mCouponAppliedTV'", TextView.class);
    target.mCouponDeleteTV = Utils.findRequiredViewAsType(source, R.id.tv_coupon_delete, "field 'mCouponDeleteTV'", TextView.class);
    target.mGPayIV = Utils.findRequiredViewAsType(source, R.id.iv_gpay, "field 'mGPayIV'", ImageView.class);
    target.mAPayIV = Utils.findRequiredViewAsType(source, R.id.iv_apay, "field 'mAPayIV'", ImageView.class);
    target.mPhonePayIV = Utils.findRequiredViewAsType(source, R.id.iv_phonepe, "field 'mPhonePayIV'", ImageView.class);
    target.mPaytmTV = Utils.findRequiredViewAsType(source, R.id.tv_paytm, "field 'mPaytmTV'", TextView.class);
    target.mCashfreeTV = Utils.findRequiredViewAsType(source, R.id.tv_cashfree, "field 'mCashfreeTV'", TextView.class);
    target.mPaysharpTV = Utils.findRequiredViewAsType(source, R.id.tv_paysharp, "field 'mPaysharpTV'", TextView.class);
    target.mApexPayTV = Utils.findRequiredViewAsType(source, R.id.tv_apexpay, "field 'mApexPayTV'", TextView.class);
    target.mEasebuzzTV = Utils.findRequiredViewAsType(source, R.id.tv_easebuzz, "field 'mEasebuzzTV'", TextView.class);
    target.mPayBTN = Utils.findRequiredViewAsType(source, R.id.btn_pay, "field 'mPayBTN'", Button.class);
    target.mPGTV = Utils.findRequiredViewAsType(source, R.id.tv_pg, "field 'mPGTV'", TextView.class);
    target.mUPITV = Utils.findRequiredViewAsType(source, R.id.tv_upi, "field 'mUPITV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddWalletActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mAmountET = null;
    target.mTotalCoinsTV = null;
    target.mCouponCodeTV = null;
    target.mCouponLL = null;
    target.mCouponCodeET = null;
    target.mConfirmCouponBTN = null;
    target.mCouponAppliedTV = null;
    target.mCouponDeleteTV = null;
    target.mGPayIV = null;
    target.mAPayIV = null;
    target.mPhonePayIV = null;
    target.mPaytmTV = null;
    target.mCashfreeTV = null;
    target.mPaysharpTV = null;
    target.mApexPayTV = null;
    target.mEasebuzzTV = null;
    target.mPayBTN = null;
    target.mPGTV = null;
    target.mUPITV = null;
  }
}
