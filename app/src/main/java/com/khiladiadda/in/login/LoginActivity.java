package com.khiladiadda.in.login;
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
import android.os.Build;
import android.os.Bundle;
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

import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.FirebaseMessaging;
import com.khiladiadda.in.R;
import com.khiladiadda.in.base.BaseActivity;
import com.khiladiadda.in.dialogs.interfaces.IOnSocialLoginErrorListener;
import com.khiladiadda.in.forgotpassword.ForgotPasswordActivity;
import com.khiladiadda.in.login.interfaces.ILoginView;
import com.khiladiadda.in.main.MainActivity;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.GmailRegisterRequest;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.SocialResponse;
import com.khiladiadda.in.otp.OtpActivity;
import com.khiladiadda.in.preference.AppSharedPreference;
import com.khiladiadda.in.registration.RegistrationActivity;
import com.khiladiadda.in.socialverify.SocialVerifyActivity;
import com.khiladiadda.in.utility.AppConstant;
import com.khiladiadda.in.utility.AppUtilityMethods;
import com.khiladiadda.in.utility.NetworkStatus;
import com.khiladiadda.in.utility.PermissionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
public class LoginActivity extends BaseActivity implements ILoginView {
    @BindView(R.id.et_mobile)
    EditText mEmailET;
    @BindView(R.id.btn_login)
    Button mLoginBTN;
    @BindView(R.id.tv_signup)
    TextView mSignUpTV;
    @BindView(R.id.iv_fb)
    TextView mFacebookIV;
    @BindView(R.id.iv_google)
    TextView mGoogleIV;
    @BindView(R.id.ll_need_support)
    LinearLayout mNeedSupportLL;
    @BindView(R.id.tv_login_via)
    TextView mLoginViaTV;
    @BindView(R.id.cb_terms)
    CheckBox mTermCB;
    @BindView(R.id.tv_terms)
    TextView mTermTV;
    @BindView(R.id.cb_resp_gaming)
    CheckBox mResponsibleGamingCB;
    private CallbackManager mCallbackManager;
    private static int RC_SIGN_IN=101;
    private LoginPresenter mPresenter;
    private GmailRegisterRequest mGmailRequest;
    private String mFBToken;
    private FusedLocationProviderClient mFusedLocationClient;
    private int mFrom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFirebaseId();
        setUpGoogle();
        setUpFb();
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_new_login;
    }

    @Override
    protected void initViews() {
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        mLoginBTN.setOnClickListener(this);
        mFacebookIV.setOnClickListener(this);
        mSignUpTV.setOnClickListener(this);
        mGoogleIV.setOnClickListener(this);
        mNeedSupportLL.setOnClickListener(this);
        SpannableString loginviaString = new SpannableString(mLoginViaTV.getText().toString());
        loginviaString.setSpan(new UnderlineSpan(), 0, 12, 0);
        mLoginViaTV.setText(loginviaString);
        SpannableString signupString = new SpannableString(mSignUpTV.getText().toString());
        signupString.setSpan(new UnderlineSpan(), 0, mSignUpTV.length(), 0);
        mSignUpTV.setText(signupString);
        mTermTV.setOnClickListener(this);
        String s = getString(R.string.text_terms);
        SpannableString content = new SpannableString(s);
        content.setSpan(new ForegroundColorSpan(Color.RED), 13, s.length() - 20, 0);
        content.setSpan(new UnderlineSpan(), 13, s.length() - 20, 0);
        mTermTV.setText(content);
    }

    @Override
    protected void initVariables() {
        mPresenter = new LoginPresenter(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (mAppPreference.getIsVersionUpdated()) {
            showVersionDialog();
        }
        getLastLocation();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forgot_pwd:
                Intent forgotPwd = new Intent(this,ForgotPasswordActivity.class);
                forgotPwd.putExtra(AppConstant.FROM, AppConstant.FROM_FORGOT_PASSWORD);
                startActivity(forgotPwd);
                finish();
                break;
            case R.id.btn_login:
                mFrom = 1;
                mPresenter.validateData();
                break;
            case R.id.iv_fb:
                if (new NetworkStatus(this).isInternetOn()) {
                    if (mAppPreference.getBoolean(AppConstant.IS_FB_ENABLED, false)) {
                        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"));
                    } else {
                        new FBErrorDialog(this, true, onSocialLoginErrorListener);
                    }
                } else {
                    Snackbar.make(mLoginBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_google:
                if (new NetworkStatus(this).isInternetOn()) {
                    if (mAppPreference.getBoolean(AppConstant.IS_GMAIL_ENABLED, false)) {
                        googleSignIn();
                    } else {
                        new FBErrorDialog(this, false, onSocialLoginErrorListener);
                    }
                } else {
                    Snackbar.make(mLoginBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_need_support:
                openWhatsappContact();
                break;
            case R.id.tv_signup:
                startActivity(new Intent(this,RegistrationActivity.class));
                finish();
                break;
            case R.id.tv_terms:
                Uri uri = Uri.parse("https://www.khiladiadda.com/terms-and-condition");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }

    @Override
    public String getEmailAddress() {
        return mEmailET.getText().toString();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void onValidationComplete() {
        if (mTermCB.isChecked()) {
            if (mResponsibleGamingCB.isChecked()) {
                if (isLocationEnabled()) {
                    if (checkPermissions()) {
                        getLastLocation();
                    } else {
                        AppUtilityMethods.showLocationPermisisionMsg(this, "", false);
                    }
                } else {
                    statusCheck();
                }
            } else {
                Snackbar.make(mLoginBTN, R.string.text_select_resp_gaming, Snackbar.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(mLoginBTN, R.string.text_select_term_condition, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onValidationFailure(String errorMsg) {
        AppUtilityMethods.showMsg(this, errorMsg, false);
    }

    @Override
    public void onLoginComplete(BaseResponse responseModel) {
        hideProgress();
        if(responseModel.isStatus()){
            Intent otp=new Intent(this,OtpActivity.class);
            otp.putExtra(AppConstant.FROM,AppConstant.FROM_LOGIN);
            otp.putExtra(AppConstant.MobileNumber,mEmailET.getText().toString().trim());
            startActivity(otp);
            finish();
        } else {
            startActivity(new Intent(this,RegistrationActivity.class));
            finish();
           /* AppUtilityMethods.showMsg(this, responseModel.getMessage(), false);*/
        }
    }

    @Override
    public void onLoginFailure(ApiError error) {
        hideProgress();
        AppUtilityMethods.showMsg(this, error.getMessage(), false);
    }

    @Override
    public void onGmailLoginComplete(SocialResponse responseModel) {
        if (!responseModel.isStatus()) {
            hideProgress();
            openGmailVerification(mGmailRequest);
        } else {
            setData(responseModel.getJwt());
        }
    }

    @Override
    public void onGmailLoginFailure(ApiError error) {
        hideProgress();
    }

    @Override
    public void onFbLoginComplete(SocialResponse responseModel) {
        if (!responseModel.isStatus()) {
            hideProgress();
            openFBVerification(mFBToken);
        } else {
            setData(responseModel.getJwt());
        }
    }

    @Override
    public void onFbLoginFailure(ApiError error) {
        hideProgress();
    }

    private void setData(String jwt) {
        mAppPreference.setIsLogin(true);
        mAppPreference.setSessionToken(jwt);
        mPresenter.getMasterData();
    }

    @Override
    public void onMasterComplete(MasterResponse responseModel) {
        AppUtilityMethods.saveMasterData(responseModel);
        hideProgress();
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onMasterFailure(ApiError error) {
        hideProgress();
    }

    private void getFirebaseId() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        return;
                    }
                    mAppPreference.setDeviceToken(task.getResult());
                    if (!mAppPreference.getIsUUID()) {
                        mAppPreference.setString(AppConstant.UUID, AppUtilityMethods.getDeviceUniqueID(this));
                        mAppPreference.setIsUUID(true);
                    }
                });
    }

    // Set up Google
    private GoogleSignInOptions setUpGoogle() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.server_client_id)).requestEmail().requestProfile().build();
        return gso;
    }

    //Google SignIn
    private void googleSignIn() {
        Intent signInIntent = GoogleSignIn.getClient(this, setUpGoogle()).getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
//        gmailActivityResultLauncher.launch(signInIntent);
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            mGmailRequest = new GmailRegisterRequest(account.getId(), account.getDisplayName(), account.getGivenName(), account.getEmail(), String.valueOf(account.getPhotoUrl()), "", "", "", "", "");
            showProgress(getString(R.string.txt_progress_authentication));
            mPresenter.doGmailLogin(account.getId());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    // Set up Facebook
    private void setUpFb() {
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mFBToken = loginResult.getAccessToken().getToken();
                showProgress(getString(R.string.txt_progress_authentication));
                mPresenter.doFbLogin(mFBToken);
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Facebook Cancel", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openGmailVerification(GmailRegisterRequest request) {
        Intent gmail = new Intent(this, SocialVerifyActivity.class);
        gmail.putExtra(AppConstant.FROM, AppConstant.FROM_GMAIL);
        gmail.putExtra(AppConstant.DATA, request);
        startActivity(gmail);
        finish();
    }

    private void openFBVerification(String fbToken) {
        Intent fb = new Intent(this, SocialVerifyActivity.class);
        fb.putExtra(AppConstant.FROM, AppConstant.FROM_FB);
        fb.putExtra(AppConstant.DATA, fbToken);
        startActivity(fb);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            try {
                // The Task returned from this call is always completed, no need to attach
                // a listener.
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                GoogleSignInAccount account = task.getResult(ApiException.class);
                handleGoogleSignInResult(task);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        // Result returned from launching the Intent from Facebook;
        else if (mCallbackManager.onActivityResult(requestCode, resultCode, data)) {
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    private void askPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                showMessageOKCancel("You need to allow access to location permissions",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                                    intent.setData(uri);
                                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, "com.khiladiadda.in");
                                } else {
                                    intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                                    intent.setData(uri);
                                }
                                startActivity(intent);
                            }
                        });
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case AppConstant.RC_ASK_PERMISSIONS_STORAGE:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, getString(R.string.txt_storage_permission), Toast.LENGTH_SHORT).show();
                } else {
                    PermissionUtils.hasSMSReadPermission(this);
                }
                break;
            case AppConstant.RC_ASK_PERMISSIONS_MSG:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, getString(R.string.txt_read_sms_permission), Toast.LENGTH_SHORT).show();
                }
                break;
            case RC_ASK_PERMISSIONS_GPS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                } else {
                    askPermission();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", okListener)
                .create()
                .show();
    }

    private IOnSocialLoginErrorListener onSocialLoginErrorListener = new IOnSocialLoginErrorListener() {
        @Override
        public void onForgotPassword() {
            Intent forgotPwd = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            forgotPwd.putExtra(AppConstant.FROM, AppConstant.FROM_FORGOT_PASSWORD);
            startActivity(forgotPwd);
            finish();
        }

        @Override
        public void onRegister() {
            Intent forgotPwd = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(forgotPwd);
            finish();
        }
    };

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
                    if (new NetworkStatus(this).isInternetOn()) {
                        showProgress(getString(R.string.txt_progress_authentication));
                        mPresenter.doLogin(mEmailET.getText().toString().trim());
                    } else {
                        Snackbar.make(mLoginBTN, R.string.error_internet, Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    mFrom = 2;
                }
            }
        } else {
            AppUtilityMethods.showJoinMsg(this, AppConstant.TEXT_BANNED_COUNTRY, false);
        }
    }

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    // method to request for permissions
    private void requestPermissions() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}