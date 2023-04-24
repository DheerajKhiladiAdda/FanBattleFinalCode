package com.khiladiadda.in.splash;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.dialogs.AppDialog;
import com.khiladiadda.in.dialogs.interfaces.IOnNetworkErrorListener;
import com.khiladiadda.in.login.LoginActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.VersionResponse;
import com.khiladiadda.in.registration.RegistrationActivity;
import com.khiladiadda.in.splash.interfaces.ISplashPresenter;
import com.khiladiadda.in.splash.interfaces.ISplashView;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
public class SplashActivity extends BaseActivity implements ISplashView {
    @BindView(R.id.tv_instant_withdrawal)
    TextView mPlayTV;
    private ISplashPresenter mPresenter;
    Handler handler=new Handler();
    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }
    @Override
    protected void initViews() {
    }
    @Override
    protected void initVariables() {
        Typeface type = ResourcesCompat.getFont(this, R.font.montserrat);
        mPlayTV.setTypeface(type);
        Window window=this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        mPresenter = new SplashPresenter(this);
    }

    @Override
    public void onClick(View v) {
    }

    public void onBackPressed() {
        removeCallbacks();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    private void removeCallbacks() {
        if (handler != null && runnable != null){
            handler.removeCallbacks(runnable);
        }
    }

    Runnable runnable = this::openNextScreen;

    private void openNextScreen() {
        if (mAppPreference.getIsLogin()) {
            if (mAppPreference.getIsDeepLinking()) {
                finish();
            } else {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        } else {
            startActivity(new Intent(this,RegistrationActivity.class));
            finish();
        }
    }

    private boolean isMasterDataRequired() {
        long dateSaveMaster=mAppPreference.getDateSaveMaster();
        if (dateSaveMaster==0){
            return true;
        }
        return TimeUnit.DAYS.convert(Calendar.getInstance().getTimeInMillis() - dateSaveMaster, TimeUnit.MILLISECONDS) >= 1;
    }

    @Override
    public void onMasterComplete(MasterResponse responseModel) {
        if (responseModel.isStatus()) {
            AppUtilityMethods.saveMasterData(responseModel);
        }
    }

    @Override
    public void onMasterFailure(ApiError error) {
    }

    @Override
    public void onVersionSuccess(VersionResponse response) {
        if (response.isStatus()) {
            if (AppUtilityMethods.getVersion().equalsIgnoreCase(response.getVersion().getAppVersion())) {
                mAppPreference.setIsVersionUpdated(false);
            } else {
                /*TODO True*/
                mAppPreference.setIsVersionUpdated(false);
            }
            mAppPreference.setWithdrawComission(response.getVersion());
            mAppPreference.setVersion(response);
            mAppPreference.setString(AppConstant.VERSION_SIZE, String.valueOf(response.getVersion().getApkSize()));
            mAppPreference.setString(AppConstant.VERSION_DESC, response.getVersion().getUpdateDescription());
            mAppPreference.setString(AppConstant.VERSION_LINK, response.getVersion().getApkLink());
            mAppPreference.setString(AppConstant.VERSION, response.getVersion().getAppVersion());
            mAppPreference.setBoolean(AppConstant.IS_FB_ENABLED, response.getVersion().isFB());
            mAppPreference.setBoolean(AppConstant.IS_GMAIL_ENABLED, response.getVersion().isGmail());
            mAppPreference.setSupportNumber(response.getVersion().getSupport_number());
        }
    }
    @Override
    public void onVersionFailure(ApiError error){
    }
    private IOnNetworkErrorListener onNetworkErrorListener=()->getData();
    private void getData(){
        if (new NetworkStatus(this).isInternetOn()){
            handler.postDelayed(runnable, 4000);
            if (mAppPreference.getIsLogin()&&isMasterDataRequired()){
                mAppPreference.setDateSaveMaster(Calendar.getInstance().getTimeInMillis());
                mPresenter.getMasterData();
            }else{
                mPresenter.getVersionDetails();
            }
        }else{
            AppDialog.showNetworkErrorDialog(this,onNetworkErrorListener);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        getData();
    }

}