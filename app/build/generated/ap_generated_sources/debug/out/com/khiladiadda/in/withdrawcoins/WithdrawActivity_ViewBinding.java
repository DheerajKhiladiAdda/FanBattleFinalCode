// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.withdrawcoins;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WithdrawActivity_ViewBinding implements Unbinder {
  private WithdrawActivity target;

  @UiThread
  public WithdrawActivity_ViewBinding(WithdrawActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WithdrawActivity_ViewBinding(WithdrawActivity target, View source) {
    this.target = target;

    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
    target.mActivityNameTV = Utils.findRequiredViewAsType(source, R.id.tv_activity_name, "field 'mActivityNameTV'", TextView.class);
    target.mNotificationIV = Utils.findRequiredViewAsType(source, R.id.iv_notification, "field 'mNotificationIV'", ImageView.class);
    target.mWinningCashTV = Utils.findRequiredViewAsType(source, R.id.tv_wining_cash, "field 'mWinningCashTV'", TextView.class);
    target.mPaytmCV = Utils.findRequiredViewAsType(source, R.id.cv_paytm, "field 'mPaytmCV'", CardView.class);
    target.mUpiCV = Utils.findRequiredViewAsType(source, R.id.cv_upi, "field 'mUpiCV'", CardView.class);
    target.mAmazonPayCV = Utils.findRequiredViewAsType(source, R.id.cv_withdraw_history, "field 'mAmazonPayCV'", CardView.class);
    target.mBankTransferCV = Utils.findRequiredViewAsType(source, R.id.cv_banktransfer, "field 'mBankTransferCV'", CardView.class);
    target.mPaymentAddressET = Utils.findRequiredViewAsType(source, R.id.et_payment_address, "field 'mPaymentAddressET'", TextView.class);
    target.mExistingWithdrawNumberTV = Utils.findRequiredViewAsType(source, R.id.tv_existing_withdraw_option, "field 'mExistingWithdrawNumberTV'", TextView.class);
    target.mBankLL = Utils.findRequiredViewAsType(source, R.id.ll_bank, "field 'mBankLL'", LinearLayout.class);
    target.mBankAccountNumberET = Utils.findRequiredViewAsType(source, R.id.et_account_number, "field 'mBankAccountNumberET'", EditText.class);
    target.mIFSCCodeET = Utils.findRequiredViewAsType(source, R.id.et_ifsc_code, "field 'mIFSCCodeET'", EditText.class);
    target.mAddressET = Utils.findRequiredViewAsType(source, R.id.et_address, "field 'mAddressET'", EditText.class);
    target.mAmountET = Utils.findRequiredViewAsType(source, R.id.et_amount, "field 'mAmountET'", EditText.class);
    target.mTotalCoinsTV = Utils.findRequiredViewAsType(source, R.id.tv_total_coins, "field 'mTotalCoinsTV'", TextView.class);
    target.mAddBeneficiaryBTN = Utils.findRequiredViewAsType(source, R.id.btn_add_beneficiary, "field 'mAddBeneficiaryBTN'", Button.class);
    target.mSubmitBTN = Utils.findRequiredViewAsType(source, R.id.btn_submit, "field 'mSubmitBTN'", Button.class);
    target.mWithdrawRV = Utils.findRequiredViewAsType(source, R.id.rv_withdraw, "field 'mWithdrawRV'", RecyclerView.class);
    target.mLinkDetailsLL = Utils.findRequiredViewAsType(source, R.id.ll_link_details, "field 'mLinkDetailsLL'", LinearLayout.class);
    target.mAmountDetailsLL = Utils.findRequiredViewAsType(source, R.id.ll_amount_details, "field 'mAmountDetailsLL'", LinearLayout.class);
    target.mUpiNameET = Utils.findRequiredViewAsType(source, R.id.et_upa_name, "field 'mUpiNameET'", EditText.class);
    target.mBankAccountNameET = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'mBankAccountNameET'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WithdrawActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackIV = null;
    target.mActivityNameTV = null;
    target.mNotificationIV = null;
    target.mWinningCashTV = null;
    target.mPaytmCV = null;
    target.mUpiCV = null;
    target.mAmazonPayCV = null;
    target.mBankTransferCV = null;
    target.mPaymentAddressET = null;
    target.mExistingWithdrawNumberTV = null;
    target.mBankLL = null;
    target.mBankAccountNumberET = null;
    target.mIFSCCodeET = null;
    target.mAddressET = null;
    target.mAmountET = null;
    target.mTotalCoinsTV = null;
    target.mAddBeneficiaryBTN = null;
    target.mSubmitBTN = null;
    target.mWithdrawRV = null;
    target.mLinkDetailsLL = null;
    target.mAmountDetailsLL = null;
    target.mUpiNameET = null;
    target.mBankAccountNameET = null;
  }
}
