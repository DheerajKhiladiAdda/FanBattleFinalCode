package com.khiladiadda.in.withdrawcoins;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.dialogs.interfaces.IOnWithdrawOtpListener;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.interfaces.IOnItemClickListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.AddBeneficieryRazorpay;
import com.khiladiadda.in.network.model.response.AddBeneficiaryResponse;
import com.khiladiadda.in.network.model.response.BeneficiaryDetails;
import com.khiladiadda.in.network.model.response.BeneficiaryResponse;
import com.khiladiadda.in.network.model.response.BeneficiaryVerifyResponse;
import com.khiladiadda.in.network.model.response.ManualWithdrawResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;
import com.khiladiadda.in.network.model.response.PayoutResponse;
import com.khiladiadda.in.network.model.response.ProfileDetails;
import com.khiladiadda.in.network.model.response.WIthdrawLimitResponse;
import com.khiladiadda.in.network.model.response.WithdrawComissionDetails;
import com.khiladiadda.in.profile.update.AadharActivity;
import com.khiladiadda.in.transaction.TransactionActivity;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.withdrawcoins.adapter.BeneficiaryAdapter;
import com.khiladiadda.in.withdrawcoins.interfaces.IWithdrawPresenter;
import com.khiladiadda.in.withdrawcoins.interfaces.IWithdrawView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
public class WithdrawActivity extends BaseActivity implements IWithdrawView, IOnItemClickListener, BeneficiaryAdapter.IOnItemChildClickListener {
    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.tv_wining_cash)
    TextView mWinningCashTV;
    @BindView(R.id.cv_paytm)
    CardView mPaytmCV;
    @BindView(R.id.cv_upi)
    CardView mUpiCV;
    @BindView(R.id.cv_withdraw_history)
    CardView mAmazonPayCV;
    @BindView(R.id.cv_banktransfer)
    CardView mBankTransferCV;
    @BindView(R.id.et_payment_address)
    TextView mPaymentAddressET;
    @BindView(R.id.tv_existing_withdraw_option)
    TextView mExistingWithdrawNumberTV;
    @BindView(R.id.ll_bank)
    LinearLayout mBankLL;
    @BindView(R.id.et_account_number)
    EditText mBankAccountNumberET;
    @BindView(R.id.et_ifsc_code)
    EditText mIFSCCodeET;
    @BindView(R.id.et_address)
    EditText mAddressET;
    @BindView(R.id.et_amount)
    EditText mAmountET;
    @BindView(R.id.tv_total_coins)
    TextView mTotalCoinsTV;
    @BindView(R.id.btn_add_beneficiary)
    Button mAddBeneficiaryBTN;
    @BindView(R.id.btn_submit)
    Button mSubmitBTN;
    @BindView(R.id.rv_withdraw)
    RecyclerView mWithdrawRV;
    @BindView(R.id.ll_link_details)
    LinearLayout mLinkDetailsLL;
    @BindView(R.id.ll_amount_details)
    LinearLayout mAmountDetailsLL;
    @BindView(R.id.et_upa_name)
    EditText mUpiNameET;
    @BindView(R.id.et_name)
    EditText mBankAccountNameET;

    private IWithdrawPresenter mPresenter;
    private BeneficiaryAdapter mAdapter;
    private ArrayList<BeneficiaryDetails> mList = null;
    private int mAmount;
    private String mPaymentMode = AppConstant.PATYM, mBeneficiaryId, mFundAccountId;
    private double mWinningCoins;
    private int mPayoutGateway;
    private int mPayoutSelect = 0;
    private List<WithdrawComissionDetails> mWithdrawCommission = null;

    @Override
    protected int getContentView() {
        return R.layout.activity_withdraw;
    }

    @Override
    protected void initViews() {
        mActivityNameTV.setText(R.string.my_withdraw_wallet);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mPaytmCV.setOnClickListener(this);
        mAmazonPayCV.setOnClickListener(this);
        mUpiCV.setOnClickListener(this);
        mBankTransferCV.setOnClickListener(this);
        mAddBeneficiaryBTN.setOnClickListener(this);
        mSubmitBTN.setOnClickListener(this);
        mExistingWithdrawNumberTV.setOnClickListener(this);

        mExistingWithdrawNumberTV.setText(String.format(getString(R.string.format_use), mAppPreference.getMobile()));
        SpannableString string = new SpannableString(mExistingWithdrawNumberTV.getText().toString());
        string.setSpan(new StyleSpan(Typeface.BOLD), 6, string.length(), 0);
        string.setSpan(new UnderlineSpan(), 6, string.length(), 0);
        mExistingWithdrawNumberTV.setText(string);
    }

    @Override
    protected void initVariables() {
        mPresenter = new WithdrawPresenter(this);
        mList = new ArrayList<>();
        mAdapter = new BeneficiaryAdapter(mList);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mWithdrawRV.setLayoutManager(manager);
        mWithdrawRV.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        setWalletBenefeciaryData();
        mAmountET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    mAmount = Integer.parseInt(mAmountET.getText().toString().trim());
                    mTotalCoinsTV.setText(getString(R.string.text_total_coins_space) + mAmount);
                } else {
                    mTotalCoinsTV.setText(getString(R.string.text_zero));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_existing_withdraw_option:
                mPaymentAddressET.setText(mAppPreference.getMobile());
                break;
            case R.id.cv_paytm:
                mPayoutSelect = 1;
                setData(AppConstant.PATYM);
                break;
            case R.id.cv_upi:
                mPayoutSelect = 2;
                setData(AppConstant.UPI);
                break;
            case R.id.cv_withdraw_history:
                setData(AppConstant.FROM_WITHDRAW);
                break;
            case R.id.cv_banktransfer:
                mPayoutSelect = 4;
                setData(AppConstant.BANK_TRANSFER);
                break;
            case R.id.btn_add_beneficiary:
                if (TextUtils.isEmpty(mPaymentAddressET.getText().toString().trim()) && mPaymentMode.equalsIgnoreCase(AppConstant.PATYM)) {
                    AppUtilityMethods.showMsg(this, getString(R.string.text_paytm_mobilenumber_required), false);
                } else if (TextUtils.isEmpty(mPaymentAddressET.getText().toString().trim()) && (mPaymentMode.equalsIgnoreCase(AppConstant.UPI) || mPaymentMode.equalsIgnoreCase(AppConstant.VPA))) {
                    AppUtilityMethods.showMsg(this, getString(R.string.text_upi_address_required), false);
                } else if (TextUtils.isEmpty(mPaymentAddressET.getText().toString().trim()) && mPaymentMode.equalsIgnoreCase(AppConstant.AMAZON_PAY)) {
                    AppUtilityMethods.showMsg(this, getString(R.string.text_amazon_pay_number_required), false);
                } else if ((mPaymentMode.equalsIgnoreCase(AppConstant.BANK_TRANSFER) || mPaymentMode.equalsIgnoreCase(AppConstant.BANK_ACCOUNT)) && (TextUtils.isEmpty(mBankAccountNumberET.getText().toString().trim()) || TextUtils.isEmpty(mIFSCCodeET.getText().toString().trim()) || TextUtils.isEmpty(mAddressET.getText().toString().trim()))) {
                    AppUtilityMethods.showMsg(this, getString(R.string.text_bank_address), false);
                } else if (mPaymentMode.equalsIgnoreCase(AppConstant.BANK_TRANSFER) && mBankAccountNumberET.getText().toString().length() < 9) {
                    AppUtilityMethods.showMsg(this, getString(R.string.text_bank_incorrect), false);
                } else {
                    showProgress(getString(R.string.txt_progress_authentication));
                    if (mPayoutGateway == 1) {   //cashfree
                        mPresenter.onCashfreeAddBeneficiary(mBankAccountNumberET.getText().toString().trim(), mIFSCCodeET.getText().toString().trim().toUpperCase(), mAddressET.getText().toString().trim(), mPaymentMode, mPaymentAddressET.getText().toString().trim(), mUpiNameET.getText().toString().trim(), mPayoutSelect);
                    } else {  //razorpay
                        AddBeneficieryRazorpay addBeneficieryRazorpay = new AddBeneficieryRazorpay();
                        addBeneficieryRazorpay.setAccountNumber(mBankAccountNumberET.getText().toString().trim());
                        addBeneficieryRazorpay.setAccountType(mPaymentMode);
                        addBeneficieryRazorpay.setAddress(mPaymentAddressET.getText().toString().trim());
                        addBeneficieryRazorpay.setIfsc(mIFSCCodeET.getText().toString().trim().toUpperCase());
                        addBeneficieryRazorpay.setName(mAppPreference.getName());
                        addBeneficieryRazorpay.setTransferType(mPayoutSelect);
                        mPresenter.onRazorpayAddBeneficiary(addBeneficieryRazorpay);
                    }
                }
                break;
            case R.id.btn_submit:
                mPresenter.validateData();
                break;
        }
    }

    private void setData(String from) {
        mLinkDetailsLL.setVisibility(View.VISIBLE);
        setPaymentSelected();
        mPaymentAddressET.setVisibility(View.VISIBLE);
        mExistingWithdrawNumberTV.setVisibility(View.GONE);
        mBankLL.setVisibility(View.GONE);
        mPaymentAddressET.setText("");
        if (mPayoutGateway == 1) {
            mPaymentMode = from;
        } else if (mPayoutGateway == 2 && from.equalsIgnoreCase(AppConstant.UPI)) {
            mPaymentMode = AppConstant.VPA;
        } else if (mPayoutGateway == 2 && from.equalsIgnoreCase(AppConstant.BANK_TRANSFER)) {
            mPaymentMode = AppConstant.BANK_ACCOUNT;
        } else if (mPayoutGateway == 2) {
            mPaymentMode = AppConstant.PATYM;
        }
        if (mList.size() > 0) {
            int selectedPos = RecyclerView.NO_POSITION;
            mAdapter.setSelectedPos(selectedPos);
            mAdapter.notifyDataSetChanged();
            mAmountET.setText("");
            mAmountDetailsLL.setVisibility(View.GONE);
        }
        switch (from) {
            case AppConstant.PATYM:
                mPaytmCV.setCardBackgroundColor(getResources().getColor(R.color.button_green));
                mExistingWithdrawNumberTV.setVisibility(View.VISIBLE);
                mPaymentAddressET.setHint(getString(R.string.text_paytm_number));
                mUpiNameET.setVisibility(View.GONE);
                break;
            case AppConstant.UPI:
                mUpiCV.setCardBackgroundColor(getResources().getColor(R.color.button_green));
                mUpiNameET.setVisibility(View.VISIBLE);
                mPaymentAddressET.setHint(getString(R.string.text_upi_address));
                break;
            case AppConstant.BANK_TRANSFER:
                mBankTransferCV.setCardBackgroundColor(getResources().getColor(R.color.button_green));
                mPaymentAddressET.setVisibility(View.GONE);
                mUpiNameET.setVisibility(View.GONE);
                mBankLL.setVisibility(View.VISIBLE);
                break;
            case AppConstant.FROM_WITHDRAW:
                mLinkDetailsLL.setVisibility(View.GONE);
                mAmazonPayCV.setCardBackgroundColor(getResources().getColor(R.color.button_green));
                Intent i = new Intent(this, TransactionActivity.class);
                i.putExtra(AppConstant.FROM, AppConstant.FROM_WITHDRAW);
                startActivity(i);
                break;
        }
    }

    private void setPaymentSelected() {
        mPaytmCV.setCardBackgroundColor(getResources().getColor(R.color.colorTransparent));
        mBankTransferCV.setCardBackgroundColor(getResources().getColor(R.color.colorTransparent));
        mUpiCV.setCardBackgroundColor(getResources().getColor(R.color.colorTransparent));
        mAmazonPayCV.setCardBackgroundColor(getResources().getColor(R.color.colorTransparent));
    }

    @Override
    public String getAmount() {
        return mAmountET.getText().toString().trim();
    }

    @Override
    public void onValidationComplete() {
        if (mAmount < 20) {
            AppUtilityMethods.showMsg(this, getString(R.string.text_amount_less_ten), false);
        } else if ((mAmount) <= mWinningCoins) {
            if (mAppPreference.getProfileData().getAadharUpdated() == 3) {
                showConfirmWithdrawDialog();
            } else {
                checkWithdrawLimit();
            }
        } else {
            AppUtilityMethods.showMsg(this, getString(R.string.text_not_enough_coins_wallet), false);
        }
    }

    @Override
    public void onValidationFailure(String errorMsg) {
        AppUtilityMethods.showMsg(this, errorMsg, false);
    }

    private void checkWithdrawLimit() {
        showProgress(getString(R.string.txt_progress_authentication));
        mPresenter.getWithdrawLimit();
    }

    @Override
    public void onGetBeneficiaryListComplete(BeneficiaryResponse responseModel) {  //cashfree = 1, razorpay = 2
        mList.clear();
        mPayoutGateway = responseModel.getPayoutEnable();
        mWithdrawCommission = responseModel.getWithdrawCommission();
        if (responseModel.isManualWithdraw()) {
            showWithdrawConfirmation(getString(R.string.text_manual_withdraw), responseModel.getMessage(), false, responseModel.isManualWithdraw());
        } else {
            if (responseModel.isStatus()) {
                if (responseModel.getResponse().size() > 0) {
                    mList.addAll(responseModel.getResponse());
                    mWithdrawRV.setVisibility(View.VISIBLE);
                } else {
                    Snackbar.make(mSubmitBTN, getString(R.string.text_link_details_to_withdraw), Snackbar.LENGTH_LONG).show();
                }
            }
        }
        mAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onGetBeneficiaryListFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onAddCashfreeBeneficiaryComplete(AddBeneficiaryResponse response) {
        showAddBeneficiaryStatus(response);
    }

    private void showAddBeneficiaryStatus(AddBeneficiaryResponse response) {
        hideProgress();
        mLinkDetailsLL.setVisibility(View.GONE);
        if (response.isStatus()) {
            showMsg(this, getString(R.string.text_benefeciary_added), false, 1);
        } else if (response.isManual_withdraw()) {
            showWithdrawConfirmation(getString(R.string.text_msg_manual_wiithdraw), response.getMessage(), false, true);
        } else {
            showMsg(this, response.getMessage(), false, 1);
        }
    }

    @Override
    public void onAddCashfreeBeneficiaryFailed(ApiError error) {
        hideProgress();
        Snackbar.make(mSubmitBTN, getString(R.string.text_valid_withdraw_details), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCashfreeTransferComplete(PayoutResponse response) {
        onAllTransferDone(response);
    }

    private void onAllTransferDone(PayoutResponse response) {
        hideProgress();
        if (response.isStatus()) {
            showWithdrawConfirmation(getString(R.string.text_transfer_success), response.getMessage(), true, false);
        } else {
            if (response.isManual_withdraw()) {
                showWithdrawConfirmation("", response.getMessage(), false, true);
            } else {
                showWithdrawConfirmation(getString(R.string.text_wiithdraw_failed), response.getMessage(), false, false);
            }
        }
    }

    @Override
    public void onCashfreeTransferFailed(ApiError error) {
        hideProgress();
    }

    @Override
    public void onDeleteComplete(BaseResponse response) {
        hideProgress();
        if (response.isStatus()) {
            showMsg(this, getString(R.string.text_withdraw_details_deleted), false, 1);
        } else {
            Snackbar.make(mSubmitBTN, response.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDeleteFailed(ApiError error) {
        hideProgress();
    }

    @Override
    public void onManualWithdrawComplete(BaseResponse responseModel) {

    }

    @Override
    public void onManualWithdrawFailure(ApiError error) {

    }

    @Override
    public void onGetManualWithdrawComplete(ManualWithdrawResponse responseModel) {

    }

    @Override
    public void onGetManualWithdrawFailure(ApiError error) {

    }

    @Override
    public void onResendOtpComplete(OtpResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            Snackbar.make(mSubmitBTN, R.string.text_otp_send_successfully, Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(mSubmitBTN, responseModel.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResendOtpFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onSendOtpComplete(BaseResponse responseModel) {
        hideProgress();
        new WithdrawOTPDialog(this, onWithdrawOtpListener);
    }

    @Override
    public void onSendOtpFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onAddRazorpayBeneficiaryComplete(AddBeneficiaryResponse response) {
        showAddBeneficiaryStatus(response);
    }

    @Override
    public void onAddRazorpayBeneficiaryFailed(ApiError error) {
        hideProgress();
        Snackbar.make(mSubmitBTN, getString(R.string.text_valid_withdraw_details), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRazorpayTransferComplete(PayoutResponse response) {
        onAllTransferDone(response);
    }

    @Override
    public void onRazorpayTransferFailed(ApiError error) {
        hideProgress();
    }

    @Override
    public void onWithdrawLimitComplete(WIthdrawLimitResponse response) {
        hideProgress();
        if (response.isStatus()) {
            if (response.getResponse().isKycEnabled()) {
                if (!response.getResponse().isIsLimitExceeded() && ((response.getResponse().getTotalWithdrawal() + mAmount) < (response.getResponse().getLimitAmount() + 1))) {
                    showConfirmWithdrawDialog();
                } else {
                    if (mAppPreference.getProfileData().getAadharUpdated() == 3 || response.getResponse().isAadharVerified()) {
                        showConfirmWithdrawDialog();
                    } else {
                        showMsg(this, response.getMessage(), false, 3);
                    }
                }
            } else {
                showConfirmWithdrawDialog();
            }
        } else {
            showConfirmWithdrawDialog();
        }
    }
    @Override
    public void onWithdrawLimitFailed(ApiError error) {
        hideProgress();
    }
    @Override
    public void onVerifyBeneficiaryComplete(BeneficiaryVerifyResponse responseModel) {

    }



    @Override
    public void onVerifyBeneficiaryFailure(ApiError error) {

    }

    @Override
    public void onApexPayTransferComplete(PayoutResponse response) {

    }

    @Override
    public void onApexPayTransferFailed(ApiError error) {

    }

    @Override
    public void onPaySharpTransferComplete(PayoutResponse response) {

    }

    @Override
    public void onPaySharpTransferFailed(ApiError error) {

    }

    @Override
    public void onAddBeneficiaryComplete(AddBeneficiaryResponse response) {

    }

    @Override
    public void onAddBeneficiaryFailed(ApiError error) {

    }

    public void showMsg(final Context activity, String msg, boolean isCancel, int from) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(isCancel);
        dialog.setContentView(R.layout.dialog_delete);
        TextView tv_msg = dialog.findViewById(R.id.tv_msg);
        tv_msg.setText(msg);
        Button okBTN = dialog.findViewById(R.id.btn_ok);
        Button mNoBTN = dialog.findViewById(R.id.btn_no);
        if (from == 3) {
            okBTN.setText(getString(R.string.verify));
            mNoBTN.setText(getString(R.string.cancel));
        }
        if (from == 1) {
            clearBeneficiaryData();
            okBTN.setText(getString(R.string.ok));
            mNoBTN.setVisibility(View.GONE);
        }
        okBTN.setOnClickListener(view -> {
            dialog.dismiss();
            if (from == 1) {
                getBeneficiaryList();
            } else if (from == 2) {
                showProgress(getString(R.string.txt_progress_authentication));
                mPresenter.deleteBeneficiary(mBeneficiaryId,0);
            } else if (from == 3) {
                Intent i = new Intent(this, AadharActivity.class);
                i.putExtra(AppConstant.FROM, AppConstant.FROM_AADHAR);
                startActivity(i);
            }
        });
        mNoBTN.setOnClickListener(view -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onItemClick(View view, int position, int tag) {
        if (position >= 0) {
            mLinkDetailsLL.setVisibility(View.GONE);
            setPaymentSelected();
            mPaymentMode = mList.get(position).getTransferMode().toLowerCase();
            if (mPayoutGateway == 1) {  //cashfree
                mBeneficiaryId = mList.get(position).getBeneId();
            } else {  //razorpay
                mFundAccountId = mList.get(position).getFundAccountId();
                if (!TextUtils.isEmpty(mList.get(position).getBeneId())) {
                    mBeneficiaryId = mList.get(position).getBeneId();
                }
                if (mPaymentMode.equalsIgnoreCase(AppConstant.VPA)) {
                    mPaymentMode = AppConstant.UPI;
                }
            }
            mAmountDetailsLL.setVisibility(View.VISIBLE);
            mAdapter.setSelectedPos(position);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDeleteClicked(int position) {
        if (position >= 0) {
            mBeneficiaryId = mList.get(position).getBeneId();
            mLinkDetailsLL.setVisibility(View.GONE);
            setPaymentSelected();
            mAmountET.setText("");
            mAmountDetailsLL.setVisibility(View.GONE);
            showMsg(this, getString(R.string.text_delete_withdraw_acoount), false, 2);
        }
    }

    public void showWithdrawConfirmation(String heading, String msg, boolean result, boolean manualWithdraw) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_payment_confirmation);
        final TextView mHeadingTV = dialog.findViewById(R.id.tv_heading);
        mHeadingTV.setText(heading);
        final TextView mMsgTV = dialog.findViewById(R.id.tv_msg);
        mMsgTV.setText(msg);
        final ImageView mIV = dialog.findViewById(R.id.iv_payment);
        Button mSendBTN = dialog.findViewById(R.id.btn_ok);
        if (manualWithdraw) {
            mIV.setVisibility(View.GONE);
            mSendBTN.setText(R.string.text_go_manual_withdraw);
        } else if (result) {
            mHeadingTV.setTextColor(ContextCompat.getColor(this, R.color.color_green));
            mIV.setBackground(AppCompatResources.getDrawable(this, R.drawable.payment_success));
        } else {
            mHeadingTV.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            mIV.setBackground(AppCompatResources.getDrawable(this, R.drawable.payment_failure));
        }
        mSendBTN.setOnClickListener(v -> {
            dialog.dismiss();
            if (manualWithdraw) {
                Intent i = new Intent(this, ManualWithdrawActivity.class);
                i.putExtra(AppConstant.FROM, AppConstant.FROM_WITHDRAW);
                startActivity(i);
            } else {
                Intent intent = new Intent();
                setResult(AppConstant.REQUEST_ADD_WALLET, intent);
                finish();
            }
        });
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void showConfirmWithdrawDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_withdraw_confirm);

        TextView walletCoins = dialog.findViewById(R.id.tv_wallet);
        walletCoins.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(mWinningCoins))));
        TextView withdrawCoins = dialog.findViewById(R.id.tv_withdraw);
        withdrawCoins.setText(String.valueOf(mAmount));
        TextView transactionFeeTV = dialog.findViewById(R.id.tv_transaction_fee);
        double transactionFees;
        long comission = 0;
        //list loop - from to
        //amount - from-to = comission
//        List<WithdrawComissionDetails> mWithdrawComissionDetailsList = mAppPreference.getWithdrawComission().getWithdrawCommission();
        for (int i = 0; i < mWithdrawCommission.size(); i++) {
            long from, to;
            from = mWithdrawCommission.get(i).getFrom();
            to = mWithdrawCommission.get(i).getTo();
            if (mAmount >= from && mAmount <= to) {
                comission = mWithdrawCommission.get(i).getCommission();
            }
        }
        transactionFees = comission;
        transactionFees = Double.parseDouble(new DecimalFormat("##.##").format(transactionFees));
        transactionFeeTV.setText(String.valueOf(transactionFees));
        double finalFee = mAmount - transactionFees;
        TextView finalPay = dialog.findViewById(R.id.tv_final_fee);
        finalPay.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(finalFee))));
        Button okBTN = dialog.findViewById(R.id.btn_send);
        okBTN.setOnClickListener(view -> {
            dialog.dismiss();
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.sendOtp(mAppPreference.getMobile());
        });
        Button mNoBTN = dialog.findViewById(R.id.btn_cancel);
        mNoBTN.setOnClickListener(view -> dialog.dismiss());
        dialog.show();
    }

    private void setWalletBenefeciaryData() {
        ProfileDetails profileData = mAppPreference.getProfileData();
        mWinningCoins = profileData.getCoins().getWinning();
        mAddressET.setText(profileData.getState());
        Resources res = getResources();
        if (String.valueOf(profileData.getCoins().getWinning()).contains(".")) {
            mWinningCashTV.setText(String.format(res.getString(R.string.text_wallet_winning_coins), String.format("%.2f", mWinningCoins)));
        } else {
            mWinningCashTV.setText(String.format(res.getString(R.string.text_wallet_winning_coins), String.valueOf(mWinningCoins)));
        }
        getBeneficiaryList();
    }

    private void getBeneficiaryList() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getBeneficiaryList();
        } else {
            Snackbar.make(mSubmitBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    private IOnWithdrawOtpListener onWithdrawOtpListener = new IOnWithdrawOtpListener() {
        @Override
        public void onVerifyOtpTransferListener(String otp) {
            showProgress(getString(R.string.txt_progress_authentication));
            if (mPayoutGateway == 1) {  //cashfree
                mPresenter.onCashfreeTransfer(mBeneficiaryId, mAmountET.getText().toString().trim(), otp);
            } else {  //razorpay - bank_account
                mPresenter.onRazorpayTransfer(mFundAccountId, mPaymentMode, mAmountET.getText().toString().trim(), otp, mBeneficiaryId);
            }
        }
        @Override
        public void onResendOtpListener() {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.resendOtp(mAppPreference.getMobile());
        }
    };

    private void clearBeneficiaryData() {
        mPaymentAddressET.setText("");
        mAddressET.setText("");
        mIFSCCodeET.setText("");
        mBankAccountNameET.setText("");
        mBankAccountNumberET.setText("");
        mUpiNameET.setText("");
    }

}