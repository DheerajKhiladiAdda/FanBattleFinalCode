package com.khiladiadda.in.wallet;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.khiladiadda.in.R;
import com.khiladiadda.in.dialogs.interfaces.IOnPaymentWaitListener;

public class PaymentWaitDialog extends Dialog {

    private static final int COUNTDOWN_TIME = 10;
    private int mTimerValue = COUNTDOWN_TIME;
    private Handler mHandler = new Handler();

    private final IOnPaymentWaitListener mOnPaymentWaitListener;
    private final Context mContext;

    public PaymentWaitDialog(@NonNull Context context, IOnPaymentWaitListener onPaymentWaitListener) {
        super(context);
        this.mContext = context;
        this.mOnPaymentWaitListener = onPaymentWaitListener;
        init();
    }

    private void init() {
        initDialog();
        initViews();
        show();
    }

    private void initDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_wait);
        getWindow().setBackgroundDrawableResource(R.color.colorTransparent);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void initViews() {
        startUpdateQuizTimer();
    }

    public void startUpdateQuizTimer() {
        mHandler.postDelayed(mQuizTimerRunnable, 1000);
    }

    public void stopQuizTimer() {
        mHandler.removeCallbacksAndMessages(null);
    }

    private final Runnable mQuizTimerRunnable = new Runnable() {
        @Override
        public void run() {
            if (mTimerValue < 0) {
                stopQuizTimer();
                mOnPaymentWaitListener.onPaymentWaitComplete();
                cancel();
            } else {
                mTimerValue--;
                startUpdateQuizTimer();
            }
        }
    };
    public void dialogcancel(){
        stopQuizTimer();
        cancel();
    }


}