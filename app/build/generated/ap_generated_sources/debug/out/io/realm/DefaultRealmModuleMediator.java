package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(3);
        modelClasses.add(com.khiladiadda.in.network.model.response.PointDetails.class);
        modelClasses.add(com.khiladiadda.in.network.model.response.FactsList.class);
        modelClasses.add(com.khiladiadda.in.network.model.request.NotificationModel.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(3);
        infoMap.put(com.khiladiadda.in.network.model.response.PointDetails.class, io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.khiladiadda.in.network.model.response.FactsList.class, io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.khiladiadda.in.network.model.request.NotificationModel.class, io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            return io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            return io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            return io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            return "PointDetails";
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            return "FactsList";
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            return "NotificationModel";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
                return clazz.cast(new io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy());
            }
            if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
                return clazz.cast(new io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy());
            }
            if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
                return clazz.cast(new io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.PointDetailsColumnInfo columnInfo = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.copyOrUpdate(realm, columnInfo, (com.khiladiadda.in.network.model.response.PointDetails) obj, update, cache, flags));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            com_khiladiadda_in_network_model_response_FactsListRealmProxy.FactsListColumnInfo columnInfo = (com_khiladiadda_in_network_model_response_FactsListRealmProxy.FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.copyOrUpdate(realm, columnInfo, (com.khiladiadda.in.network.model.response.FactsList) obj, update, cache, flags));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.NotificationModelColumnInfo columnInfo = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.khiladiadda.in.network.model.request.NotificationModel) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insert(realm, (com.khiladiadda.in.network.model.response.PointDetails) object, cache);
        } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insert(realm, (com.khiladiadda.in.network.model.response.FactsList) object, cache);
        } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insert(realm, (com.khiladiadda.in.network.model.request.NotificationModel) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
                io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insert(realm, (com.khiladiadda.in.network.model.response.PointDetails) object, cache);
            } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
                io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insert(realm, (com.khiladiadda.in.network.model.response.FactsList) object, cache);
            } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
                io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insert(realm, (com.khiladiadda.in.network.model.request.NotificationModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
                    io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
                    io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
                    io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.response.PointDetails) obj, cache);
        } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.response.FactsList) obj, cache);
        } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.request.NotificationModel) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
                io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.response.PointDetails) object, cache);
            } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
                io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.response.FactsList) object, cache);
            } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
                io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insertOrUpdate(realm, (com.khiladiadda.in.network.model.request.NotificationModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
                    io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
                    io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
                    io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.khiladiadda.in.network.model.response.PointDetails.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createDetachedCopy((com.khiladiadda.in.network.model.response.PointDetails) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.response.FactsList.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy.createDetachedCopy((com.khiladiadda.in.network.model.response.FactsList) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.khiladiadda.in.network.model.request.NotificationModel.class)) {
            return clazz.cast(io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy.createDetachedCopy((com.khiladiadda.in.network.model.request.NotificationModel) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
