package com.khiladiadda.in.wallet;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.ApexPayChecksumResponse;
import com.khiladiadda.in.network.model.response.CashfreeChecksumResponse;
import com.khiladiadda.in.network.model.response.ChecksumResponse;
import com.khiladiadda.in.network.model.response.Coins;
import com.khiladiadda.in.network.model.response.InvoiceResponse;
import com.khiladiadda.in.network.model.response.PaySharpResponse;
import com.khiladiadda.in.network.model.response.PaykunOrderResponse;
import com.khiladiadda.in.network.model.response.PayuChecksumResponse;
import com.khiladiadda.in.network.model.response.ProfileTransactionResponse;
import com.khiladiadda.in.network.model.response.RazorpayOrderIdResponse;
import com.khiladiadda.in.network.model.response.TransactionDetails;
import com.khiladiadda.in.network.model.response.VersionResponse;
import com.khiladiadda.in.network.model.response.ZaakpayChecksumResponse;
import com.khiladiadda.in.transaction.PaymentHistoryActivity;
import com.khiladiadda.in.transaction.TransactionActivity;
import com.khiladiadda.in.transaction.adapter.TransactionAdapter;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.wallet.interfaces.IWalletPresenter;
import com.khiladiadda.in.wallet.interfaces.IWalletView;
import com.khiladiadda.in.withdrawcoins.NewWithdrawActivity;
import com.khiladiadda.in.withdrawcoins.WithdrawActivity;

import java.util.ArrayList;

