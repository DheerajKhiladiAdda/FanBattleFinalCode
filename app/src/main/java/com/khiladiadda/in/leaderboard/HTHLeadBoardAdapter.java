package com.khiladiadda.in.leaderboard;

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
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponseDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HTHLeadBoardAdapter extends RecyclerView.Adapter<HTHLeadBoardAdapter.ViewHolder> {

    private List<LeaderBoardHthResponseDetails> overallLeadBoardLists;

    public HTHLeadBoardAdapter(List<LeaderBoardHthResponseDetails> overallLeadBoardLists) {
        this.overallLeadBoardLists = overallLeadBoardLists;
    }

    @NonNull
    @Override
    public HTHLeadBoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HTHLeadBoardAdapter.ViewHolder holder, int position) {
        LeaderBoardHthResponseDetails details = overallLeadBoardLists.get(position);
        holder.mNameTV.setText(String.valueOf(details.getName()));
        if (!TextUtils.isEmpty(String.valueOf(details.getnCof().getWon()))) {
            holder.mScoreTV.setText("Won: " + details.getTotal() + " Coins");
        } else {
            holder.mScoreTV.setText("Won: 0 Coins");
        }
        if (!TextUtils.isEmpty(details.getDp())) {
            Glide.with(holder.mProfileIV.getContext()).load(details.getDp()).placeholder(R.mipmap.ic_launcher).into(holder.mProfileIV);
        } else {
            Glide.with(holder.mProfileIV.getContext()).clear(holder.mProfileIV);
            holder.mProfileIV.setImageResource(R.mipmap.ic_launcher);
        }
        int rank = 0;
        rank = position + 4;
        holder.mRankTV.setText("#" + rank);
    }

    @Override
    public int getItemCount() {
        return overallLeadBoardLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mNameTV;
        @BindView(R.id.tv_score)
        TextView mScoreTV;
        @BindView(R.id.tv_username)
        TextView mUsernameTV;
        @BindView(R.id.iv_profile)
        ImageView mProfileIV;
        @BindView(R.id.tv_rank)
        TextView mRankTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
