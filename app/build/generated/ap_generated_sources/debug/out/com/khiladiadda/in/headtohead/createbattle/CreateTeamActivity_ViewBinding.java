// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.headtohead.createbattle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.khiladiadda.in.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CreateTeamActivity_ViewBinding implements Unbinder {
  private CreateTeamActivity target;

  @UiThread
  public CreateTeamActivity_ViewBinding(CreateTeamActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateTeamActivity_ViewBinding(CreateTeamActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.sliding_tabs, "field 'tabLayout'", TabLayout.class);
    target.mTeamOneIV = Utils.findRequiredViewAsType(source, R.id.iv_one, "field 'mTeamOneIV'", CircleImageView.class);
    target.mTeamTwoIV = Utils.findRequiredViewAsType(source, R.id.iv_two, "field 'mTeamTwoIV'", CircleImageView.class);
    target.mTeamOneTV = Utils.findRequiredViewAsType(source, R.id.tv_team_one, "field 'mTeamOneTV'", TextView.class);
    target.mTeamTwoTV = Utils.findRequiredViewAsType(source, R.id.tv_team_two, "field 'mTeamTwoTV'", TextView.class);
    target.mCancelBTN = Utils.findRequiredViewAsType(source, R.id.btn_cancel, "field 'mCancelBTN'", Button.class);
    target.mNextBTN = Utils.findRequiredViewAsType(source, R.id.btn_next, "field 'mNextBTN'", TextView.class);
    target.mNextRL = Utils.findRequiredViewAsType(source, R.id.rl_next, "field 'mNextRL'", RelativeLayout.class);
    target.mBatmanSelectedIV = Utils.findRequiredViewAsType(source, R.id.iv_batmanselected, "field 'mBatmanSelectedIV'", ImageView.class);
    target.mBowlSelectedIV = Utils.findRequiredViewAsType(source, R.id.iv_bowlselected, "field 'mBowlSelectedIV'", ImageView.class);
    target.mArSelectedIV = Utils.findRequiredViewAsType(source, R.id.iv_arselected, "field 'mArSelectedIV'", ImageView.class);
    target.mWkSelectedIV = Utils.findRequiredViewAsType(source, R.id.iv_wkselected, "field 'mWkSelectedIV'", ImageView.class);
    target.mALLSelectedIV = Utils.findRequiredViewAsType(source, R.id.iv_allselected, "field 'mALLSelectedIV'", ImageView.class);
    target.mBackIV = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'mBackIV'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CreateTeamActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.tabLayout = null;
    target.mTeamOneIV = null;
    target.mTeamTwoIV = null;
    target.mTeamOneTV = null;
    target.mTeamTwoTV = null;
    target.mCancelBTN = null;
    target.mNextBTN = null;
    target.mNextRL = null;
    target.mBatmanSelectedIV = null;
    target.mBowlSelectedIV = null;
    target.mArSelectedIV = null;
    target.mWkSelectedIV = null;
    target.mALLSelectedIV = null;
    target.mBackIV = null;
  }
}