import butterknife.BindView;
public class WalletActivity extends BaseActivity implements IWalletView, TransactionAdapter.IOnItemChildClickListener {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.btn_add_coins)
    Button mAddCoinsBTN;
    @BindView(R.id.btn_withdraw)
    Button mWithdrawBTN;
    @BindView(R.id.tv_coins)
    TextView mTotalCoinsTV;
    @BindView(R.id.tv_deposit)
    TextView mDepositTV;
    @BindView(R.id.tv_winning)
    TextView mWinningTV;
    @BindView(R.id.tv_bonus)
    TextView mBonusTV;
    @BindView(R.id.rv_transaction)
    RecyclerView mTransactionRV;
    @BindView(R.id.tv_recent_transaction)
    TextView mTransactionTV;
    @BindView(R.id.tv_payment_history)
    TextView mPaymentHistoryTV;
    private boolean mWithdraw, mPaytm;
    private IWalletPresenter mPresenter;
    private TransactionAdapter mAdapter;
    private ArrayList<TransactionDetails> mList;
    private double mDepositCoins;

    @Override
    protected int getContentView() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void initViews() {
        mActivityNameTV.setText(R.string.my_wallet);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mAddCoinsBTN.setOnClickListener(this);
        mWithdrawBTN.setOnClickListener(this);
        mTransactionTV.setOnClickListener(this);
        mPaymentHistoryTV.setOnClickListener(this);
        mPaymentHistoryTV.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initVariables() {
        mPresenter = new WalletPresenter(this);
        mList = new ArrayList<>();
        mAdapter = new TransactionAdapter(mList);
        mTransactionRV.setLayoutManager(new LinearLayoutManager(this));
        mTransactionRV.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(this);
        getData();
    }

    private void getData() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getProfile();
        } else {
            setData();
            Snackbar.make(mWithdrawBTN, getString(R.string.snackbar_internet_off), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.iv_back:
                if (mAppPreference.getIsDeepLinking()) {
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    finish();
                }
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.btn_add_coins:
                i = new Intent(this, AddWalletActivity.class);
                walletActivityResultLauncher.launch(i);
                break;
            case R.id.btn_withdraw:
                if (mWithdraw) {
                    i = new Intent(this, NewWithdrawActivity.class);
                    mAppPreference.setBoolean(AppConstant.IS_PAYTMWALLET_ENABLED, mPaytm);
                } else {
                    i = new Intent(this, WithdrawActivity.class);
                }
                walletActivityResultLauncher.launch(i);
                break;
            case R.id.tv_payment_history:
                i = new Intent(this, PaymentHistoryActivity.class);
                startActivity(i);
                break;
            case R.id.tv_recent_transaction:
                i = new Intent(this, TransactionActivity.class);
                i.putExtra(AppConstant.FROM, AppConstant.FROM_WALLET);
                startActivity(i);
                break;
        }
    }

    private void setData() {
        Coins coins = mAppPreference.getProfileData().getCoins();
        mDepositCoins = coins.getDeposit();
        if (!TextUtils.isEmpty(mAppPreference.getMobile()) && !mAppPreference.getMobile().startsWith("8888888888")) {
            mAppPreference.setMobile(String.valueOf(mAppPreference.getMobile()));
        }
        if (String.valueOf(mDepositCoins).contains(".")) {
            mDepositTV.setText(getString(R.string.text_deposited_next) + String.format("%.2f", mDepositCoins));
        } else {
            mDepositTV.setText(getString(R.string.text_deposited_next) + String.valueOf(mDepositCoins));
        }
        if (String.valueOf(coins.getWinning()).contains(".")) {
            mWinningTV.setText(getString(R.string.text_wining_next) + String.format("%.2f", coins.getWinning()));
        } else {
            mWinningTV.setText(getString(R.string.text_wining_next) + String.valueOf(coins.getWinning()));
        }
        if (String.valueOf(coins.getBonus()).contains(".")) {
            mBonusTV.setText(getString(R.string.text_bonus_next) + String.format("%.2f", coins.getBonus()));
        } else {
            mBonusTV.setText(getString(R.string.text_bonus_next) + String.valueOf(coins.getBonus()));
        }

        double total = mDepositCoins + coins.getBonus() + coins.getWinning();
        if (String.valueOf(total).contains(".")) {
            mTotalCoinsTV.setText("Total Balance\n" + "₹" + String.format("%.2f", total));
        } else {
            mTotalCoinsTV.setText("Total Balance\n" + "₹" + String.valueOf(total));
        }

        SpannableString deposit = new SpannableString(mDepositTV.getText().toString());
        deposit.setSpan(new RelativeSizeSpan(1.2f), 9, deposit.length(), 0); // set size
        mDepositTV.setText(deposit);
        SpannableString winning = new SpannableString(mWinningTV.getText().toString());
        winning.setSpan(new RelativeSizeSpan(1.2f), 7, winning.length(), 0); // set size
        mWinningTV.setText(winning);
        SpannableString bonus = new SpannableString(mBonusTV.getText().toString());
        bonus.setSpan(new RelativeSizeSpan(1.2f), 5, bonus.length(), 0); // set size
        mBonusTV.setText(bonus);
        SpannableString totalCoin = new SpannableString(mTotalCoinsTV.getText().toString());
        totalCoin.setSpan(new RelativeSizeSpan(1.5f), 13, totalCoin.length(), 0); // set size
        mTotalCoinsTV.setText(totalCoin);
    }

    @Override
    public String getAmount() {
        return "";
    }

    @Override
    public void onValidationComplete() {
    }

    @Override
    public void onValidationFailure(String errorMsg) {
    }

    @Override
    public void onPaytmChecksumComplete(ChecksumResponse responseModel) {
    }

    @Override
    public void onPaytmChecksumFailure(ApiError error) {
    }

    @Override
    public void onPaytmPaymentComplete(BaseResponse responseModel) {
    }

    @Override
    public void onPaytmPaymentFailure(ApiError error) {
    }

    @Override
    public void onProfileComplete(ProfileTransactionResponse responseModel) {
        hideProgress();
        mAppPreference.setProfileData(responseModel.getResponse());
        if (responseModel.getTransactionDetails().size() > 0) {
            mList.clear();
            mList.addAll(responseModel.getTransactionDetails());
            mAdapter.notifyDataSetChanged();
        }
        mWithdraw = responseModel.getWallet();
        mPaytm = responseModel.getPaytmEnabled();
        setData();
    }

    @Override
    public void onProfileFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onCashfreeChecksumComplete(CashfreeChecksumResponse responseModel) {

    }

    @Override
    public void onCashfreeChecksumFailure(ApiError error) {

    }

    @Override
    public void onCashfreePaymentComplete(BaseResponse responseModel) {

    }

    @Override
    public void onCashfreePaymentFailure(ApiError error) {

    }

    @Override
    public void onPayuChecksumComplete(PayuChecksumResponse responseModel) {

    }

    @Override
    public void onPayuChecksumFailure(ApiError error) {

    }

    @Override
    public void onPayuPaymentComplete(BaseResponse responseModel) {

    }

    @Override
    public void onPayuPaymentFailure(ApiError error) {

    }

    @Override
    public void onVersionSuccess(VersionResponse response) {
    }

    @Override
    public void onVersionFailure(ApiError error) {
    }

    @Override
    public void onRazorpayOrderIdComplete(RazorpayOrderIdResponse responseModel) {

    }

    @Override
    public void onRazorpayOrderIdFailure(ApiError error) {

    }

    @Override
    public void onRazorpayPaymentComplete(BaseResponse responseModel) {

    }

    @Override
    public void onRazorpayPaymentFailure(ApiError error) {

    }

    @Override
    public void onPaykunOrderIdComplete(PaykunOrderResponse responseModel) {

    }

    @Override
    public void onPaykunOrderIdFailure(ApiError error) {

    }

    @Override
    public void onPaykunPaymentComplete(BaseResponse responseModel) {

    }

    @Override
    public void onPaykunPaymentFailure(ApiError error) {

    }

    @Override
    public void onInvoiceComplete(InvoiceResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()){
            try {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(responseModel.getResponse().getFileUrl()), "application/pdf");
                Intent chooser = Intent.createChooser(browserIntent, getString(R.string.chooser_title));
                chooser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // optional
                startActivity(chooser);
            } catch (ActivityNotFoundException e) {
                AppUtilityMethods.showMsg(this, "Please download an app to open", false);
            }
        }
    }
    @Override
    public void onInvoiceFailure(ApiError error){
        hideProgress();
    }
    @Override
    public void onApplyCouponComplete(BaseResponse responseModel) {

    }
    @Override
    public void onApplyCouponFailure(ApiError error) {

    }
    @Override
    public void onPayUHashComplete(PayuChecksumResponse responseModel) {

    }
    @Override
    public void onPayUHashFailure(ApiError error) {

    }
    @Override
    public void onZaakpayChecksumComplete(ZaakpayChecksumResponse responseModel) {

    }
    @Override
    public void onZaakpayChecksumFailure(ApiError error) {

    }
    @Override
    public void onApexPayChecksumComplete(ApexPayChecksumResponse responseModel) {

    }

    @Override
    public void onApexPayChecksumFailure(ApiError error) {

    }

    @Override
    public void onApexPayComplete(ApexPayChecksumResponse responseModel) {

    }

    @Override
    public void onApexPayFailure(ApiError error) {

    }

    @Override
    public void onPaySharpComplete(PaySharpResponse responseModel) {

    }

    @Override
    public void onPaySharpFailure(ApiError error) {

    }

    @Override
    public void onPaySharpStatusComplete(BaseResponse responseModel) {

    }

    @Override
    public void onPaySharpStatusFailure(ApiError error) {

    }

    @Override
    public void onEaseBuzzChecksumComplete(ChecksumResponse responseModel) {

    }

    @Override
    public void onEaseBuzzChecksumFailure(ApiError error) {

    }

    @Override
    public void onEaseBuzzPaymentComplete(BaseResponse responseModel) {

    }

    @Override
    public void onEaseBuzzPaymentFailure(ApiError error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void onInvoiceClicked(int position) {
        showProgress(getString(R.string.txt_progress_authentication));
        mPresenter.getInvoice(mList.get(position).getId());
    }

    @Override
    public void onBackPressed() {
        if (mAppPreference.getIsDeepLinking()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            finish();
        }
    }

    ActivityResultLauncher<Intent> walletActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                getData();
            });

}