package com.khiladiadda.in.leaderboard.past;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.help.HelpActivity;
import com.khiladiadda.in.leaderboard.past.adapter.PastLeaderBoardRVAdapter;
import com.khiladiadda.in.leaderboard.past.interfaces.IPastLeaderboardPresenter;
import com.khiladiadda.in.leaderboard.past.interfaces.IPastLeaderboardView;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.SquadLeaderboard;
import com.khiladiadda.in.network.model.response.SquadLeaderbordResponse;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.NetworkStatus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.khiladiadda.in.utility.AppConstant.PAGE_SIZE;

public class PastLeaderboardActivity extends BaseActivity implements IPastLeaderboardView {

    @BindView(R.id.iv_back) ImageView mBackIV;
    @BindView(R.id.tv_activity_name) TextView mActivityNameTV;
    @BindView(R.id.iv_notification) ImageView mNotificationIV;
    @BindView(R.id.rv_leaderboard) RecyclerView mLeaderBoardRV;

    private PastLeaderBoardRVAdapter mAdapter;
    private List<SquadLeaderboard> mList = null;
    private IPastLeaderboardPresenter mPresenter;
    private LinearLayoutManager mLayoutManager;
    private boolean isLoading, isLastPage;
    private int mCurrentPage = 0, mItemCount;

    @Override protected int getContentView() {
        return R.layout.activity_past_leaderboard;
    }

    @Override protected void initViews() {
        mActivityNameTV.setText(R.string.text_leaderboard);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
    }

    @Override protected void initVariables() {
        mPresenter = new PastLeaderboardPresenter(this);

        mList = new ArrayList<>();
        mAdapter = new PastLeaderBoardRVAdapter(this, mList);
        mLayoutManager = new LinearLayoutManager(this);
        mLeaderBoardRV.setLayoutManager(mLayoutManager);
        mLeaderBoardRV.setAdapter(mAdapter);
        mLeaderBoardRV.addOnScrollListener(recyclerViewOnScrollListener);

        getData();
    }

    private void getData() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getLeaderboard(getIntent().getStringExtra(AppConstant.ID), mCurrentPage, PAGE_SIZE);
        } else {
            Snackbar.make(mBackIV, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
            case R.id.tv_home:
                finish();
                break;
            case R.id.iv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_help:
                Intent help = new Intent(this, HelpActivity.class);
                startActivity(help);
                break;
        }
    }

    @Override public void onPastLeaderBoardComplete(SquadLeaderbordResponse responseModel) {
        hideProgress();
        List<SquadLeaderboard> leaderboardList = responseModel.getResponse();
        mItemCount = leaderboardList.size();
        if (responseModel.isStatus()) {
            if (mCurrentPage == 0 && mItemCount >= 0) {
                mList.clear();
                mList.addAll(leaderboardList);
            } else {
                mList.addAll(leaderboardList);
            }
            isLoading = false;
            mCurrentPage++;
            if (mItemCount < PAGE_SIZE) {
                isLastPage = true;
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override public void onPastLeaderBoardFailure(ApiError error) {
        hideProgress();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    private final RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                //if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE)
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && mItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private void loadMoreItems() {
        //show bottom progress bar
        isLoading = true;
        getData();
    }

}