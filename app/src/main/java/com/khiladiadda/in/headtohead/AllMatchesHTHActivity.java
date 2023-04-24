package com.khiladiadda.in.headtohead;
import static android.view.View.GONE;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.headtohead.adpater.HTHAdpter;
import com.khiladiadda.in.headtohead.interfaces.IHTHBattlePresenter;
import com.khiladiadda.in.headtohead.interfaces.IHTHBattleView;
import com.khiladiadda.in.help.HelpActivity;
import com.khiladiadda.in.interfaces.IOnItemClickListener;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.main.adapter.BannerPagerAdapter;
import com.khiladiadda.in.main.fragment.BannerFragment;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.BannerDetails;
import com.khiladiadda.in.network.model.response.HTHCancelResponse;
import com.khiladiadda.in.network.model.response.ProfileResponse;
import com.khiladiadda.in.network.model.response.ProfileTransactionResponse;
import com.khiladiadda.in.network.model.response.hth.HTHMainResponse;
import com.khiladiadda.in.network.model.response.hth.HTHResponseDetails;
import com.khiladiadda.in.network.model.response.hth.Result;
import com.khiladiadda.in.profile.ProfilePresenter;
import com.khiladiadda.in.profile.interfaces.IProfilePresenter;
import com.khiladiadda.in.profile.interfaces.IProfileView;
import com.khiladiadda.in.splash.interfaces.ISplashPresenter;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.wallet.WalletActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
public class AllMatchesHTHActivity extends BaseActivity implements IHTHBattleView, IOnItemClickListener, SwipeRefreshLayout.OnRefreshListener,IProfileView{
    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.tv_league)
    TextView mLeagueTV;
    @BindView(R.id.tv_home)
    TextView mHomeTV;
    @BindView(R.id.tv_help)
    TextView mHelpTV;
    @BindView(R.id.rv_match)
    RecyclerView mMatchRV;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefreshL;
    @BindView(R.id.vp_advertisement)
    ViewPager mBannerVP;
    @BindView(R.id.tv_title_name)
    TextView mTitleNameFbTV;
    @BindView(R.id.tv_total_wallet_balance)
    TextView mTotalWalletBLTV;
    @BindView(R.id.rl_wallet)
    LinearLayout mWalletRV;
    private List<BannerDetails> mAdvertisementsList=new ArrayList<>();
    private Handler mHandler;
    private IHTHBattlePresenter mPresenter;
    private HTHAdpter mMatchAdapter;
    private ArrayList<HTHResponseDetails> mMatchList=new ArrayList<>();
    private IProfilePresenter mProfilePresenter;
    @Override
    protected int getContentView() {
        return R.layout.activity_all_matches_hthactivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(this).registerReceiver(mHTHNotificationReceiver, new IntentFilter("com.khiladiadda.in.HTH_MATCHES_NOTIFY"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mHTHNotificationReceiverMatchesRefresh, new IntentFilter("com.khiladiadda.in.HTH_MATCHES_REFRESH_NOTIFY"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mHTHNotificationReceiverLiveMatches, new IntentFilter("com.khiladiadda.in.HTH_MATCHES_LIVE_NOTIFY"));
    }

    @Override
    protected void initViews(){
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
        mLeagueTV.setOnClickListener(this);
        mHomeTV.setOnClickListener(this);
        mHelpTV.setOnClickListener(this);
        mSwipeRefreshL.setOnRefreshListener(this);
        mWalletRV.setOnClickListener(this);
        mTitleNameFbTV.setText(getString(R.string.clashx));
        mProfilePresenter=new ProfilePresenter(this);
    }
    @Override
    protected void initVariables() {
        mPresenter=new HTHPresenter(this);
        mMatchAdapter = new HTHAdpter(mMatchList);
        mMatchRV.setLayoutManager(new LinearLayoutManager(this));
        mMatchRV.setAdapter(mMatchAdapter);
        mMatchAdapter.setOnItemClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
            case R.id.tv_home:
                if (mAppPreference.getIsDeepLinking()) {
                    finish();
                    startActivity(new Intent(this,MainActivity.class));
                } else {
                    finish();
                }
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_league:
                startActivity(new Intent(this, MyFanLeagueActivityHTH.class));
                break;
            case R.id.tv_help:
                startActivity(new Intent(this,HelpActivity.class));
                break;
            case R.id.rl_wallet:
                startActivity(new Intent(this,WalletActivity.class));
                break;
        }
    }
    @Override
    public void onRefresh() {
        getData();
    }
    @Override
    public void onGetHTHMatchListComplete(HTHMainResponse responseModel) {
        mMatchList.clear();
        if(responseModel.isStatus()){
            mMatchList.addAll(responseModel.getResponse());
            if (responseModel.getBanners().size()>0){
                setUpAdvertisementViewPager(responseModel.getBanners());
            } else {
                mBannerVP.setVisibility(GONE);
            }
        }
        mMatchAdapter.notifyDataSetChanged();
        mSwipeRefreshL.setRefreshing(false);
    }
    @Override
    public void onGetHTHMatchListFailure(ApiError error){
        mSwipeRefreshL.setRefreshing(false);
    }

    @Override
    public void onCancelBattle(HTHCancelResponse responseModel) {
    }
    @Override
    public void onCancelBattleFailure(ApiError error) {

    }
    @Override
    public void onGetResultBattle(Result responseModel) {

    }
    @Override
    public void onResultBattleFailure(ApiError error) {

    }
    @Override
    public void onMatchStatus(HTHMainResponse responseModel) {

    }
    @Override
    public void onMatchStatusError(ApiError error) {

    }
    @Override
    public void onItemClick(View view, int position,int tag){
        if (mMatchList.get(position).isLive()){
            Intent i = new Intent(this,HTHBattlesActivity.class);
            i.putExtra(AppConstant.FROM,getIntent().getIntExtra(AppConstant.FROM, 0));
            i.putExtra(AppConstant.BATTLE_DATA,mMatchList.get(position));
            startActivity(i);
        } else {
            Snackbar.make(mLeagueTV,getString(R.string.text_match_open_soon),Snackbar.LENGTH_LONG).show();
        }
    }

    private void getData() {
        if (new NetworkStatus(this).isInternetOn()){
            mSwipeRefreshL.setRefreshing(true);
            mPresenter.getHTHMatchList("");
        } else {
            Snackbar.make(mBackIV,R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }
    private void setUpAdvertisementViewPager(List<BannerDetails> advertisementDetails) {
        mAdvertisementsList.clear();
        mAdvertisementsList.addAll(advertisementDetails);
        List<Fragment> mFragmentList=new ArrayList<>();
        for (BannerDetails advertisement:advertisementDetails) {
            mFragmentList.add(BannerFragment.getInstance(advertisement));
        }
        BannerPagerAdapter adapter=new BannerPagerAdapter(this.getSupportFragmentManager(), mFragmentList);
        mBannerVP.setAdapter(adapter);
        mBannerVP.setOffscreenPageLimit(3);
        if (mHandler==null) {
            mHandler=new Handler();
            moveToNextAd(0);
        }
    }
    private void moveToNextAd(int i){
        mBannerVP.setCurrentItem(i, true);
        mHandler.postDelayed(() -> {
            int currentItem=mBannerVP.getCurrentItem();
            moveToNextAd((currentItem + 1) % mAdvertisementsList.size() == 0 ? 0 : currentItem + 1);
        }, 10000);
    }
    private BroadcastReceiver mHTHNotificationReceiver=new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent){
            String data = intent.getStringExtra(AppConstant.FROM);
            if (data.equalsIgnoreCase(AppConstant.HTHMATCHES)) {
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    getData();
                }
            }
        }
    };
    private BroadcastReceiver mHTHNotificationReceiverMatchesRefresh = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra(AppConstant.FROM);
            if (data.equalsIgnoreCase(AppConstant.HTHMATCHES)) {
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    getData();
                }
            }
        }
    };
    private BroadcastReceiver mHTHNotificationReceiverLiveMatches=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra(AppConstant.FROM);
            if (data.equalsIgnoreCase(AppConstant.HTHLIVEREFRSH)) {
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)){
                    Intent i=new Intent(AllMatchesHTHActivity.this,MyFanLeagueActivityHTH.class);
                    i.putExtra(AppConstant.FROM, AppConstant.FROM_FANBATTLE_LIVE);
                    startActivity(i);
                }
            }
        }
    };
    @Override
    protected void onResume(){
        super.onResume();
        if (mAppPreference.getBoolean(AppConstant.MATCH_LIVE, false)) {
            mAppPreference.setBoolean(AppConstant.MATCH_LIVE, false);
            startActivity(new Intent(this, MyFanLeagueActivityHTH.class));
        } else {
            onRefresh();
        }
        getDataUpdate();
    }
    @Override
    protected void onDestroy(){
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHTHNotificationReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHTHNotificationReceiverMatchesRefresh);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHTHNotificationReceiverLiveMatches);
        AppUtilityMethods.deleteCache(this);
        mPresenter.destroy();
        super.onDestroy();
    }
    private void getDataUpdate(){
        if(new NetworkStatus(this).isInternetOn()){
            mProfilePresenter.getProfile();
        }

    }
    @Override
    public void onUpdatePasswordComplete(BaseResponse responseModel) {

    }
    @Override
    public void onUpdatePasswordFailure(ApiError error) {

    }
    @Override
    public void onUpdateDOBComplete(ProfileResponse responseModel) {

    }
    @Override
    public void onUpdateDOBFailure(ApiError error) {
    }
    @Override
    public void onProfileComplete(ProfileTransactionResponse responseModel) {
        hideProgress();
        mAppPreference.setProfileData(responseModel.getResponse());
        double mTotalWalletBal=responseModel.getResponse().getCoins().getDeposit() + responseModel.getResponse().getCoins().getWinning() + responseModel.getResponse().getCoins().getBonus();
        mTotalWalletBLTV.setText("₹" + AppUtilityMethods.roundUpNumber(mTotalWalletBal));
    }
    @Override
    public void onProfileFailure(ApiError error) {

    }
    @Override
    public void onApplyVoucherComplete(BaseResponse responseModel){

    }
    @Override
    public void onApplyVoucherFailure(ApiError error){

    }
    @Override
    public void onSendOtpComplete(BaseResponse responseModel){

    }
    @Override
    public void onSendOtpFailure(ApiError error){

    }
    @Override
    public void onVerifyEmailComplete(BaseResponse responseModel) {

    }
    @Override
    public void onVerifyEmailFailure(ApiError error) {

    }
}