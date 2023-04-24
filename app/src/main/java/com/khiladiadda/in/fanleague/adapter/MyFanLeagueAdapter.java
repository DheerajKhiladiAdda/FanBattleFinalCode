package com.khiladiadda.in.fanleague.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.khiladiadda.in.R;
import com.khiladiadda.in.interfaces.IOnItemClickListener;
import com.khiladiadda.in.network.model.response.FBTeamDetails;
import com.khiladiadda.in.network.model.response.MatchDetails;
import com.khiladiadda.in.utility.AppUtilityMethods;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFanLeagueAdapter extends RecyclerView.Adapter<MyFanLeagueAdapter.PersonViewHolder> {

    private List<MatchDetails> mMatchList;
    private IOnItemClickListener mOnItemClickListener;
    private boolean mLive, mUpcoming;

    public MyFanLeagueAdapter(List<MatchDetails> mEventList, boolean live, boolean upcoming, boolean past) {
        this.mMatchList = mEventList;
        this.mLive = live;
        this.mUpcoming = upcoming;
    }

    public void setOnItemClickListener(IOnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    private MatchDetails getItemAt(int index) {
        return mMatchList.get(index);
    }

    @Override
    public int getItemCount() {
        return mMatchList.size();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_match, viewGroup, false);
        return new PersonViewHolder(v, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        MatchDetails details = getItemAt(position);
        if (details.getPlayers() != null && details.getPlayers().getHomeTeam() != null) {
            FBTeamDetails homeTeam = details.getPlayers().getHomeTeam().getTeamDetails();
            personViewHolder.mTeamOneTV.setText(homeTeam.getName());
            if (!TextUtils.isEmpty(homeTeam.getLogoUrl())) {
                Glide.with(personViewHolder.mOneIV.getContext()).load(homeTeam.getLogoUrl()).placeholder(R.mipmap.ic_launcher).into(personViewHolder.mOneIV);
            } else {
                Glide.with(personViewHolder.mOneIV.getContext()).clear(personViewHolder.mOneIV);
                personViewHolder.mOneIV.setImageResource(R.mipmap.ic_launcher);
            }
        } else {
            personViewHolder.mTeamOneTV.setText("");
            personViewHolder.mOneIV.setImageResource(R.mipmap.ic_launcher);
        }
        if (details.getPlayers() != null && details.getPlayers().getAwayTeam() != null) {
            FBTeamDetails awayTeam = details.getPlayers().getAwayTeam().getTeamDetails();
            personViewHolder.mTeamTwoTV.setText(awayTeam.getName());
            if (!TextUtils.isEmpty(awayTeam.getLogoUrl())) {
                Glide.with(personViewHolder.mTwoIV.getContext()).load(awayTeam.getLogoUrl()).placeholder(R.mipmap.ic_launcher).into(personViewHolder.mTwoIV);
            } else {
                Glide.with(personViewHolder.mTwoIV.getContext()).clear(personViewHolder.mTwoIV);
                personViewHolder.mTwoIV.setImageResource(R.mipmap.ic_launcher);
            }
        } else {
            personViewHolder.mTeamTwoTV.setText("");
            personViewHolder.mTwoIV.setImageResource(R.mipmap.ic_launcher);
        }
        personViewHolder.mDateTV.setText(AppUtilityMethods.getConvertDateMatch(details.getStartDateTime()));
        personViewHolder.mNameTV.setText(details.getSeries().getName());
        if (mUpcoming) {
            personViewHolder.mScoreTV.setVisibility(View.GONE);
            personViewHolder.mTimeLeftTV.setVisibility(View.VISIBLE);
            personViewHolder.mTimeLeftTV.setText("Starts In: " + AppUtilityMethods.getBattleRemainingTime(details.getStartDateTime()));
            personViewHolder.mTimeLeftTV.setTextColor(personViewHolder.mTimeLeftTV.getResources().getColor(R.color.light_gray));
        } else if (mLive) {
            personViewHolder.mTimeLeftTV.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(details.getScore())) {
                personViewHolder.mScoreTV.setVisibility(View.VISIBLE);
                personViewHolder.mScoreTV.setText(details.getScore());
            }
            if (details.isInReview()) {
                personViewHolder.mTimeLeftTV.setText(R.string.text_in_review);
                personViewHolder.mTimeLeftTV.setTextColor(personViewHolder.mTimeLeftTV.getResources().getColor(R.color.battle_red));
            } else {
                personViewHolder.mTimeLeftTV.setText(R.string.text__live);
                personViewHolder.mTimeLeftTV.setTextColor(personViewHolder.mTimeLeftTV.getResources().getColor(R.color.color_green));
            }
        } else {
            personViewHolder.mScoreTV.setVisibility(View.GONE);
            personViewHolder.mTimeLeftTV.setTextColor(personViewHolder.mTimeLeftTV.getResources().getColor(R.color.color_green));
            if (details.getWinning() > 0) {
                personViewHolder.mTimeLeftTV.setVisibility(View.VISIBLE);
                personViewHolder.mTimeLeftTV.setText("You WON ₹" + new DecimalFormat("##.##").format(details.getWinning()));
            } else {
                personViewHolder.mTimeLeftTV.setVisibility(View.GONE);
            }
            personViewHolder.mTimeLeftTV.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check, 0, 0, 0);
        }
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_one)
        ImageView mOneIV;
        @BindView(R.id.iv_two)
        ImageView mTwoIV;
        @BindView(R.id.tv_team_one)
        TextView mTeamOneTV;
        @BindView(R.id.tv_team_two)
        TextView mTeamTwoTV;
        @BindView(R.id.tv_date)
        TextView mDateTV;
        @BindView(R.id.tv_name)
        TextView mNameTV;
        @BindView(R.id.tv_time_left)
        TextView mTimeLeftTV;
        @BindView(R.id.tv_score)
        TextView mScoreTV;

        private IOnItemClickListener mOnItemClickListener;

        public PersonViewHolder(View itemView, IOnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mOnItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getBindingAdapterPosition(), 0);
            }
        }
    }

}