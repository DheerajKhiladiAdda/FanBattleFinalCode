// Generated code from Butter Knife. Do not modify!
package com.khiladiadda.in.help.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.khiladiadda.in.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelpAdapter$PersonViewHolder_ViewBinding implements Unbinder {
  private HelpAdapter.PersonViewHolder target;

  @UiThread
  public HelpAdapter$PersonViewHolder_ViewBinding(HelpAdapter.PersonViewHolder target,
      View source) {
    this.target = target;

    target.mQuestionTV = Utils.findRequiredViewAsType(source, R.id.tv_question, "field 'mQuestionTV'", TextView.class);
    target.mAnswerTV = Utils.findRequiredViewAsType(source, R.id.tv_answer, "field 'mAnswerTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HelpAdapter.PersonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mQuestionTV = null;
    target.mAnswerTV = null;
  }
}
