package com.khiladiadda.in.rummy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.interfaces.IOnItemClickListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.RummyHistoryMainResponse;
import com.khiladiadda.in.rummy.adapter.RummyHistoryAdapter;
import com.khiladiadda.in.rummy.interfaces.IRummyHistoryPresenter;
import com.khiladiadda.in.rummy.interfaces.IRummyHistoryView;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import butterknife.BindView;
public class RummyHistoryActivity extends BaseActivity implements IRummyHistoryView,IOnItemClickListener {
    @BindView(R.id.tv_history)
    TextView mHistoryIv;
    @BindView(R.id.rv_rummy_history)
    RecyclerView mRummyHistoryRv;
    @BindView(R.id.iv_back)
    ImageView mBackIv;
    @BindView(R.id.tv_error)
    TextView mErrorTv;
    @BindView(R.id.tv_activity_name)
    TextView mActivityName;
    private IRummyHistoryPresenter mPresenter;
    private RummyHistoryAdapter rummyHistoryAdapter;
    private RummyHistoryMainResponse dataResponse;

    @Override
    protected int getContentView() {
        return R.layout.activity_rummy_history;
    }

    @Override
    protected void initViews() {
        mPresenter = new RummyHistoryPresenter(this);
        mHistoryIv.setVisibility(View.GONE);
        mBackIv.setOnClickListener(this);
        mActivityName.setText("Transactions");
        mRummyHistoryRv.setLayoutManager(new LinearLayoutManager(this));
//        rummyHistoryAdapter = new RummyHistoryAdapter(this, rv_rummy_history)
    }

    @Override
    protected void initVariables() {
        getData();
    }

    @Override
    public void onClick(View p0) {
        if (p0.getId() == R.id.iv_back) {
            finish();
        }
    }

    private void getData() {
        if (new NetworkStatus(this).isInternetOn()) {
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.getRummyHistoryStatus();
        } else {
            Snackbar.make(mActivityName, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetRummyHistorySuccess(RummyHistoryMainResponse responseModel) {
        hideProgress();
        if (responseModel.isStatus()) {
            dataResponse = responseModel;
            if (responseModel.getResponse().isEmpty()) {
                mErrorTv.setVisibility(View.VISIBLE);
            } else {
                mErrorTv.setVisibility(View.GONE);
                mRummyHistoryRv.setAdapter(new RummyHistoryAdapter(this, responseModel.getResponse(), this));
            }
        }
    }

    @Override
    public void onGetRummyHistoryFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onItemClick(View view, int position, int tag) {
        Intent intent = new Intent(this, RummyLogsWebViewActivity.class);
        intent.putExtra("mid", dataResponse.getResponse().get(position).getTxnID());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        AppUtilityMethods.deleteCache(this);
        mPresenter.destroy();
        super.onDestroy();
    }

}