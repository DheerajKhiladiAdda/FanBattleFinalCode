package com.khiladiadda.in.headtohead.createbattle.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.khiladiadda.in.R;
import com.khiladiadda.in.network.model.response.hth.KaPlayerHTH;
import com.khiladiadda.in.utility.AppConstant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<KaPlayerHTH> mReviewList;

    public ReviewAdapter(List<KaPlayerHTH> mReviewList) {
        this.mReviewList = mReviewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_battle_player_selection, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KaPlayerHTH details = mReviewList.get(position);
        holder.mPlayBTN.setVisibility(View.VISIBLE);
        holder.mPlayBTN.setText("Added");
        holder.mPlayBTN.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tick, 0, 0, 0);
        holder.mPlayBTN.setBackgroundResource(R.drawable.roundborder_player_selecthth);
        holder.mPlayBTN.setTextColor((ContextCompat.getColor(holder.itemView.getContext(), R.color.white)));
        holder.mNameTV.setText(details.getTitle());
        if (!TextUtils.isEmpty(details.getImg()) && details.getImg().startsWith("https")) {
            Glide.with(holder.mProfileIV.getContext()).load(details.getImg()).placeholder(R.drawable.profile).into(holder.mProfileIV);
        } else {
            Glide.with(holder.mProfileIV.getContext()).clear(holder.mProfileIV);
            holder.mProfileIV.setImageResource(R.mipmap.ic_launcher);
        }
        holder.mPRoleTV.setBackgroundResource(R.drawable.ic_playerbackground);
        holder.mTeamNameTV.setText(details.getTeamName());
        if (details.getRole() == AppConstant.PLAYER_BATSMAN) {
            holder.mPRoleTV.setText("Batsman");
        } else if (details.getRole() == AppConstant.PLAYER_BOWLER) {
            holder.mPRoleTV.setText("Bowler");
        } else if (details.getRole() == AppConstant.PLAYER_ALL_ROUNDER) {
            holder.mPRoleTV.setText("All Rounder");
        } else {
            holder.mPRoleTV.setText("WK");
        }
        holder.mPlayerLL.setVisibility(View.VISIBLE);
        holder.mStatusTV.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mReviewList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_profile)
        ImageView mProfileIV;
        @BindView(R.id.tv_team_name)
        TextView mTeamNameTV;
        @BindView(R.id.tv_name)
        TextView mNameTV;
        @BindView(R.id.btn_play)
        Button mPlayBTN;
        @BindView(R.id.tv_status)
        TextView mStatusTV;
        @BindView(R.id.ll_player)
        LinearLayout mPlayerLL;
        @BindView(R.id.tv_playerrole)
        TextView mPRoleTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
