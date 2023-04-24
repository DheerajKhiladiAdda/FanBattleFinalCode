package com.khiladiadda.in.main.game;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseFragment;
import com.khiladiadda.in.fanbattle.FanBattleActivity;
import com.khiladiadda.in.headtohead.AllMatchesHTHActivity;
import com.khiladiadda.in.help.HelpActivity;
import com.khiladiadda.in.leaderboard.NewLeaderboardActivity;
import com.khiladiadda.in.main.fragment.HomeFragment;
import com.khiladiadda.in.scratchcard.ScratchCardActivity;
import com.khiladiadda.in.wallet.WalletActivity;
import butterknife.BindView;
public class GameFragment extends BaseFragment implements HomeFragment.IOnPageLoaded {
    @BindView(R.id.iv_clashx)
    ImageView mHTHIV;
    @BindView(R.id.iv_fanbattle)
    ImageView mFanbattleIV;
    @BindView(R.id.tv_gift)
    TextView mGiftTV;
    @BindView(R.id.tv_wallet)
    TextView mWalletTV;
    @BindView(R.id.tv_winner)
    TextView mWinnerTV;
    @BindView(R.id.tv_help)
    TextView mHelpTV;
    public GameFragment(){
    }
    public static Fragment getInstance(){
        return new GameFragment();
    }
    @Override
    protected int getContentView(){
        return R.layout.fragment_game;
    }
    @Override
    protected void initViews(View view){
        mHTHIV.setOnClickListener(this);
        mFanbattleIV.setOnClickListener(this);
        mGiftTV.setOnClickListener(this);
        mWalletTV.setOnClickListener(this);
        mHelpTV.setOnClickListener(this);
        mWinnerTV.setOnClickListener(this);
    }
    @Override
    protected void initBundle(Bundle bundle) {

    }
    @Override
    protected void initVariables() {
    }
    @Override
    public void onClick(View v) {
         Intent i=null;
        switch (v.getId()) {
            case R.id.tv_gift:
                i=new Intent(getActivity(),ScratchCardActivity.class);
                break;
            case R.id.tv_winner:
                i = new Intent(getActivity(),NewLeaderboardActivity.class);
                break;
            case R.id.tv_help:
                i = new Intent(getActivity(),HelpActivity.class);
                break;
            case R.id.iv_fanbattle:
                i = new Intent(getActivity(),FanBattleActivity.class);
                break;
            case R.id.iv_clashx:
                i=new Intent(getActivity(),AllMatchesHTHActivity.class);
                break;
            case R.id.tv_wallet:
                i=new Intent(getActivity(), WalletActivity.class);
                break;
        }
        startActivity(i);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}