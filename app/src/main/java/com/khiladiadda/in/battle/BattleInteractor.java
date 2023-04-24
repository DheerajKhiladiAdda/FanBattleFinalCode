package com.khiladiadda.in.battle;

import com.khiladiadda.in.battle.model.BannerResponse;
import com.khiladiadda.in.battle.model.BattleGroupResponse;
import com.khiladiadda.in.battle.model.BattleResponse;
import com.khiladiadda.in.battle.model.JoinGroupRequest;
import com.khiladiadda.in.battle.model.JoinGroupSubstituteRequest;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;

import rx.Subscription;

public class BattleInteractor {

    public Subscription getBattle(IApiListener<BattleResponse> listener, String id, boolean isPlayed, boolean live, boolean past) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getBattleList(id, isPlayed, live, past)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getGroup(IApiListener<BattleGroupResponse> listener, String id, boolean is_reverse,boolean profile) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getGroupList(id, is_reverse,profile)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription joinGroup(IApiListener<BaseResponse> listener, JoinGroupRequest request, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.joinBattleGroup(request, id)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getCalculationBanner(IApiListener<BannerResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getBanner(6)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription cancelGroup(IApiListener<BaseResponse> listener, String groupId) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.cancelGroup(groupId)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription joinSubstituteGroup(IApiListener<BaseResponse> listener, JoinGroupSubstituteRequest request) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.joinSubstituteGroup(request)).subscribe(new SubscriberCallback<>(listener));
    }


}