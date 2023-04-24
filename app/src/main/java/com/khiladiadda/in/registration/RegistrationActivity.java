package com.khiladiadda.in.registration;

import static com.khiladiadda.in.utility.AppConstant.RC_ASK_PERMISSIONS_GPS;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.login.LoginActivity;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.otp.OtpActivity;
import com.khiladiadda.in.registration.interfaces.IRegistrationView;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;

public class RegistrationActivity extends BaseActivity implements IRegistrationView {
    @BindView(R.id.et_name)
    EditText mNameET;
    @BindView(R.id.et_mobile)
    EditText mMobileET;
    @BindView(R.id.et_reference_code)
    EditText mReferenceET;
    @BindView(R.id.cb_terms)
    CheckBox mTermCB;
    @BindView(R.id.btn_next)
    Button mNextBTN;
    @BindView(R.id.tv_terms)
    TextView mTermTV;
    @BindView(R.id.ll_need_support)
    LinearLayout mNeedSupportLL;
    @BindView(R.id.tv_user)
    TextView mExistingUserTV;
    private int mFrom;

    @BindView(R.id.cb_resp_gaming)
    CheckBox mResponsibleGamingCB;

    private RegistrationPresenter mPresenter;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected int getContentView() {
        return R.layout.activity_new_registration;
    }

    @Override
    protected void initViews() {
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        mNextBTN.setOnClickListener(this);
        mTermTV.setOnClickListener(this);
        mNeedSupportLL.setOnClickListener(this);
        mExistingUserTV.setOnClickListener(this);
        String s = getString(R.string.text_terms);
        SpannableString content = new SpannableString(s);
        content.setSpan(new ForegroundColorSpan(Color.RED), 13, s.length() - 20, 0);
        content.setSpan(new UnderlineSpan(), 13, s.length() - 20, 0);
        mTermTV.setText(content);
        SpannableString signupString = new SpannableString(mExistingUserTV.getText().toString());
        signupString.setSpan(new UnderlineSpan(), 15, mExistingUserTV.length(), 0);
        mExistingUserTV.setText(signupString);
    }

    @Override
    protected void initVariables() {
        mPresenter = new RegistrationPresenter(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                mFrom = 1;
                mPresenter.validateData();
                break;
            case R.id.tv_terms:
                Uri uri = Uri.parse("https://www.khiladiadda.com/terms-and-condition");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.ll_need_support:
                openWhatsappContact();
                break;
            case R.id.tv_user:
                /*TODO*/
                //onBackPressed();
                Intent login=new Intent(this,LoginActivity.class);
                login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(login);
                finish();
                break;
        }
    }

    @Override
    public String getName() {
        return mNameET.getText().toString().trim();
    }

    @Override
    public String getMobileNumber() {
        return mMobileET.getText().toString().trim();
    }

    @Override
    public String getReferenceNo() {
        return mReferenceET.getText().toString().trim();
    }

    @Override
    public void onValidationComplete() {
        if (isLocationEnabled()) {
            if (checkPermissions()) {
                getLastLocation();
            } else {
                AppUtilityMethods.showLocationPermisisionMsg(this, "", false);
            }
        } else {
            statusCheck();
        }
    }

    @Override
    public void onValidationFailure(String errorMsg) {
        AppUtilityMethods.showMsg(this, errorMsg, false);
    }

    @Override
    public void onRegisterComplete(BaseResponse responseModel){
        hideProgress();
        if (responseModel.isStatus()) {
            Intent otp=new Intent(this,OtpActivity.class);
            otp.putExtra(AppConstant.FROM,AppConstant.FROM_REGISTRATION_OTP);
            otp.putExtra(AppConstant.MobileNumber,mMobileET.getText().toString());
            startActivity(otp);
            finish();
        } else {
            Snackbar.make(mNextBTN,responseModel.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRegisterFailure(ApiError error) {
        hideProgress();
        AppUtilityMethods.showMsg(this, error.getMessage(), false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       /* Intent login=new Intent(this,LoginActivity.class);
        startActivity(login);
        finish();*/
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == AppConstant.RC_ASK_PERMISSIONS_MSG) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.txt_read_sms_permission), Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void openWhatsappContact() {
        String url = "https://wa.me/91" + mAppPreference.getSupportNumber() + "" + "?text=Hello%20I%20have%20a%20problem";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    //Location
    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (checkPermissions()) {
            // check if location is enabled
            if (isLocationEnabled()) {
                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            checkAddress(location.getLatitude(), location.getLongitude());
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {
        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);
        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            checkAddress(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    };

    private void checkAddress(double latitude, double longitude) {
        Geocoder gcd = new Geocoder(this, Locale.getDefault());
        String state = "";
        String country = "";
        try {
            List<Address> addresses = gcd.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
            }
        } catch (Exception ignored) {
        }
        if (country.equalsIgnoreCase("India")) {
            //Andhra Pradesh, Assam, Orissa, Telangana, Tamil Nadu, Sikkim, Meghalaya, Nagaland
            if (state.equalsIgnoreCase("Andhra Pradesh") || state.equalsIgnoreCase("AndhraPradesh") || state.equalsIgnoreCase("Assam") || state.equalsIgnoreCase("Orissa") || state.equalsIgnoreCase("Telangana") || state.equalsIgnoreCase("TamilNadu") || state.equalsIgnoreCase("Tamil Nadu") || state.equalsIgnoreCase("Sikkim") || state.equalsIgnoreCase("Meghalaya") || state.equalsIgnoreCase("Nagaland")) {
                AppUtilityMethods.showJoinMsg(this, AppConstant.TEXT_BANNED, false);
            } else {
                if (mFrom == 1) {
                    if (mTermCB.isChecked()) {
                        if (mResponsibleGamingCB.isChecked()) {
                            if (new NetworkStatus(this).isInternetOn()) {
                                showProgress(getString(R.string.txt_progress_authentication));
                                mPresenter.doRegister();
                            } else {
                                Snackbar.make(mNextBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
                            }
                        } else {
                            Snackbar.make(mNextBTN, R.string.text_select_resp_gaming, Snackbar.LENGTH_SHORT).show();
                        }
                    } else {
                        Snackbar.make(mNextBTN, R.string.text_select_term_condition, Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    mFrom = 2;
                }
            }
        } else {
            AppUtilityMethods.showJoinMsg(this, AppConstant.TEXT_BANNED_COUNTRY, false);
        }
    }

    //method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    // method to request for permissions
    private void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, RC_ASK_PERMISSIONS_GPS);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    public void statusCheck() {
        try {
            final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                buildAlertMessageNoGps();
            } else {
                getLastLocation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        try {
            builder.setMessage("Location Required\nWe need to insure this game is allowed in your state of residence.\nPlease allow to access your location for the first time.")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}