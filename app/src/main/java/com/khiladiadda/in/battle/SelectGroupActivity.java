package com.khiladiadda.in.battle;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.battle.adapter.SelectGroupAdapter;
import com.khiladiadda.in.battle.interfaces.IBattlePresenter;
import com.khiladiadda.in.battle.interfaces.IBattleView;
import com.khiladiadda.in.battle.model.BannerResponse;
import com.khiladiadda.in.battle.model.BattleDetails;
import com.khiladiadda.in.battle.model.BattleGroupResponse;
import com.khiladiadda.in.battle.model.BattleResponse;
import com.khiladiadda.in.battle.model.GroupDetails;
import com.khiladiadda.in.battle.model.JoinGroupSubstituteRequest;
import com.khiladiadda.in.dialogs.interfaces.IOnJoinBattleListener;
import com.khiladiadda.in.interfaces.IOnItemClickListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;

import java.util.ArrayList;

import butterknife.BindView;

public class SelectGroupActivity extends BaseActivity implements IBattleView, IOnItemClickListener {

    @BindView(R.id.iv_back)
    ImageView mBackIV;
    @BindView(R.id.rv_group)
    RecyclerView mGroupRV;
    @BindView(R.id.tv_select_combo)
    TextView mSelectComboTV;

    private SelectGroupAdapter mBattleGroupAdapter;
    private ArrayList<GroupDetails> mGroupList = new ArrayList<>();
    private IBattlePresenter mPresenter;
    private String mGroupId;
    private long mGroupJoined;
    private double mBattleInvestment;
    private double mAmount;
    private String mOldGroupId;
    private boolean mIsFree;

    @Override
    protected int getContentView() {
        return R.layout.activity_select_group;
    }

    @Override
    protected void initViews() {
        mBackIV.setOnClickListener(this);
        Intent intent = getIntent();
        BattleDetails mBattleDetails=intent.getParcelableExtra(AppConstant.DATA);
        mGroupJoined=mBattleDetails.getnGroupJoined();
        mBattleInvestment=mBattleDetails.getInvestedAmount();
        mGroupList = intent.getParcelableArrayListExtra(AppConstant.DATA_QUIZ);
        mAmount = intent.getDoubleExtra(AppConstant.TXN_AMOUNT, 0);
        mOldGroupId = intent.getStringExtra(AppConstant.ID);
        mIsFree = mBattleDetails.isFree();
    }

    @Override
    protected void initVariables() {
        mPresenter = new BattlePresenter(this);
        mBattleGroupAdapter = new SelectGroupAdapter(mGroupList);
        mGroupRV.setLayoutManager(new LinearLayoutManager(this));
        mGroupRV.setAdapter(mBattleGroupAdapter);
        mBattleGroupAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override
    public void onGetBattleListComplete(BattleResponse responseModel) {
    }

    @Override
    public void onGetBattleListFailure(ApiError error) {
    }

    @Override
    public void onGetGroupListComplete(BattleGroupResponse responseModel) {
    }

    @Override
    public void onGetGroupListFailure(ApiError error) {
    }

    @Override
    public void onJoinComplete(BaseResponse responseModel) {
    }

    @Override
    public void onJoinFailure(ApiError error) {
    }

    @Override
    public void onGetCalculationBannerComplete(BannerResponse responseModel) {
    }

    @Override
    public void onGetCalculationBannerFailure(ApiError error) {
    }

    @Override
    public void onCancelComplete(BaseResponse responseModel) {
    }

    @Override
    public void onCancelFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onJoinSubstituteComplete(BaseResponse responseModel) {
        hideProgress();
        mAppPreference.setBoolean(AppConstant.GROUP_JOINED, true);
        if (responseModel.isStatus()) {
            showMsg(getString(R.string.text_group_joined_success));
        } else {
            AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);
        }
    }

    @Override
    public void onJoinSubstituteFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onItemClick(View view, int position, int tag) {
        mBattleGroupAdapter.setSelectedIndex(position);
        mBattleGroupAdapter.notifyDataSetChanged();
        mGroupId = mGroupList.get(position).getId();
        new JoinBattleDialog(this, onJoinGroupListener, position, mBattleInvestment, mGroupList.get(position).getInvestedAmount(), mGroupJoined, mAmount, 2, 0, mIsFree);
    }

    private IOnJoinBattleListener onJoinGroupListener = new IOnJoinBattleListener() {
        @Override
        public void onJoinBattleListener(double amount) {
            showProgress(getString(R.string.txt_progress_authentication));
            JoinGroupSubstituteRequest joinGroupSubstituteRequest = new JoinGroupSubstituteRequest();
            joinGroupSubstituteRequest.setNewGroup(mGroupId);
            joinGroupSubstituteRequest.setOldGroup(mOldGroupId);
            mPresenter.joinGroupForSubstitute(joinGroupSubstituteRequest);
        }

        @Override
        public void onCancelBattleListener(int position) {
            mBattleGroupAdapter.setSelectedIndex(-1);
            mBattleGroupAdapter.notifyDataSetChanged();
        }
    };

    public void showMsg(String msg) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.popup);
        TextView tv_msg = dialog.findViewById(R.id.tv_msg);
        tv_msg.setText(msg);
        Button okBTN = dialog.findViewById(R.id.btn_ok);
        okBTN.setOnClickListener(arg0 -> {
            dialog.dismiss();
            finish();
        });
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();

    }

}