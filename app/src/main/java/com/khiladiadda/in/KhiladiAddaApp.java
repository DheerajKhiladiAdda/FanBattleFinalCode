package com.khiladiadda.in;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.khiladiadda.in.preference.AppSharedPreference;
import com.khiladiadda.in.utility.AppConstant;

import java.util.Map;
import java.util.Objects;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.realm.Realm;
import io.realm.RealmConfiguration;
public class KhiladiAddaApp extends Application {
    private static KhiladiAddaApp sInstance;
    private AppSharedPreference mAppPreference;
    public KhiladiAddaApp() {
        sInstance = this;
    }
    public static KhiladiAddaApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder().addInterceptor(new CalligraphyInterceptor(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/ProductSans_Regular.ttf").setFontAttrId(R.attr.fontPath).build())).build());
        AppSharedPreference.initialize(this);
        mAppPreference = AppSharedPreference.getInstance();
        mAppPreference.setIsDeepLinking(false);
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME).schemaVersion(0).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        Realm.getInstance(realmConfiguration).close();

        //Appflyer
        /*Apps Flyer * */
        AppsFlyerConversionListener conversionListener=new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionDataMap) {
                for (String attrName : conversionDataMap.keySet())
                    Log.d("LOG_TAG", "Conversion attribute: " + attrName + " = " + conversionDataMap.get(attrName));
                String status = Objects.requireNonNull(conversionDataMap.get("af_status")).toString();
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
            }
        };
        AppsFlyerLib.getInstance().start(getApplicationContext(), AppConstant.APPSKEY, new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(int i, @NonNull String s) {
            }
        });
        AppsFlyerLib.getInstance().setCustomerIdAndLogSession(mAppPreference.getProfileData().getId(), this);
        AppsFlyerLib.getInstance().init(AppConstant.APPSKEY, conversionListener, this);
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().start(this);
        AppsFlyerLib.getInstance().subscribeForDeepLink(deepLinkResult -> {
            DeepLinkResult.Status dlStatus = deepLinkResult.getStatus();
            if (dlStatus == DeepLinkResult.Status.FOUND) {
            } else if (dlStatus == DeepLinkResult.Status.NOT_FOUND) {
                mAppPreference.setIsDeepLinking(false);
                return;
            } else {
                DeepLinkResult.Error dlError = deepLinkResult.getError();
                return;
            }
            DeepLink deepLinkObj = deepLinkResult.getDeepLink();
            String fruitName = "";
            try {
                fruitName=deepLinkObj.getDeepLinkValue();
                if (fruitName==null) {
                    // Log.d(LOG_TAG, "Deeplink value returned null");
                    mAppPreference.setIsDeepLinking(false);
                    return;
                }  //  Log.d(LOG_TAG, "The DeepLink will route to: " + fruitName);
            } catch (Exception e) {
                mAppPreference.setIsDeepLinking(false);
                return;
            }
            if (mAppPreference.getIsLogin()) {
                goToFruit(fruitName, deepLinkObj);
            }
        });
    }

    private void goToFruit(String fruitName, DeepLink dlData) {
        String id = null;
        if (dlData != null) {
            id = dlData.getStringValue("id");
        }
        switch (fruitName){
            case AppConstant.LEADERBOARD:
              /*  setBoolString(true,NewLeaderboardActivity.class, AppConstant.FROM_MAIN, null);
                break;
            case AppConstant.FANMATCHCREEN:
                setBool(true, FanBattleActivity.class, 0, null, null);
                break;*/
            /*case AppConstant.MYLEAGUE:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESFF, null, null);
                break;
            case AppConstant.MYLEAGUETDM:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESTDM, null, null);
                break;
            case AppConstant.MYLEAGUEBGMI:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESBGMI, null, null);
                break;
            case AppConstant.MYLEAGUEFCS:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESFCS, null, null);
                break;
            case AppConstant.MYLEAGUEFFMAX:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESFFMAX, null, null);
                break;
            case AppConstant.MYLEAGUEPE:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUESPE, null, null);
                break;
            case AppConstant.MYLEAGUEPG:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEAGUESPG, null, null);
                break;
            case AppConstant.MYLEAGUEPN:
                setBool(true, MyLeagueActivity.class, AppConstant.FROM_APPFLYER_FORMYLEGUEPGNS, null, null);
                break;
            case AppConstant.QUIZONLY:
                setBool(true, QuizDetailsActivity.class, 0, null, null);
                break;*/
            default:
                setBool(false, null, 0, null, null);
                setBoolString(false, null, null, null);
                break;
        }
    }

    private void setBool(Boolean mBool, Class mActivity, int mFrom, String mCategory, String mGameid) {
        Intent i;
        mAppPreference.setIsDeepLinking(mBool);
        i = new Intent(getApplicationContext(), mActivity);
        i.putExtra(AppConstant.FROM, mFrom);
        i.putExtra(AppConstant.CATEGORY, mCategory);
        i.putExtra(AppConstant.GAMEID, mGameid);
        i.putExtra(AppConstant.CONTEST_TYPE, AppConstant.TYPE_LUDO);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    private void setBoolString(Boolean mBool, Class mActivity, String mFrom, String mCategory) {
        Intent i;
        mAppPreference.setIsDeepLinking(mBool);
        i = new Intent(getApplicationContext(), mActivity);
        i.putExtra(AppConstant.FROM, mFrom);
        i.putExtra(AppConstant.CATEGORY, mCategory);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

}
