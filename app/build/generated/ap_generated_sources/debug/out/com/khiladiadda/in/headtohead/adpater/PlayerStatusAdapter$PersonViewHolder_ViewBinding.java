// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.adpater;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerStatusAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private PlayerStatusAdapter.PersonViewHolder target;

  @UiThread
  public PlayerStatusAdapter$PersonViewHolder_ViewBinding(
      PlayerStatusAdapter.PersonViewHolder target, View source) {
    this.target = target;

    target.mProfileIV = Utils.findRequiredViewAsType(source, R.id.iv_profile, "field 'mProfileIV'", ImageView.class);
    target.mNameTV = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mNameTV'", TextView.class);
    target.mOneRunScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_one_run_score, "field 'mOneRunScoreTV'", TextView.class);
    target.mFourScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_four_score, "field 'mFourScoreTV'", TextView.class);
    target.mSixScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_six_score, "field 'mSixScoreTV'", TextView.class);
    target.mFiftyScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_fifty_score, "field 'mFiftyScoreTV'", TextView.class);
    target.mHundredScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_hundred_score, "field 'mHundredScoreTV'", TextView.class);
    target.mStumpScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_stump_score, "field 'mStumpScoreTV'", TextView.class);
    target.mDirectHitScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_directhit_score, "field 'mDirectHitScoreTV'", TextView.class);
    target.mRunoutScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_runout_score, "field 'mRunoutScoreTV'", TextView.class);
    target.mLbwScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_lbw_score, "field 'mLbwScoreTV'", TextView.class);
    target.mCatchStumpScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_catchstump_score, "field 'mCatchStumpScoreTV'", TextView.class);
    target.mThreeWicketScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_three_wicket_score, "field 'mThreeWicketScoreTV'", TextView.class);
    target.mFiveWicketScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_five_wicket_score, "field 'mFiveWicketScoreTV'", TextView.class);
    target.mCatchOnFieldScoreTV = Utils.findRequiredViewAsType(source, R.id.tv_catchonfield_score, "field 'mCatchOnFieldScoreTV'", TextView.class);
    target.mOneRunTV = Utils.findRequiredViewAsType(source, R.id.tv_one_run, "field 'mOneRunTV'", TextView.class);
    target.mFourTV = Utils.findRequiredViewAsType(source, R.id.tv_four, "field 'mFourTV'", TextView.class);
    target.mSixTV = Utils.findRequiredViewAsType(source, R.id.tv_six, "field 'mSixTV'", TextView.class);
    target.mFiftyTV = Utils.findRequiredViewAsType(source, R.id.tv_fifty, "field 'mFiftyTV'", TextView.class);
    target.mHundredTV = Utils.findRequiredViewAsType(source, R.id.tv_hundred, "field 'mHundredTV'", TextView.class);
    target.mStumpTV = Utils.findRequiredViewAsType(source, R.id.tv_stump, "field 'mStumpTV'", TextView.class);
    target.mDirectHitTV = Utils.findRequiredViewAsType(source, R.id.tv_directhit, "field 'mDirectHitTV'", TextView.class);
    target.mRunOutTV = Utils.findRequiredViewAsType(source, R.id.tv_rumout, "field 'mRunOutTV'", TextView.class);
    target.mLbwBowledTV = Utils.findRequiredViewAsType(source, R.id.tv_lbw_bowled, "field 'mLbwBowledTV'", TextView.class);
    target.mCatchStumpTV = Utils.findRequiredViewAsType(source, R.id.tv_catch_stumpout, "field 'mCatchStumpTV'", TextView.class);
    target.mThreeWicketTV = Utils.findRequiredViewAsType(source, R.id.tv_three_wicket, "field 'mThreeWicketTV'", TextView.class);
    target.mFiveWicketTV = Utils.findRequiredViewAsType(source, R.id.tv_five_wicket, "field 'mFiveWicketTV'", TextView.class);
    target.mCatchOnfieldTV = Utils.findRequiredViewAsType(source, R.id.tv_catch, "field 'mCatchOnfieldTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayerStatusAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProfileIV = null;
    target.mNameTV = null;
    target.mOneRunScoreTV = null;
    target.mFourScoreTV = null;
    target.mSixScoreTV = null;
    target.mFiftyScoreTV = null;
    target.mHundredScoreTV = null;
    target.mStumpScoreTV = null;
    target.mDirectHitScoreTV = null;
    target.mRunoutScoreTV = null;
    target.mLbwScoreTV = null;
    target.mCatchStumpScoreTV = null;
    target.mThreeWicketScoreTV = null;
    target.mFiveWicketScoreTV = null;
    target.mCatchOnFieldScoreTV = null;
    target.mOneRunTV = null;
    target.mFourTV = null;
    target.mSixTV = null;
    target.mFiftyTV = null;
    target.mHundredTV = null;
    target.mStumpTV = null;
    target.mDirectHitTV = null;
    target.mRunOutTV = null;
    target.mLbwBowledTV = null;
    target.mCatchStumpTV = null;
    target.mThreeWicketTV = null;
    target.mFiveWicketTV = null;
    target.mCatchOnfieldTV = null;
  }
}
