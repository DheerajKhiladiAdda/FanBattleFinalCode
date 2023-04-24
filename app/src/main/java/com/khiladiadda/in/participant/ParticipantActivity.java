package com.khiladiadda.in.participant;


import static com.khiladiadda.in.utility.AppConstant.PAGE_SIZE;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.fcm.NotificationActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.FBParticipantData;
import com.khiladiadda.in.network.model.response.FBParticipantList;
import com.khiladiadda.in.network.model.response.FBParticipantResponse;
import com.khiladiadda.in.network.model.response.ParticipantDetails;
import com.khiladiadda.in.network.model.response.QuizParticipant;
import com.khiladiadda.in.participant.adapter.FBBattleParticipantAdapter;
import com.khiladiadda.in.participant.adapter.FBParticipantAdapter;
import com.khiladiadda.in.participant.adapter.ParticipantAdapter;
import com.khiladiadda.in.participant.interfaces.IParticipantPresenter;
import com.khiladiadda.in.participant.interfaces.IParticipantView;
import com.khiladiadda.in.utility.AppConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ParticipantActivity extends BaseActivity implements IParticipantView {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.tv_activity_name)
    TextView mActivityNameTV;
    @BindView(R.id.iv_notification)
    ImageView mNotificationIV;
    @BindView(R.id.tv_no_data)
    TextView mNoDataTV;
    @BindView(R.id.rv_participant)
    RecyclerView mRV;

    private LinearLayoutManager mLayoutManager;
    private IParticipantPresenter mPresenter;
    private ParticipantAdapter mLeagueAdapter;
    private List<ParticipantDetails> mLeagueList;
    private List<QuizParticipant> mQuizList;
    private boolean isLoading, isLastPage;
    private int mCurrentPage = 0;
    private FBParticipantAdapter mFBGroupParticipantAdapter;
    private List<FBParticipantList> mFBGroupParticipantList;

    @Override
    protected int getContentView() {
        return R.layout.activity_participant;
    }

    @Override
    protected void initViews() {
        mActivityNameTV.setText(R.string.text_view_participant);
        mBackIV.setOnClickListener(this);
        mNotificationIV.setOnClickListener(this);
    }

    @Override
    protected void initVariables() {
        mPresenter = new ParticipantPresenter(this);

        mLeagueList = new ArrayList<>();
        mLeagueAdapter = new ParticipantAdapter(this, mLeagueList);
        mLayoutManager = new LinearLayoutManager(this);
        mRV.setLayoutManager(mLayoutManager);
        mRV.setAdapter(mLeagueAdapter);
        mRV.addOnScrollListener(recyclerViewOnScrollListener);

        mQuizList = new ArrayList<>();
       // mQuizAdapter = new QuizParticipantAdapter(mQuizList);
        mFBGroupParticipantList = new ArrayList<>();
        mFBGroupParticipantAdapter = new FBParticipantAdapter(this, mFBGroupParticipantList);
        List<FBParticipantData> mFBBattleParticipantList = new ArrayList<>();
        FBBattleParticipantAdapter mFBBattleParticipantAdapter = new FBBattleParticipantAdapter(this, mFBBattleParticipantList);

        getData();
    }

    private void getData() {
        showProgress(getString(R.string.txt_progress_authentication));
        if (getIntent().getStringExtra(AppConstant.FROM).equalsIgnoreCase(AppConstant.FROM_VIEW_QUIZ)) {
           // mPresenter.getQuizParticipant(getIntent().getStringExtra(AppConstant.ID), mCurrentPage, AppConstant.PAGE_SIZE);
        } else if (getIntent().getStringExtra(AppConstant.FROM).equalsIgnoreCase(AppConstant.LEAGUE)) {
          //  mPresenter.getParticipant(getIntent().getStringExtra(AppConstant.ID));
        } else if (getIntent().getStringExtra(AppConstant.FROM).equalsIgnoreCase(AppConstant.FROM_FB_BATTLE)) {
            mPresenter.getFBBattleParticipant(getIntent().getStringExtra(AppConstant.ID), mCurrentPage, PAGE_SIZE);
        } else if (getIntent().getStringExtra(AppConstant.FROM).equalsIgnoreCase(AppConstant.FROM_FB_MATCH)) {
            mPresenter.getFBMatchParticipant(getIntent().getStringExtra(AppConstant.ID), mCurrentPage, PAGE_SIZE);
        } else {
            mPresenter.getFBGroupParticipant(getIntent().getStringExtra(AppConstant.ID), mCurrentPage, PAGE_SIZE, true);
        }
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
        }
    }







    @Override
    public void onFBGroupParticipantComplete(FBParticipantResponse responseModel) {
        hideProgress();
        mRV.setAdapter(mFBGroupParticipantAdapter);
        if (responseModel.getResponse().size() > 0) {
            if (mCurrentPage == 0) {
                mFBGroupParticipantList.clear();
            }
            if (mCurrentPage == 0 && responseModel.getResponse().size() <= 0) {
                mNoDataTV.setVisibility(View.VISIBLE);
            } else if (responseModel.getResponse().size() > 0) {
                mFBGroupParticipantList.addAll(responseModel.getResponse());
                mFBGroupParticipantAdapter.notifyDataSetChanged();
            }
            isLoading = false;
            mCurrentPage++;
            if (responseModel.getResponse().size() < PAGE_SIZE) {
                isLastPage = true;
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFBGroupParticipantFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onFBBattleParticipantComplete(FBParticipantResponse responseModel) {
        hideProgress();
        mRV.setAdapter(mFBGroupParticipantAdapter);
        if (responseModel.getResponse().size() > 0) {
            if (mCurrentPage == 0) {
                mFBGroupParticipantList.clear();
            }
            if (mCurrentPage == 0 && responseModel.getResponse().size() <= 0) {
                mNoDataTV.setVisibility(View.VISIBLE);
            } else if (responseModel.getResponse().size() > 0) {
                mFBGroupParticipantList.addAll(responseModel.getResponse());
                mFBGroupParticipantAdapter.notifyDataSetChanged();
            }
            isLoading = false;
            mCurrentPage++;
            if (responseModel.getResponse().size() < PAGE_SIZE) {
                isLastPage = true;
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }

//        mRV.setAdapter(mFBBattleParticipantAdapter);
//        if (responseModel.getResponse().size() > 0) {
//            if (mCurrentPage == 0) {
//                mFBBattleParticipantList.clear();
//            }
//            if (mCurrentPage == 0 && responseModel.getResponse().size() <= 0) {
//                mNoDataTV.setVisibility(View.VISIBLE);
//            } else if (responseModel.getResponse().size() > 0) {
//                mFBBattleParticipantList.addAll(responseModel.getResponse());
//                mFBBattleParticipantAdapter.notifyDataSetChanged();
//            }
//            isLoading = false;
//            mCurrentPage++;
//            if (responseModel.getResponse().size() < PAGE_SIZE) {
//                isLastPage = true;
//            }
//        } else {
//            mNoDataTV.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void onFBBattleParticipantFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onFBMatchParticipantComplete(FBParticipantResponse responseModel) {
        hideProgress();
        mRV.setAdapter(mFBGroupParticipantAdapter);
        if (responseModel.getResponse().size() > 0) {
            if (mCurrentPage == 0) {
                mFBGroupParticipantList.clear();
            }
            if (mCurrentPage == 0 && responseModel.getResponse().size() <= 0) {
                mNoDataTV.setVisibility(View.VISIBLE);
            } else if (responseModel.getResponse().size() > 0) {
                mFBGroupParticipantList.addAll(responseModel.getResponse());
                mFBGroupParticipantAdapter.notifyDataSetChanged();
            }
            isLoading = false;
            mCurrentPage++;
            if (responseModel.getResponse().size() < PAGE_SIZE) {
                isLastPage = true;
            }
        } else {
            mNoDataTV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFBMatchParticipantFailure(ApiError error) {
        hideProgress();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE) {
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