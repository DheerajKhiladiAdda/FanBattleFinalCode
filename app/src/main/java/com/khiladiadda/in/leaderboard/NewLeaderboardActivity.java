package com.khiladiadda.in.leaderboard;

import static com.khiladiadda.in.utility.AppConstant.PAGE_SIZE;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.dialogs.interfaces.IOnShowGameListener;
import com.khiladiadda.in.leaderboard.adapter.AllLeaderBoardRVAdapter;
import com.khiladiadda.in.leaderboard.adapter.FbLeadBoardAdapter;
import com.khiladiadda.in.leaderboard.adapter.LudoAddaLeaderBoardRVAdapter;
import com.khiladiadda.in.leaderboard.adapter.LudoLeaderBoardRVAdapter;
import com.khiladiadda.in.leaderboard.interfaces.ILeaderboardPresenter;
import com.khiladiadda.in.leaderboard.interfaces.ILeaderboardView;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.AllLeaderBoardResponse;
import com.khiladiadda.in.network.model.response.AllLederBoardDetails;
import com.khiladiadda.in.network.model.response.LudoAddaMainResponse;
import com.khiladiadda.in.network.model.response.LudoAddaResponseDetails;
import com.khiladiadda.in.network.model.response.LudoLeaderboardDetails;
import com.khiladiadda.in.network.model.response.LudoLeaderboardResponse;
import com.khiladiadda.in.network.model.response.OverallLeadBoardList;
import com.khiladiadda.in.network.model.response.OverallLeadBoardResponse;
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponse;
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponseDetails;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewLeaderboardActivity extends BaseActivity implements ILeaderboardView, CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.btn_clashx)
    Button mClashxBTN;
    @BindView(R.id.rv_leaderboard)
    RecyclerView mLeaderBoardRV;
    @BindView(R.id.rv_ludo_leaderboard)
    RecyclerView mLudoLeaderBoardRV;
    @BindView(R.id.tv_no_data)
    TextView mNoDataTV;
    @BindView(R.id.tv_profile_name_single)
    AppCompatTextView mTitleToolbarTV;
    @BindView(R.id.tv_leaderboard)
    TextView mTitleTV;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.gold_winner)
    CircularImageView mGoldWinnerIV;
    @BindView(R.id.gold_crown)
    ImageView mGoldCrownIV;
    @BindView(R.id.text_gold_winner_name)
    TextView mGoldWinerNameTV;
    @BindView(R.id.gold_winner_coins)
    TextView mGoldCoinsTV;
    @BindView(R.id.sliver_winner)
    CircularImageView mSliverWinerIV;
    @BindView(R.id.silver_crown)
    ImageView mSilverCrownIV;
    @BindView(R.id.text_silver_winner_name)
    TextView mSilverWinerNameTV;
    @BindView(R.id.tv_sliver_winner_coins)
    TextView mSilverWinerCoinsTV;
    @BindView(R.id.bronze_winner)
    CircularImageView mBronzeWinnerIV;
    @BindView(R.id.bronze_crown)
    ImageView mBronzeCrownIV;
    @BindView(R.id.brown_winner_name)
    TextView mBrownWinnerNameTV;
    @BindView(R.id.brown_winner_coins)
    TextView mBrownWinnerCoinsTV;
    @BindView(R.id.btn_fan_battle)
    Button mFanBattleBTN;
    @BindView(R.id.rv_fanbattle_leaderboard)
    RecyclerView mFanBattledRV;
    @BindView(R.id.leaderboard)
    RelativeLayout mLeaderBoradRL;
    @BindView(R.id.iv_back_toolbar)
    ImageView mToolbarBackIV;
    @BindView(R.id.sm_leaderboard)
    SwitchMaterial mALLMonthSW;
    @BindView(R.id.ll_bottom)
    LinearLayout mBottomLL;
    @BindView(R.id.rv_hth_leaderboard)
    RecyclerView mHTHRV;
    @BindView(R.id.rv_ludoadda_leaderboard)
    RecyclerView mLudoAddaRV;

    private ILeaderboardPresenter mPresenter;
    private String mGameId;
    private boolean mIsLoading, mIsLastPage;
    private int mCurrentPage = 0, mItemCount, mContestType, mListingType = AppConstant.LEADERBOARD_LISTING_ALL, mType = AppConstant.LEADERBOARD_TYPE_GAME;

    private LinearLayoutManager mLeagueLayoutManager;
    private LinearLayoutManager mLudoLayoutManager;
    private LinearLayoutManager mFanBattleManager;
    private LinearLayoutManager mLudoAddaManger;
    private LinearLayoutManager mHTHBattleManager;
    private List<AllLederBoardDetails> mLeagueList;
    private AllLeaderBoardRVAdapter mAdapter;
    private List<OverallLeadBoardList> mFBLists;
    private FbLeadBoardAdapter mFBAdapter;
    private List<LudoLeaderboardDetails> mLudoList;
    private LudoLeaderBoardRVAdapter mLudoAdapter;
    private List<LeaderBoardHthResponseDetails> mHTHLists;
    private HTHLeadBoardAdapter mHthAdapter;
    private List<LudoAddaResponseDetails> mLudoAddaLists;
    private LudoAddaLeaderBoardRVAdapter mLudoAddaAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_newleaderboard;
    }

    @Override
    protected void initViews() {
        mBackIV.setOnClickListener(this);
        mToolbarBackIV.setOnClickListener(this);
        mClashxBTN.setOnClickListener(this);
        mALLMonthSW.setOnCheckedChangeListener(this);
        mFanBattleBTN.setOnClickListener(this);
    }

    @Override
    protected void initVariables() {
        mPresenter = new LeaderboardPresenter(this);

        mLeagueList = new ArrayList<>();
        mAdapter = new AllLeaderBoardRVAdapter(mLeagueList, AppConstant.LEADERBOARD_FROM_LEADERBOARD);
        mLeagueLayoutManager = new LinearLayoutManager(this);
        mLeaderBoardRV.setLayoutManager(mLeagueLayoutManager);
        mLeaderBoardRV.setAdapter(mAdapter);
        mLeaderBoardRV.addOnScrollListener(mRecyclerViewOnScrollListener);

        mLudoList = new ArrayList<>();
        mLudoAdapter = new LudoLeaderBoardRVAdapter(mLudoList, AppConstant.LEADERBOARD_FROM_LEADERBOARD);
        mLudoLayoutManager = new LinearLayoutManager(this);
        mLudoLeaderBoardRV.setLayoutManager(mLudoLayoutManager);
        mLudoLeaderBoardRV.setAdapter(mLudoAdapter);
        mLudoLeaderBoardRV.addOnScrollListener(mLudoRecyclerViewOnScrollListener);

        mFBLists = new ArrayList<>();
        mFBAdapter = new FbLeadBoardAdapter(mFBLists);
        mFanBattleManager = new LinearLayoutManager(this);
        mFanBattledRV.setLayoutManager(mFanBattleManager);
        mFanBattledRV.setAdapter(mFBAdapter);
        mFanBattledRV.addOnScrollListener(mFanBattleRecyclerViewOnScrollListener);

        mHTHLists = new ArrayList<>();
        mHthAdapter = new HTHLeadBoardAdapter(mHTHLists);
        mHTHBattleManager = new LinearLayoutManager(this);
        mHTHRV.setLayoutManager(mHTHBattleManager);
        mHTHRV.setAdapter(mHthAdapter);
        mHTHRV.addOnScrollListener(mHTHBattleRecyclerViewOnScrollListener);

        mLudoAddaLists = new ArrayList<>();
        mLudoAddaAdapter = new LudoAddaLeaderBoardRVAdapter(mLudoAddaLists);
        mLudoAddaManger = new LinearLayoutManager(this);
        mLudoAddaRV.setLayoutManager(mLudoAddaManger);
        mLudoAddaRV.setAdapter(mLudoAddaAdapter);

        mALLMonthSW.setChecked(false);
        mType = AppConstant.LEADERBOARD_TYPE_HTH_BATTLE;
        setSelectedBackground();

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    mTitleToolbarTV.setVisibility(View.VISIBLE);
                    mToolbarBackIV.setVisibility(View.VISIBLE);
                    mGoldWinnerIV.setVisibility(View.GONE);
                    mGoldCrownIV.setVisibility(View.GONE);
                    mGoldWinerNameTV.setVisibility(View.GONE);
                    mGoldCoinsTV.setVisibility(View.GONE);
                } else if (isShow) {
                    isShow = false;
                    mTitleToolbarTV.setVisibility(View.GONE);
                    mToolbarBackIV.setVisibility(View.GONE);
                    mGoldWinnerIV.setVisibility(View.VISIBLE);
                    mGoldCrownIV.setVisibility(View.VISIBLE);
                    mGoldWinerNameTV.setVisibility(View.VISIBLE);
                    mGoldCoinsTV.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getData() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
//            if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && mType == AppConstant.LEADERBOARD_TYPE_QUIZ) {
//                mPresenter.getQuizAll(mCurrentPage, PAGE_SIZE);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && mType == AppConstant.LEADERBOARD_TYPE_QUIZ) {
//                mPresenter.getQuizMonth(mCurrentPage, PAGE_SIZE);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && mType == AppConstant.LEADERBOARD_TYPE_GAME) {
//                mPresenter.getGameAll(mGameId, mCurrentPage, PAGE_SIZE);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && mType == AppConstant.LEADERBOARD_TYPE_GAME) {
//                mPresenter.getGameMonth(mGameId, mCurrentPage, PAGE_SIZE);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && (mType == AppConstant.LEADERBOARD_TYPE_LUDO || mType == AppConstant.LEADERBOARD_TYPE_SNAKE)) {
//                mPresenter.getLudo(mCurrentPage, PAGE_SIZE, AppConstant.TYPE_ALL, mContestType);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && (mType == AppConstant.LEADERBOARD_TYPE_LUDO || mType == AppConstant.LEADERBOARD_TYPE_SNAKE)) {
//                mPresenter.getLudo(mCurrentPage, PAGE_SIZE, AppConstant.TYPE_MONTHLY, mContestType);
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && mType == AppConstant.LEADERBOARD_TYPE_LUDOADDA) {
//                mPresenter.getLudoAdda(mCurrentPage, PAGE_SIZE, "");
//            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && mType == AppConstant.LEADERBOARD_TYPE_LUDOADDA) {
//                mPresenter.getLudoAdda(mCurrentPage, PAGE_SIZE, AppConstant.LEADERBOARD_HTH_LISTING_MONTHLY);
//            }

            if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && mType == AppConstant.LEADERBOARD_TYPE_FAN_BATTLE) {
                mPresenter.getFanBattle(mCurrentPage, PAGE_SIZE, AppConstant.LEADERBOARD_FANBATTLE_LISTING_ALL);
            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && mType == AppConstant.LEADERBOARD_TYPE_FAN_BATTLE) {
                mPresenter.getFanBattle(mCurrentPage, PAGE_SIZE, AppConstant.LEADERBOARD_FANBATTLE_LISTING_MONTHLY);
            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_ALL && mType == AppConstant.LEADERBOARD_TYPE_HTH_BATTLE) {
                mPresenter.getHTHBattles(mCurrentPage, PAGE_SIZE, "");
            } else if (mListingType == AppConstant.LEADERBOARD_LISTING_MONTHLY && mType == AppConstant.LEADERBOARD_TYPE_HTH_BATTLE) {
                mPresenter.getHTHBattles(mCurrentPage, PAGE_SIZE, AppConstant.LEADERBOARD_HTH_LISTING_MONTHLY);
            }
        } else {
            Snackbar.make(mBackIV, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
            case R.id.iv_back_toolbar:
                if (mAppPreference.getIsDeepLinking()) {
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    finish();
                }
                break;
            case R.id.btn_fan_battle:
                mType = AppConstant.LEADERBOARD_TYPE_FAN_BATTLE;
                setSelectedBackground();
                break;
            case R.id.btn_clashx:
                mType = AppConstant.LEADERBOARD_TYPE_HTH_BATTLE;
                setSelectedBackground();
                break;
        }
    }

    private void setSelectedBackground() {
        mClashxBTN.setTextColor(Color.RED);
        mFanBattleBTN.setTextColor(Color.RED);
        mFanBattleBTN.setSelected(false);
        mClashxBTN.setSelected(false);
        resetListVariables();
        if (mType == AppConstant.LEADERBOARD_TYPE_FAN_BATTLE) {
            mFanBattleBTN.setSelected(true);
            mFanBattleBTN.setTextColor(Color.WHITE);
            mTitleToolbarTV.setText(getString(R.string.fan_battle_leaderboard));
            mTitleTV.setText(getString(R.string.fan_battle_leaderboard));
        } else if (mType == AppConstant.LEADERBOARD_TYPE_HTH_BATTLE) {
            mClashxBTN.setSelected(true);
            mClashxBTN.setTextColor(Color.WHITE);
            mTitleToolbarTV.setText(getString(R.string.hth_leaderboard));
            mTitleTV.setText(getString(R.string.hth_leaderboard));
        }
        getData();
    }

    private void resetListVariables() {
        mLeagueList.clear();
        mLudoList.clear();
        mFBLists.clear();
        mHTHLists.clear();
        mLudoAddaLists.clear();
        mCurrentPage = 0;
        mItemCount = 0;
        mIsLastPage = false;
    }

    private void resetLeaderBoardView(int type) {
        mNoDataTV.setVisibility(View.GONE);
        mLudoLeaderBoardRV.setVisibility(View.GONE);
        mLeaderBoardRV.setVisibility(View.GONE);
        mFanBattledRV.setVisibility(View.GONE);
        mHTHRV.setVisibility(View.GONE);
        mLudoAddaRV.setVisibility(View.GONE);
        if ((type == AppConstant.LEADERBOARD_TYPE_GAME) || (type == AppConstant.LEADERBOARD_TYPE_QUIZ)) {
            mLeaderBoardRV.setVisibility(View.VISIBLE);
        } else if (type == AppConstant.LEADERBOARD_TYPE_LUDO) {
            mLudoLeaderBoardRV.setVisibility(View.VISIBLE);
        } else if (type == AppConstant.LEADERBOARD_TYPE_FAN_BATTLE) {
            mFanBattledRV.setVisibility(View.VISIBLE);
        } else if (type == AppConstant.LEADERBOARD_TYPE_HTH_BATTLE) {
            mHTHRV.setVisibility(View.VISIBLE);
        } else if (type == AppConstant.LEADERBOARD_TYPE_LUDOADDA) {
            mLudoAddaRV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLeaderBoardComplete(AllLeaderBoardResponse responseModel) {
        resetLeaderBoardView(AppConstant.LEADERBOARD_TYPE_GAME);
        if (responseModel.isStatus()) {
            List<AllLederBoardDetails> leaderboardList = responseModel.getResponse();
            mItemCount = leaderboardList.size();
            if (mCurrentPage == 0) {
                mLeagueList.clear();
            }
            if (mCurrentPage == 0 && mItemCount <= 0) {
                mAppBarLayout.setExpanded(false);
                mNoDataTV.setVisibility(View.VISIBLE);
            }
            if (mItemCount > 3) {
                if (mCurrentPage == 0) {
                    mLeagueList.clear();
                    mLeagueList.addAll(leaderboardList.subList(3, mItemCount));
                    setLeaderData(leaderboardList, mItemCount);
                } else {
                    mLeagueList.addAll(leaderboardList);
                }
                mIsLoading = false;
                mCurrentPage++;
                if (mItemCount < PAGE_SIZE) {
                    mIsLastPage = true;
                }
            } else if (mItemCount >= 1) {
                setLeaderData(leaderboardList, mItemCount);
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
        mAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onLeaderBoardFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onLudoLeaderBoardComplete(LudoLeaderboardResponse responseModel) {
        resetLeaderBoardView(AppConstant.LEADERBOARD_TYPE_LUDO);
        if (responseModel.isStatus()) {
            List<LudoLeaderboardDetails> ludoLeaderboardList = responseModel.getResponse();
            mItemCount = ludoLeaderboardList.size();
            if (mCurrentPage == 0 && mItemCount <= 0) {
                mLudoList.clear();
                mNoDataTV.setVisibility(View.VISIBLE);
                mAppBarLayout.setExpanded(false);
            }
            if (mItemCount > 3) {
                if (mCurrentPage == 0) {
                    mLudoList.clear();
                    mLudoList.addAll(ludoLeaderboardList.subList(3, mItemCount));
                    setLudoLeaderData(ludoLeaderboardList, mItemCount);
                } else {
                    mLudoList.addAll(ludoLeaderboardList);
                }
                mIsLoading = false;
                mCurrentPage++;
                if (mItemCount < PAGE_SIZE) {
                    mIsLastPage = true;
                }
            } else if (mItemCount >= 1) {
                setLudoLeaderData(ludoLeaderboardList, mItemCount);
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
        mLudoAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onLudoLeaderBoardFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onLeaderFanBattleComplete(OverallLeadBoardResponse responseModel) {
        resetLeaderBoardView(AppConstant.LEADERBOARD_TYPE_FAN_BATTLE);
        if (responseModel.isStatus()) {
            List<OverallLeadBoardList> fbLeaderboardList = responseModel.getOverallLeadBoardLists();
            mItemCount = fbLeaderboardList.size();
            if (mCurrentPage == 0 && mItemCount <= 0) {
                mFBLists.clear();
                mNoDataTV.setVisibility(View.VISIBLE);
                mAppBarLayout.setExpanded(false);
            }
            if (mItemCount > 3) {
                if (mCurrentPage == 0) {
                    mFBLists.clear();
                    mFBLists.addAll(fbLeaderboardList.subList(3, mItemCount));
                    setFanBattleData(fbLeaderboardList, mItemCount);
                } else {
                    mFBLists.addAll(fbLeaderboardList);
                }
                mIsLoading = false;
                mCurrentPage++;
                if (mItemCount < PAGE_SIZE) {
                    mIsLastPage = true;
                }
            } else if (mItemCount >= 1) {
                setFanBattleData(fbLeaderboardList, mItemCount);
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
        mFBAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onLeaderFanBattleFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onLeaderHTHBattleComplete(LeaderBoardHthResponse responseModel) {
        resetLeaderBoardView(AppConstant.LEADERBOARD_TYPE_HTH_BATTLE);
        if (responseModel.isStatus()) {
            List<LeaderBoardHthResponseDetails> hthLeaderboardList = responseModel.getResponse();
            mItemCount = hthLeaderboardList.size();
            if (mCurrentPage == 0 && mItemCount <= 0) {
                mHTHLists.clear();
                mNoDataTV.setVisibility(View.VISIBLE);
                mAppBarLayout.setExpanded(false);
            }
            if (mItemCount > 3) {
                if (mCurrentPage == 0) {
                    mHTHLists.clear();
                    mHTHLists.addAll(hthLeaderboardList.subList(3, mItemCount));
                    setHTHBattleData(hthLeaderboardList, mItemCount);
                } else {
                    mHTHLists.addAll(hthLeaderboardList);
                }
                mIsLoading = false;
                mCurrentPage++;
                if (mItemCount < PAGE_SIZE) {
                    mIsLastPage = true;
                }
            } else if (mItemCount >= 1) {
                setHTHBattleData(hthLeaderboardList, mItemCount);
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
        mHthAdapter.notifyDataSetChanged();
        hideProgress();
    }

    private void setHTHBattleData(List<LeaderBoardHthResponseDetails> overallLeadBoardLists, int size) {
        mAppBarLayout.setExpanded(true);
        mBrownWinnerNameTV.setText("");
        mBrownWinnerCoinsTV.setText("");
        mSilverWinerNameTV.setText("");
        mSilverWinerCoinsTV.setText("");
        mGoldWinerNameTV.setText("");
        mGoldCoinsTV.setText("");
        if (size >= 3) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getnCof().getWon()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + overallLeadBoardLists.get(1).getName());
            if ((overallLeadBoardLists.get(1).getnCof().getWon()) != 0.00) {
                mSilverWinerCoinsTV.setText("Won: " + overallLeadBoardLists.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(1).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(1).getDp()).thumbnail(Glide.with(this).load(overallLeadBoardLists.get(1).getDp())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mBrownWinnerNameTV.setText("3." + overallLeadBoardLists.get(2).getName());
            if ((overallLeadBoardLists.get(2).getnCof().getWon()) != 0.00) {
                mBrownWinnerCoinsTV.setText("Won: " + overallLeadBoardLists.get(2).getTotal() + " Coins");
            } else {
                mBrownWinnerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(2).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(2).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mBronzeWinnerIV);
            } else {
                Glide.with(this).clear(mBronzeWinnerIV);
                mBronzeWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(3);
        } else if (size == 2) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getnCof().getWon()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + overallLeadBoardLists.get(1).getName());
            if ((overallLeadBoardLists.get(1).getnCof().getWon()) != 0.00) {
                mSilverWinerCoinsTV.setText("Won: " + overallLeadBoardLists.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(1).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(1).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(2);
        } else if (size == 1) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getnCof().getWon()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            }
            showTopLeaderVisible(1);
        }
    }

    @Override
    public void onLeaderHTHBattleFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onLeaderLudoAddaComplete(LudoAddaMainResponse responseModel) {
        resetLeaderBoardView(AppConstant.LEADERBOARD_TYPE_LUDOADDA);
        if (responseModel.isStatus()) {
            List<LudoAddaResponseDetails> ludoLeaderboardList = responseModel.getResponse();
            mItemCount = ludoLeaderboardList.size();
            if (mCurrentPage == 0 && mItemCount <= 0) {
                mLudoAddaLists.clear();
                //  mTopLeaderLL.setVisibility(View.GONE);
                mNoDataTV.setVisibility(View.VISIBLE);
                mAppBarLayout.setExpanded(false);
            }
            if (mItemCount > 3) {
                if (mCurrentPage == 0) {
                    mLudoAddaLists.clear();
                    mLudoAddaLists.addAll(ludoLeaderboardList.subList(3, mItemCount));
                    setLudoAddaLeaderData(ludoLeaderboardList, mItemCount);
                } else {
                    mLudoAddaLists.addAll(ludoLeaderboardList);
                }
                mIsLoading = false;
                mCurrentPage++;
                if (mItemCount < PAGE_SIZE) {
                    mIsLastPage = true;
                }
            } else if (mItemCount >= 1) {
                setLudoAddaLeaderData(ludoLeaderboardList, mItemCount);
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
        mLudoAddaAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onLeaderLudoAdda(ApiError error) {
        hideProgress();
    }

    private void setLudoAddaLeaderData(List<LudoAddaResponseDetails> ludoAddaLeaderboardList, int mItemCount) {
        mAppBarLayout.setExpanded(true);
        mBrownWinnerNameTV.setText("");
        mBrownWinnerCoinsTV.setText("");
        mSilverWinerNameTV.setText("");
        mSilverWinerCoinsTV.setText("");
        mGoldWinerNameTV.setText("");
        mGoldCoinsTV.setText("");
        if (mItemCount >= 3) {
            mGoldWinerNameTV.setText("1." + ludoAddaLeaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(0).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + ludoAddaLeaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(1).getTotal()))) {
                mSilverWinerCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(1).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(1).getDp()).thumbnail(Glide.with(this).load(ludoAddaLeaderboardList.get(1).getDp())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mBrownWinnerNameTV.setText("3." + ludoAddaLeaderboardList.get(2).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(0).getTotal()))) {
                mBrownWinnerCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(2).getTotal() + " Coins");
            } else {
                mBrownWinnerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(2).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(2).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mBronzeWinnerIV);
            } else {
                Glide.with(this).clear(mBronzeWinnerIV);
                mBronzeWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(3);
        } else if (mItemCount == 2) {
            mGoldWinerNameTV.setText("1." + ludoAddaLeaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(0).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + ludoAddaLeaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(1).getTotal()))) {
                mSilverWinerCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(1).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(1).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(2);
        } else if (mItemCount == 1) {
            mGoldWinerNameTV.setText("1." + ludoAddaLeaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(ludoAddaLeaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + ludoAddaLeaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(ludoAddaLeaderboardList.get(0).getDp())) {
                Glide.with(this).load(ludoAddaLeaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            }
            showTopLeaderVisible(1);
        }
    }

    private IOnShowGameListener onSelectGameListener = new IOnShowGameListener() {
        @Override
        public void onShowGame(int listingType, int gameType, int contestType, String gameId) {
            mListingType = listingType;
            mType = gameType;
            mContestType = contestType;
            mGameId = gameId;
            getData();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        AppUtilityMethods.deleteCache(this);
    }

    private RecyclerView.OnScrollListener mRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLeagueLayoutManager.getChildCount();
            int totalItemCount = mLeagueLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLeagueLayoutManager.findFirstVisibleItemPosition();

            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && mItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private RecyclerView.OnScrollListener mLudoRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLudoLayoutManager.getChildCount();
            int totalItemCount = mLudoLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLudoLayoutManager.findFirstVisibleItemPosition();

            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && mItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private RecyclerView.OnScrollListener mFanBattleRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mFanBattleManager.getChildCount();
            int totalItemCount = mFanBattleManager.getItemCount();
            int firstVisibleItemPosition = mFanBattleManager.findFirstVisibleItemPosition();

            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && mItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private RecyclerView.OnScrollListener mHTHBattleRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mHTHBattleManager.getChildCount();
            int totalItemCount = mHTHBattleManager.getItemCount();
            int firstVisibleItemPosition = mHTHBattleManager.findFirstVisibleItemPosition();
            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && mItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private void loadMoreItems() {
        //show bottom progress bar
        mIsLoading = true;
        getData();
    }

    private void setLudoLeaderData(List<LudoLeaderboardDetails> leaderboardList, int size) {
        mAppBarLayout.setExpanded(true);
        mBrownWinnerNameTV.setText("");
        mBrownWinnerCoinsTV.setText("");
        mSilverWinerNameTV.setText("");
        mSilverWinerCoinsTV.setText("");
        mGoldWinerNameTV.setText("");
        mGoldCoinsTV.setText("");
        if (size >= 3) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + leaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(1).getTotal()))) {
                mSilverWinerCoinsTV.setText("Won: " + leaderboardList.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(1).getDp())) {
                Glide.with(this).load(leaderboardList.get(1).getDp()).thumbnail(Glide.with(this).load(leaderboardList.get(1).getDp())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mBrownWinnerNameTV.setText("3." + leaderboardList.get(2).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(0).getTotal()))) {
                mBrownWinnerCoinsTV.setText("Won: " + leaderboardList.get(2).getTotal() + " Coins");
            } else {
                mBrownWinnerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(2).getDp())) {
                Glide.with(this).load(leaderboardList.get(2).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mBronzeWinnerIV);
            } else {
                Glide.with(this).clear(mBronzeWinnerIV);
                mBronzeWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(3);
        } else if (size == 2) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + leaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(1).getTotal()))) {
                mSilverWinerCoinsTV.setText("Won: " + leaderboardList.get(1).getTotal() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(1).getDp())) {
                Glide.with(this).load(leaderboardList.get(1).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(2);
        } else if (size == 1) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(String.valueOf(leaderboardList.get(0).getTotal()))) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getTotal() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            }
            showTopLeaderVisible(1);
        }
    }

    private void setFanBattleData(List<OverallLeadBoardList> overallLeadBoardLists, int size) {
        mAppBarLayout.setExpanded(true);
        mBrownWinnerNameTV.setText("");
        mBrownWinnerCoinsTV.setText("");
        mSilverWinerNameTV.setText("");
        mSilverWinerCoinsTV.setText("");
        mGoldWinerNameTV.setText("");
        mGoldCoinsTV.setText("");
        if (size >= 3) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getWinningAmount()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + overallLeadBoardLists.get(1).getName());
            if ((overallLeadBoardLists.get(1).getWinningAmount()) != 0.00) {
                mSilverWinerCoinsTV.setText("Won: " + overallLeadBoardLists.get(1).getWinningAmount() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(1).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(1).getDp()).thumbnail(Glide.with(this).load(overallLeadBoardLists.get(1).getDp())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mBrownWinnerNameTV.setText("3." + overallLeadBoardLists.get(2).getName());
            if ((overallLeadBoardLists.get(2).getWinningAmount()) != 0.00) {
                mBrownWinnerCoinsTV.setText("Won: " + overallLeadBoardLists.get(2).getWinningAmount() + " Coins");
            } else {
                mBrownWinnerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(2).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(2).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mBronzeWinnerIV);
            } else {
                Glide.with(this).clear(mBronzeWinnerIV);
                mBronzeWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(3);
        } else if (size == 2) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getWinningAmount()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + overallLeadBoardLists.get(1).getName());
            if ((overallLeadBoardLists.get(1).getWinningAmount()) != 0.00) {
                mSilverWinerCoinsTV.setText("Won: " + overallLeadBoardLists.get(1).getWinningAmount() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(1).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(1).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(2);
        } else if (size == 1) {
            mGoldWinerNameTV.setText("1." + overallLeadBoardLists.get(0).getName());
            if ((overallLeadBoardLists.get(0).getWinningAmount()) != 0.00) {
                mGoldCoinsTV.setText("Won: " + overallLeadBoardLists.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(overallLeadBoardLists.get(0).getDp())) {
                Glide.with(this).load(overallLeadBoardLists.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            }
            showTopLeaderVisible(1);
        }
    }

    private void setLeaderData(List<AllLederBoardDetails> leaderboardList, int size) {
        mAppBarLayout.setExpanded(true);
        mBrownWinnerNameTV.setText("");
        mBrownWinnerCoinsTV.setText("");
        mSilverWinerNameTV.setText("");
        mSilverWinerCoinsTV.setText("");
        mGoldWinerNameTV.setText("");
        mGoldCoinsTV.setText("");
        if (size >= 3) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(0).getWinningAmount())) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + leaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(1).getWinningAmount())) {
                mSilverWinerCoinsTV.setText("Won: " + leaderboardList.get(1).getWinningAmount() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(1).getDp())) {
                Glide.with(this).load(leaderboardList.get(1).getDp()).thumbnail(Glide.with(this).load(leaderboardList.get(1).getDp())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mBrownWinnerNameTV.setText("3." + leaderboardList.get(2).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(2).getWinningAmount())) {
                mBrownWinnerCoinsTV.setText("Won: " + leaderboardList.get(2).getWinningAmount() + " Coins");
            } else {
                mBrownWinnerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(2).getDp())) {
                Glide.with(this).load(leaderboardList.get(2).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mBronzeWinnerIV);
            } else {
                Glide.with(this).clear(mBronzeWinnerIV);
                mBronzeWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(3);
        } else if (size == 2) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(0).getWinningAmount())) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            } else {
                Glide.with(this).clear(mGoldWinnerIV);
                mGoldWinnerIV.setImageResource(R.mipmap.ic_launcher);
            }
            mSilverWinerNameTV.setText("2." + leaderboardList.get(1).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(1).getWinningAmount())) {
                mSilverWinerCoinsTV.setText("Won: " + leaderboardList.get(1).getWinningAmount() + " Coins");
            } else {
                mSilverWinerCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(1).getDp())) {
                Glide.with(this).load(leaderboardList.get(1).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mSliverWinerIV);
            } else {
                Glide.with(this).clear(mSliverWinerIV);
                mSliverWinerIV.setImageResource(R.mipmap.ic_launcher);
            }
            showTopLeaderVisible(2);
        } else if (size == 1) {
            mGoldWinerNameTV.setText("1." + leaderboardList.get(0).getName());
            if (!TextUtils.isEmpty(leaderboardList.get(0).getWinningAmount())) {
                mGoldCoinsTV.setText("Won: " + leaderboardList.get(0).getWinningAmount() + " Coins");
            } else {
                mGoldCoinsTV.setText("Won: 0 Coins");
            }
            if (!TextUtils.isEmpty(leaderboardList.get(0).getDp())) {
                Glide.with(this).load(leaderboardList.get(0).getDp()).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(mGoldWinnerIV);
            }
            showTopLeaderVisible(1);
        }
    }

    private void showTopLeaderVisible(int i) {
        mGoldWinerNameTV.setVisibility(View.VISIBLE);
        mGoldCoinsTV.setVisibility(View.VISIBLE);
        mGoldWinnerIV.setVisibility(View.VISIBLE);
        mGoldWinnerIV.setVisibility(View.VISIBLE);
        mSliverWinerIV.setVisibility(View.VISIBLE);
        mSilverWinerCoinsTV.setVisibility(View.VISIBLE);
        mSilverWinerNameTV.setVisibility(View.VISIBLE);
        mSilverCrownIV.setVisibility(View.VISIBLE);
        if (i == 3) {
            mBronzeWinnerIV.setVisibility(View.VISIBLE);
            mBrownWinnerCoinsTV.setVisibility(View.VISIBLE);
            mBrownWinnerNameTV.setVisibility(View.VISIBLE);
            mBronzeCrownIV.setVisibility(View.VISIBLE);
        } else if (i == 2) {
            mBrownWinnerNameTV.setVisibility(View.GONE);
            mBrownWinnerCoinsTV.setVisibility(View.GONE);
            mBronzeWinnerIV.setVisibility(View.GONE);
            mBronzeCrownIV.setVisibility(View.GONE);
        } else if (i == 1) {
            mSilverWinerNameTV.setVisibility(View.GONE);
            mSilverWinerCoinsTV.setVisibility(View.GONE);
            mSliverWinerIV.setVisibility(View.GONE);
            mSilverCrownIV.setVisibility(View.GONE);
            mBrownWinnerNameTV.setVisibility(View.GONE);
            mBrownWinnerCoinsTV.setVisibility(View.GONE);
            mBronzeWinnerIV.setVisibility(View.GONE);
            mBronzeCrownIV.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            mListingType = AppConstant.LEADERBOARD_LISTING_MONTHLY;
            resetListVariables();
            getData();
        } else {
            mListingType = AppConstant.LEADERBOARD_FANBATTLE_LISTING_ALL;
            resetListVariables();
            getData();
        }
    }

    @Override
    public void onBackPressed() {
        if (mAppPreference.getIsDeepLinking()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            AppUtilityMethods.deleteCache(this);
            finish();
        }
    }


}